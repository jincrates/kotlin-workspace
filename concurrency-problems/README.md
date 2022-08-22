# 예약시스템으로 통해 알아보는 동시성 문제
![Generic badge](https://img.shields.io/badge/1.6.21-kotlin-7F52FF.svg)
![Generic badge](https://img.shields.io/badge/17-OpenJDK-537E99.svg)
![Generic badge](https://img.shields.io/badge/2.7.2-SpringBoot-6DB33F.svg)
![Generic badge](https://img.shields.io/badge/5.0-JUnit-DD524A.svg)
![Generic badge](https://img.shields.io/badge/8.0-MySQL-01578B.svg)
![Generic badge](https://img.shields.io/badge/7.0.4-Redis-D82C20.svg)

<br/>

## 생각해보기
- 강의를 신청하는 프로그램을 만들고 있습니다. 강의는 최대 100명까지 예약신청할 수 있습니다.
- 개발자는 예약신청 함수를 아래와 같이 작성하였습니다. 나름의 예외사항도 고려하였고 문제가 없다고 생각하였습니다.
- 그러나 막상 소스를 배포하니, 실제 예약인원과 데이터가 맞지 않는 커다란 이슈가 터졌습니다. 왜 그랬을까요?
```
fun 예약신청(추가인원) {
  if (현재 예약인원 + 추가인원 > 100) {
    throw RuntimeException("최대 인원보다 클 수 없습니다.")
  }
  
  현재 예약인원 += 추가인원
}
```
<img width="823" alt="image" src="https://user-images.githubusercontent.com/53418946/184573384-b2abf110-5c87-41b5-907c-3cb61c2a266c.png">
<img width="820" alt="image" src="https://user-images.githubusercontent.com/53418946/184573524-ebcfacad-7a4f-427c-821f-8e6cd449c2db.png">
<br/>

## 오류의 원인: Race Condition(경쟁 상태)
경쟁 상태란 둘 이상의 입력 또는 조작의 타이밍이나 순서 등이 결과값에 영향을 줄 수 있는 상태를 말합니다.
입력 변화의 타이밍이나 순서가 예상과 다르게 작동하면 정상적인 결과가 나오지 않게 될 위험이 있는데 이를 경쟁 위험이라고 합니다.
(출처: [위키백과](https://ko.wikipedia.org/wiki/%EA%B2%BD%EC%9F%81_%EC%83%81%ED%83%9C))

<br/>

### 나의 예상 - 순차적으로 처리
Thread-1이 데이터를 select하고 update 이후, Thread-2가 데이터를 select해서 update
<img width="767" alt="스크린샷 2022-08-15 오후 1 23 28" src="https://user-images.githubusercontent.com/53418946/184576757-fe054404-b862-49bc-b7b7-8c42c8dd1862.png">

### 실제 동작 - 동시적으로 처리
- Theand-1이 select하고 update하기 이전에, Thead-2도 해당 데이터를 select 해서 update 처리
- Race Condition 발생 - 예약 신청이 2번 요청했음에도 현재 예약인원 수는 1명
<img width="761" alt="스크린샷 2022-08-15 오후 1 23 38" src="https://user-images.githubusercontent.com/53418946/184576763-455aa448-76b4-45d2-9531-72f18ace7cf6.png">

<br/>

## 문제 해결방법
하나의 Thread가 처리하기 이전에 다른 Thead가 접근하지 못하도록 처리합니다. 

### 1. MySQL - Pessimistic Lock
- 실제로 데이터에 Lock을 걸어서 정합성을 맞추는 방법입니다. exclusive lock을 걸게 되면 다른 트랜잭션에서는 lock이 해제되기 전에 데이터를 가져갈 수 없게 됩니다.  
- 데이터간 충돌이 많이 발생하는 경우 Optimictic Lock보다 성능이 좋습니다.
- 데드락(Dead Lock)이 걸릴 수 있기 때문에 주의하여 사용하여야 합니다.
- [[commit] Pessimistic Lock을 활용한 문제해결](https://github.com/jincrates/kotlin-workspace/commit/9288b9bc02bd01b16fa38faae6da760ece1859c7)


### 2. MySQL - Optimictic Lock
- 실제로 Lock을 이용하지 않고 버전(`@Version`)을 이용함으로써 정합성을 맞추는 방법입니다. 먼저 데이터를 읽은 후에 update를 수행할 때 현재 내가 읽은 버전이 맞는지 확인하며 업데이트 합니다.
- 별도의 lock을 잡는 것이 아니기 때문에 데드락에 빠질 위험이 적습니다.
- 내가 읽은 버전에서 수정사항이 생겼을 경우에는 application에서 다시 읽은 후에 작업을 수행할 수 있도록 처리해야 합니다.
- 충돌이 빈번하게 일어난다면 Pessimistic Lock 사용하는 것이 성능상 나을 수도 있습니다.
- [[commit] Optimictic Lock을 활용한 문제해결](https://github.com/jincrates/kotlin-workspace/commit/9288b9bc02bd01b16fa38faae6da760ece1859c7)


### 3. Redis - Lettuce Lock
- setnx 명령어을 활용하여 분산락 구현
- spring data redis를 이용하면 lettuce가 기본이기 때문에 별도의 라이브러리를 사용하지 않아도 됩니다.
- spin lock 방식이기 때문에 동시에 많은 쓰레드가 lock 획득 대기 상태라면 redis에 부하가 갈 수 있습니다.
- 재시도가 필요없는 경우 사용
- [[commit] Lettuce을 활용한 문제해결](https://github.com/jincrates/kotlin-workspace/commit/a7ae116c53d82518906777f219a397bdb31ae2e9)

### 4. Redis - Redisson 외부 라이브러리
- 락 획득 재시도를 기본으로 제공합니다.
- pub-sub 기반으로 구현이 되어 있기 때문에 lettuce와 비교했을 때 redis에 부하가 덜 갑니다.
- 다만 lock을 라이브러리 차원에서 제공해주기 때문에 사용법을 공부해야 합니다.
- 재시도가 필요한 경우 사용
- [[commit] Redisson을 활용한 문제해결](https://github.com/jincrates/kotlin-workspace/commit/a7ae116c53d82518906777f219a397bdb31ae2e9)

<br/>

## MySQL VS Redis

### MySQL
- 이미 MySQL을 사용하고 있다면 별도의 비용없이 사용이 가능합니다.
- 어느정도의 트래픽까지는 문제없이 활용이 가능합니다.
- Redis보다는 성능이 좋지 않습니다.

### Redis
- MySQL보다 성능이 좋습니다.
- 활용중인 Redis가 없다면 별도의 구축 비용과 인프라 관리비용이 발생합니다.

<br/>

## 결론
현재 제가 다니는 회사에서는 MSSQL을 사용하며, MSSQL에서는 기본적으로 SELECT시 LOCK이 걸리게 됩니다. 오히려 데드락 발생으로 인해 `WITH(NOLOCK)`절을 추가하여 LOCK 없이 데이터를 조회하여 성능상의 이슈를 해결해왔습니다.    
그러나 이번 동시성 문제에 대해서 공부하고 알아가면서 LOCK 중요성을 다시 한 번 알게 되었습니다. 대용량 트래픽이 발생하는 과정에서 동시성 제어를 하지 않는다면, 데이터 정합성이 맞지 않는 치명적인 오류가 발생할 수 있기 때문입니다.   
앞으로 동시성을 고려한 테스트 케이스를 하 더 늘려야겠습니다.👀 

<br/>

## 참고자료
- [인프런 강의 - 재고시스템으로 통해 알아보는 동시성이슈 해결방법](https://inf.run/1qjS)
- [JPA에서 Optimistic Lock과 Pessimistic Lock)](https://skasha.tistory.com/49)

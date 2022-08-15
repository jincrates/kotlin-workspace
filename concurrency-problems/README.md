# 예약시스템으로 통해 알아보는 동시성 문제

## 생각해보기
- 강의를 신청하는 프로그램을 만들고 있습니다. 강의는 최대 100명까지 예약신청할 수 있습니다.
- 개발자는 예약신청 함수를 아래와 같이 작성하였습니다. 나름의 예외사항도 고려하였고 문제가 없다고 생각하였습니다.
- 그러나 막상 소스를 배포하니, 예약실제 예약인원과 데이터가 맞지 않는 커다란 이슈가 터졌습니다. 왜 그랬을까요?
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

## 문제 해결방법

### MySQL - Pessimistic Lock
ㅇㅇㅇ

### MySQL - Optimictic Lock
ㅇㅇㅇ

### Redis - Lettuce Lock
ㅇㅇㅇ

### Redis - Redisson 외부 라이브러리
ㅇㅇㅇ

<br/>

## MySQL VS Redis
ㅇㅇㅇ

<br/>

## 결론
ㅇㅇㅇ

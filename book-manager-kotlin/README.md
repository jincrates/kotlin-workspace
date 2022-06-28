# 도서관리 시스템(with Kopring + JPA)

## 목적

코프링(Kotlin + Spring Boot)과 JPA를 활용하여 
사내 도서를 관리하는 프로그램을 만들어보자.

## 사용자 요구사항

### 도서

1. 도서 등록
2. 도서 수정
3. 도서 삭제

### 사용자

1. 사용자 등록
2. 사용자 수정
3. 사용자 삭제
4. 로그인

### 도서 대출

1. 대출 리스트 조회
2. 사용자 도서 대출
3. 사용자 도서 반납
4. 도서 미반납 알림

### 도서 예약

1. 예약 리스트 조회
2. 사용자 대출도서 예약
3. 도서 예약순번 알림

## 데이터 모델링

### 도서(book)

| book_id | PK |
| --- | --- |
| title | 제목 |
| author | 저자 |
| publisher | 출판사 |
| publication_date | 출판일자 |
| isbn | isbn |
| image_path | 이미지경로 |
| quantity | 도서권수 |

### 사용자(user)

| user_id | PK |
| --- | --- |
| email | 이메일 |
| password | 비밀번호 |
| username | 사용자 이름 |
| role | 권한(admin/user) |
| status | 사용여부(y/n) |

### 도서대출(**loan**)

| loan_id | PK |
| --- | --- |
| book_id | 도서키(FK) |
| user_id | 대출자키(FK) |
| from_date | 대출일자 |
| to_date | 반납예정일자 |
| is_return | 반납여부(y/n) |
| reason | 사유 |

### 도서예약(reserve)
| reserve_id | PK |
| --- | --- |
| loan_id | 대출도서(FK) |
| user_id | 예약자(FK) |
| reserve_date | 예약일자 |
| reserve_order | 예약순번 |
| is_reserve | 예약여부(y/n) |

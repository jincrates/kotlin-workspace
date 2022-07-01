# API Reference

## 도서 API
| Method | URI                             | Description               | Request Body       | Response Body      | etc                    |
|--------|---------------------------------|---------------------------|--------------------|--------------------|------------------------|
| GET    | /api/book                       | 도서 목록 조회             | -                  | 도서 목록           |                        |
| GET    | /api/book/all                   | 도서 목록 조회             | -                  | 도서 목록           |                        |
| GET    | /api/book?id={id}               | 도서 1개의 정보 조회       | -                   | 도서 1개 정보      | id가 없으면 전체 도서 목록 조회   |
| POST   | /api/book                       | 도서 정보 생성             | BookDto            | -                  | -                      |
| PUT    | /api/book                       | 도서 정보 수정             | BookDto            | -                  | -                      |
| DELETE | /api/book/{id}                  | 도서 정보 삭제             | -                  | -                  | -                      |



## 사용자 API
| Method | URI                             | Description               | Request Body       | Response Body      | etc                    |
|--------|---------------------------------|---------------------------|--------------------|--------------------|------------------------|
| GET    | /api/member                     | 사용자 목록 조회           | -                  | 사용자 목록         |                        |
| GET    | /api/member/all                 | 사요자 목록 조회           | -                  | 사용자 목록         |                        |
| GET    | /api/member?id={id}             | 사용자 1명의 정보 조회     | -                   | 사용자 1명 정보     | id가 없으면 전체 사용자 목록 조회   |
| POST   | /api/member                     | 사용자 생성                | MemberDto          | -                  | -                      |
| PUT    | /api/member                     | 사용자 수정                | MemberDto          | -                  | -                      |
| DELETE | /api/member/{id}                | 사용자 삭제                | -                  | -                  | -                      |



- Dto 예시
    ```
    {
        "id": "id",
        "value1": "value1",
        "value2": "value2",
        "value3": "value3",
        "value4": "value4",
    }
    ```
    - `value1`, `value2` 생략 가능, 이외 생략 불가

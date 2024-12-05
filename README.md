# API 명세서

* 데이터 형식
* Request: JSON
* Response: JSON
---

1. 일정 생성 (Create)

POST /calenders

요청
* Content-Type: application/json
* Request Body
````
{
    {
        "todoList" : "할 일 추가",
        "password" : "12345",
        "author" : {
            "id" : 3,
            "name" : "박병천2",
            "email" : "genius17886@naver.com"
        }
    }
}
````
응답
* 201 Created
````
{
    "id": 1,
    "todoList": "할 일 내용",
    "password": "비밀번호",
    "author": {
        "id": 1,
        "name": "박병천",
        "email": "genius@naver.com",
        "createdAt": "2024-01-01",
        "updatedAt": "2024-01-01"
    },
    "createdAt": "2024-12-05",
    "updatedAt": "2024-12-05"
}
````

---

2. 일정 전체 조회 (Read)

GET /calenders

* 요청
````
URL : localhost:8080/calenders
````
* 응답
  * 200 OK
````
[
    {
        "todoList": "할 일",
        "author": {
            "id": 1,
            "name": "최",
            "email": "genius18674@naver.com",
            "createdAt": "2024-01-03",
            "updatedAt": "2025-01-11"
        }
    },
    {
        "todoList": "할 일",
        "author": {
            "id": 2,
            "name": "박병천",
            "email": "genius1789@naver.com",
            "createdAt": "2024-01-03",
            "updatedAt": "2024-02-03"
        }
    } ...
]    
````
---
3. 조건 조회 (Read)

GET /calenders/{id}

* 요청
  * Path Variable
    * id (Long) - 조회할 작성자 ID

  * 응답 
    * 200 OK
````
[
    {
        "id": 23,
        "todoList": "할 일",
        "author": {
            "id": 1,
            "name": "최",
            "email": "genius18674@naver.com",
            "createdAt": "2024-01-03",
            "updatedAt": "2025-01-11"
        }
    },
    {
        "id": 24,
        "todoList": "할 일",
        "author": {
            "id": 1,
            "name": "최",
            "email": "genius18674@naver.com",
            "createdAt": "2024-01-03",
            "updatedAt": "2025-04-03"
        }
    }, ...
]
````
* 오류
  * 
---

4. 일정 수정 (Update)

PUT /calenders/{id}

* 요청
  * path Variable:
      *	id (Long) - 수정할 일정 ID
  * Content-Type: application/json
  * Request Body
````
{
    "todolist" : "수정된 할 일",
    "author" : {
        "name" : "수정된 이름"
    },
    "password" : "1234"
}
````
* 응답
  * 200 OK
````
{
    "id": 23,
    "todoList": "수정된 할 일23",
    "author": {
        "id": 1,
        "name": "수정된 이름23",
        "email": "genius18674@naver.com",
        "createdAt": "2024-01-03",
        "updatedAt": "2024-12-05"
    }
}
````
* 오류 
````
{
  "error": "비밀번호가 일치하지 않습니다."
}
````
---

5. 일정 삭제 (Delete)

DELETE /calenders/{id}

* 요청
  * path Variable
      * id (Long) - 삭제할 일정 ID
  * Request Body
````
{
    "password" : "12345"
}
````
* 응답
  * 200 OK
````
정상적으로 삭제되었습니다.
````
* 오류
  * 400 Bad Request

````
비밀번호가 일치하지 않습니다!
````

## ERD
![calendarERD](https://github.com/user-attachments/assets/2833501b-f651-4fdb-bb8c-ca6c36dd995f)
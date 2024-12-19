# 일정 관리 시스템 과제

## 목차

1. 개요
2. 과제 요구사항
3. API 명세서

<br>

## 개요

이 프로젝트는 **일정 관리 시스템**을 개발하는 과제입니다. 사용자는 일정을 생성, 조회, 수정, 삭제할 수 있으며, 유저 관리와 로그인 기능도 제공합니다.

주요 학습 내용은 **JPA**를 활용한 데이터베이스 연동, **Cookie/Session**을 이용한 인증과 인가 처리입니다. 이를 통해 **Spring**을 활용한 기본적인 CRUD 기능과 보안 처리 방법을 익힐 수 있습니다.

<br>

# 과제 요구사항

## Lv 1. 일정 CRUD (필수)

<details>
<summary>자세히 보기</summary>

### 기능 요구사항

- 일정을 생성, 조회, 수정, 삭제할 수 있어야 함.

### 일정 필드

- `작성 유저명` (유저 고유 식별자로 변경 예정)
- `할일 제목`
- `할일 내용`
- `작성일` (JPA Auditing 사용)
- `수정일` (JPA Auditing 사용)

### JPA Auditing

- `작성일`과 `수정일` 필드에 대해 JPA Auditing을 활용하여 자동으로 생성일과 수정일을 관리해야 함.
- 참고: 3주차 JPA Auditing 학습 내용

</details>

## Lv 2. 유저 CRUD (필수)

<details>
<summary>자세히 보기</summary>

### 기능 요구사항

- 유저를 생성, 조회, 수정, 삭제할 수 있어야 함.

### 유저 필드

- `유저명`
- `이메일`
- `작성일` (JPA Auditing 사용)

### 연관관계 구현

- 일정은 기존의 `작성 유저명` 필드 대신, 유저의 **고유 식별자**(예: 유저 ID) 필드를 가짐.
- 일정과 유저는 연관관계 설정 필요 (일정 -> 유저)
</details>

## Lv 3. 회원가입 (필수)

<details>
<summary>자세히 보기</summary>

### 기능 요구사항

- 유저에 `비밀번호` 필드를 추가해야 함.

### 비밀번호 암호화

- 비밀번호는 평문으로 저장하지 않고 암호화하여 저장해야 함. (암호화는 도전 과제로 설정)
</details>

## Lv 4. 로그인 (인증) (필수)

<details>
<summary>자세히 보기</summary>

### 기능 요구사항

- **Cookie/Session**을 활용하여 로그인 상태를 관리.
- `HttpServletRequest`와 `HttpServletResponse`를 활용하여 로그인 정보를 처리.
- 필터를 사용하여 인증 처리.
- `@Configuration`을 사용하여 필터를 등록.

### 인증 조건

- 로그인 시 **이메일**과 **비밀번호**를 사용하여 인증.
- 로그인 시, 이메일과 비밀번호가 일치하지 않으면 **HTTP Status code 401**을 반환.

### 예외 처리

- 이메일 또는 비밀번호 불일치 시 인증 실패로 401 에러 처리.
</details>

<br>
<br>

# API 명세서

## 기본 정보

- **Base URL**: `/`
- **Content-Type**: `application/json`
- **Authentication**: 없음 (로그인 시 세션 활용)

## 사용자 API

<details>
<summary>1. 회원가입</summary>

### 1. 회원가입

- **Endpoint**: `POST /users/signup`
- **Description**: 새로운 사용자를 등록합니다.
- **Request**:
  ```json
  {
    "name": "홍길동",
    "email": "hong@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "홍길동",
    "email": "hong@example.com"
  }
  ```

</details>

<details>
<summary>2. 로그인</summary>

### 2. 로그인

- **Endpoint**: `POST /users/login`
- **Description**: 사용자 로그인 및 세션 생성.
- **Request**:
  ```json
  {
    "email": "hong@example.com",
    "password": "password123"
  }
  ```
- **Response**:
  ```json
  {
    "message": "success"
  }
  ```
- **Errors**:
  - `401 Unauthorized`: 비밀번호가 일치하지 않을 경우.

</details>

<details>
<summary>3. 모든 사용자 조회</summary>

### 3. 모든 사용자 조회

- **Endpoint**: `GET /users`
- **Description**: 모든 사용자를 조회합니다.
- **Response**:
  ```json
  [
    {
      "id": 1,
      "name": "홍길동",
      "email": "hong@example.com"
    },
    {
      "id": 2,
      "name": "김철수",
      "email": "kim@example.com"
    }
  ]
  ```

</details>

<details>
<summary>4. 사용자 정보 수정</summary>

### 4. 사용자 정보 수정

- **Endpoint**: `PATCH /users/{id}`
- **Description**: 사용자 정보를 수정합니다.
- **Path Parameters**:
  - `id`: 사용자 ID
- **Request**:
  ```json
  {
    "name": "김영희",
    "email": "kimy@example.com"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "name": "김영희",
    "email": "kimy@example.com"
  }
  ```

</details>

<details>
<summary>5. 사용자 삭제</summary>

### 5. 사용자 삭제

- **Endpoint**: `DELETE /users/{id}`
- **Description**: 사용자를 삭제합니다.
- **Path Parameters**:
  - `id`: 사용자 ID
- **Response**:
  - `200 OK`: 성공적으로 삭제됨.

</details>

## Todo API

<details>
<summary>1. Todo 생성</summary>

### 1. Todo 생성

- **Endpoint**: `POST /todos`
- **Description**: 새로운 Todo를 생성합니다.
- **Request**:
  ```json
  {
    "userId": 1,
    "title": "할 일 제목",
    "content": "할 일 내용"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "user": {
      "id": 1,
      "name": "홍길동",
      "email": "hong@example.com"
    },
    "title": "할 일 제목",
    "content": "할 일 내용",
    "createdAt": "2024-12-19T00:00:00",
    "modifiedAt": "2024-12-19T00:00:00"
  }
  ```

</details>

<details>
<summary>2. 모든 Todo 조회</summary>

### 2. 모든 Todo 조회

- **Endpoint**: `GET /todos`
- **Description**: 모든 Todo를 조회합니다.
- **Response**:
  ```json
  [
    {
      "id": 1,
      "user": {
        "id": 1,
        "name": "홍길동",
        "email": "hong@example.com"
      },
      "title": "할 일 제목",
      "content": "할 일 내용",
      "createdAt": "2024-12-19T00:00:00",
      "modifiedAt": "2024-12-19T00:00:00"
    }
  ]
  ```

</details>

<details>
<summary>3. Todo 조회 (ID로)</summary>

### 3. Todo 조회 (ID로)

- **Endpoint**: `GET /todos/{id}`
- **Description**: 특정 ID의 Todo를 조회합니다.
- **Path Parameters**:
  - `id`: Todo ID
- **Response**:
  ```json
  {
    "id": 1,
    "user": {
      "id": 1,
      "name": "홍길동",
      "email": "hong@example.com"
    },
    "title": "할 일 제목",
    "content": "할 일 내용",
    "createdAt": "2024-12-19T00:00:00",
    "modifiedAt": "2024-12-19T00:00:00"
  }
  ```

</details>

<details>
<summary>4. Todo 수정</summary>

### 4. Todo 수정

- **Endpoint**: `PATCH /todos/{id}`
- **Description**: 특정 Todo를 수정합니다.
- **Path Parameters**:
  - `id`: Todo ID
- **Request**:
  ```json
  {
    "title": "수정된 제목",
    "content": "수정된 내용"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "user": {
      "id": 1,
      "name": "홍길동",
      "email": "hong@example.com"
    },
    "title": "수정된 제목",
    "content": "수정된 내용",
    "createdAt": "2024-12-19T00:00:00",
    "modifiedAt": "2024-12-19T01:00:00"
  }
  ```

</details>

<details>
<summary>5. Todo 삭제</summary>

### 5. Todo 삭제

- **Endpoint**: `DELETE /todos/{id}`
- **Description**: 특정 Todo를 삭제합니다.
- **Path Parameters**:
  - `id`: Todo ID
- **Response**:
  - `200 OK`: 성공적으로 삭제됨.

</details>

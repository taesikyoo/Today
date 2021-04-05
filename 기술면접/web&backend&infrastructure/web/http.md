# HTTP

- 웹에서 요청과 응답의 흐름을 제어하는 프로토콜

## 특징

1. 모든 것이 HTTP 프로토콜
2. 클라이언트/서버 구조
3. Stateful, Stateless
4. 비 연결성(connectionless)
5. HTTP 메시지

### 1. 모든 것이 HTTP

- 거의 모든 형태의 데이터를 전송 가능 (HTML, text, 이미지, 음성, 영상, 파일, json, xml ...)
- HTTP 1.1 버전
  - TCP : HTTP/1.1, HTTP/2
  - UDP : HTTP/3

### 2. 클라이언트 / 서버 구조

- request, response를 주고 받음
- 클라와 서버는 독립적

### 3. 무상태 프로토콜(Stateless)

- 서버가 클라이언트의 상태를 보존하지 않음
- 장점 : **서버 확장성 높음**(스케일 아웃)
- 단점 : 클라이언트가 추가 데이터 전송
- Stateful에서는 요청할 때 항상 같은 서버가 유지되어야 한다. 중간에 서버가 바뀌면 상태 정보를 잃어버리기 때문
- Stateful : 로그인한 상태(브라우저 쿠키 + 서버 세션) → 상태 유지는 최소한만 사용

### 4. 비 연결성(Connetionless)

- 클라이언트와 서버가 연결을 유지하지 않음, 서버 자원의 효율적 사용(빠른 응답 속도)
- 한계와 극복
  - TCP/IP 연결을 새로 맺어야 함 - 3 way handshake 시간 추가
  - HTML뿐만 아니라 수많은 자원을 함께 다운로드
  - HTTP 지속 연결(Persistent Connections)

## HTTP 메서드

![image](https://user-images.githubusercontent.com/37072010/113575899-91f5e880-9659-11eb-927d-fe7b526f4103.png)

- 안전 : 호출해도 리소스를 변경하지 않음
- 멱등(Idempotent) : n번 호출했을 때 매번 결과가 동일
  - POST는 멱등이 아님
  - 멱등은 자동 복구 메커니즘, 서버가 timeout 등으로 정상 응답을 못주었을 때, 클라이언트가 같은 요청을 반복해도 되는가?의 근거가 됨
- 캐시 가능
  - 응답 결과 리소스를 캐시해서 사용해도 되는가?
  - 실제로는 GET, HEAD만 사용, POST와 PATCH는 본문 내용까지 캐시 키로 고려해야해서 구현이 어려움

## HTTP 메서드 활용

### 클라이언트에서 서버로 데이터 전송

- 쿼리 파라미터(GET) or 메시지 바디

1. 정적 데이터 조회
2. 동적 데이터 조회
3. HTML Form 데이터 전송(GET, POST)
   - Content-Type: application/x-www-form-urlencoded
   - Content-Type: multipart/form-data
4. HTTP API 데이터 전송
   - HTML에서 Form 전송 대신 자바 스크립트를 통한 통신에 사용(AJAX)
   - Content-Type: application/json

### URI 설계

- 문서(document)
  - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
  - 예) /members/100, /files/star.jpg
- 컬렉션(collection)
  - 서버가 관리하는 리소스 디렉터리
  - **서버가 리소스의 URI를 생성하고 관리 → POST**
  - 예) /members
- 스토어(store)
  - 클라이언트가 관리하는 자원 저장소
  - **클라이언트가 리소스의 URI를 알고 관리 → PUT**
  - 예) /files
- 컨트롤러(controller), 컨트롤 URI
  - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
  - 동사를 직접 사용
  - 예) /members/{id}/delete

## HTTP 응답코드

- 2xx (Successful) : 요청 정상 처리
- 3xx (Redirection) : 요청을 완료하려면 추가 행동이 필요
- 4xx (Client Error) : 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음
- 5xx (Server Error) : 서버 오류, 서버가 정상 요청을 처리하지 못함
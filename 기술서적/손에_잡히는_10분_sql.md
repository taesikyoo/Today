# 손에 잡히는 10분 SQL

# 1장 SQL 이해하기

## 데이터베이스 기본

**데이터베이스**

- 정리된 데이터를 저장하기 위한 그릇(하나 또는 여러 개의 파일)
- cf. DBMS(데이터베이스 관리 시스템)는 데이터베이스 소프트웨어, DBMS와의 대화를 위해 필요한 것이 바로 SQL

**테이블**

- 특정한 형태의 데이터로 이루어진 구조화된 목록
- 하나의 데이터베이스 내에서 테이블 이름은 고유하다.
- 스키마
  - 데이터베이스, 테이블의 구조와 속성에 대한 정보
  - 테이블 간의 관계를 표현하기도 함

**열과 데이터 형**

- 테이블은 열(Coluimn)로 구성된다.
- 열 : 테이블에 있는 하나의 필드, 모든 테이블은 한 개 이상의 열로 구성
- 각각의 열은 데이터형(Datatype)을 갖는다.
- 데이터형: 허용되는 데이터의 유형, 열에 저장할 수 있는 데이터의 유형을 정의

**행**

- 테이블에 있는 레코드

**기본 키**

- 테이블에 있는 각 행을 구별 짓는 열 (또는 열 집합)
- 실제로 기본 키가 요구되지 않더라도, 미래를 위해 항상 기본 키를 정의하라.
- 기본 키의 조건
  - 두 행이 같은 기본 키 값을 가질 수 없다.
  - 모든 행은 기본 키 값을 가져야 한다. (즉, 기본 키 열은 NULL 값을 허용하지 않는다.)
  - 기본 키 열에 있는 값은 변경하거나 업데이트할 수 없다.
  - 기본 키 값은 재사용할 수 없다. (테이블에서 어떤 행을 삭제할 경우 그 기본 키도 삭제되지만 다른 행에 다시 할당할 수 없다.)

## SQL이란 무엇인가

- Structured Query Language (구조화된 질의 언어)
- 데이터베이스와 소통하기 위해 고안된 언어

# 2장 데이터 가져오기 (select)

```mysql
# 행의 중복 출력 방지하기
-- distinct 키워드는 모든 열에 일괄 적용된다. 하나의 열에만 부분적으로 적용할 수는 없다.
select distinct vend_id from products;
select distinct vend_id, prod_price from products;
select vend_id, prod_price from products;

# 결과 제한하기
select prod_name from products limit 5;
select prod_name from products limit 5 offset 5;
select prod_name from products limit 4 offset 3;
select prod_name from products limit 3, 4;
```

- limit : 몇 개의 행을 가져올지
- offset : 몇 번째 행부터 가져올지 (index는 0부터 시작)
- limit 4 offset 3 = limit 3,4 (순서가 반대니 주의할 것) 

# 3장 가져온 데이터 정렬하기 (order by)

- ORDER BY 절은 SELECT 문의 가장 마지막에 와야하는 것을 기억하자.

```mysql
# 여러 개의 열로 정렬하기
select prod_id, prod_price, prod_name from products order by prod_price, prod_name;
# 열의 위치로 정렬하기
select prod_id, prod_price, prod_name from products order by 2, 3; -- 위 sql과 결과가 같음

# 정렬 순서 지정하기
select prod_id, prod_price, prod_name from products order by prod_price desc, prod_name;
```

- DESC 키워드는 명시된 열에만 적용된다. 오름차순 정렬(ASC)이 기본값

# 4장 데이터 필터링 (where)

- where절은 테이블 이름(from절) 바로 다음에 적는다.

```mysql
# BETWEEN
select prod_name, prod_price from products where prod_price between 5 and 10;

# IS NULL
select cust_name from customers where cust_email is null;
```

- BETWEEN은 시작 값과 종료 값을 **포함**하여 지정된 범위의 모든 데이터를 가져온다.
- 특정한 값이 없는 행을 검색하면 NULL을 가진 행을 반환할 것이라고 기대하겠지만, 그렇지 않다.
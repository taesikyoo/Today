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

# 5장 고급 데이터 필터링 (and, or, not, in)

```mysql
# IN
select prod_name, prod_price from products 
where vend_id in ('DLL01', 'BRS01')
order by prod_name;

select prod_name, prod_price from products 
where vend_id = 'DLL01' or vend_id = 'BRS01'
order by prod_name;

-- in과 or는 같은 일을 수행한다.
```

- IN 연산자의 장점
  - 조건이 많을 떄 OR보다 가독성이 좋음
  - AND나 OR 연산자와 함께 사용할 때 연산자 우선순위를 관리하기 편함
  - OR가 목록을 처리하는 속도보다 빠름
  - **IN 안에 SELECT 문을 포함 가능** 

```mysql
# NOT
select prod_name from products 
where NOT vend_id = 'DLL01'
order by prod_name;
```

# 6장 와일드카드 문자를 이용한 필터링 (like, %, _, [ ])

- 와일드카드 : 여러 데이터에서 부분적으로 일치하는 값이 있는지 확인할 때 사용되는 특수 문자
- 검색 패턴 : 문자나 와일드카드 또는 이 두 개의 조합으로 구성된 검색 조건

- 와일드카드 검색은 텍스트 열(문자열)에서만 사용 가능
- LIKE는 술어(predicate)이지 연산자가 아님

```mysql
# % 와일드카드
SELECT prod_name
FROM Products
WHERE prod_name LIKE 'F%y'
-- WHERE email LIKE 'b%forta.com'
-- WHERE prod_name LIKE 'F%y%'(후행 공백에 주의)
```

- %는 하나 이상의 문자뿐 아니라 0개의 문자를 뜻할 수도 있음 = 0 or 1개 이상

```mysql
# _ 와일드카드
SELECT prod_id, prod_name
FROM Products
WHERE prod_name LIKE '__ inch teddy bear'; -- '__ inch teddy bear%';
```

- _는 반드시 한 개의 문자와 매칭됨

```mysql
# 집합 와일드카드
SELECT cust_contact
FROM Customers
WHERE cust_contact LIKE '[JM]%' 
ORDER BY cust_contact;
-- J 또는 M으로 시작하는 연락처 찾기, [] 안에 있는 문자 중 '하나'와 일치해야함
-- '[^JM]%' 캐럿 기호를 사용하면 not을 의미, = WHERE NOT
```

- 와일드카드로 시작하는 검색 패턴을 처리가 느리므로 꼭 필요한 경우에 사용하자

```mysql
# 도전 과제
select prod_name, prod_desc from products where not prod_desc like '%toy%' order by prod_name;
select prod_name, prod_desc from products where (prod_desc like '%toy%') and (prod_desc like '%carrots%');
select prod_name, prod_desc from products where prod_desc like '%toy%carrots%' order by prod_name;
```

# 7장 계산 필드 생성하기 (concat, as, 사칙연산)

- 계산 필드 : 열과 유사하지만 데이터베이스 테이블에 실제로 존재하지 않고 SQL SELECT 문을 통해 동적으로 생성됨

```mysql
# 필드 연결하기
SELECT RTRIM(vend_name) + ' (' + RTRIM(vend_country) + ')' ...
SELECT RTRIM(vend_name) || ' (' || RTRIM(vend_country) || ')' ... -- DB2, Oracle, PostgreSQL, SQLite
SELECT Concat(vend_name, ' (', vend_country, ')') ... -- MySQL, MariaDB
```

- RTRIM(), LTRIM(), TRIM() : 오른쪽, 왼쪽, 양쪽 공백 제거

```mysql
# 별칭 사용하기
SELECT Concat(vend_name, ' (', vend_country, ')')
	   AS vend_title
FROM vendors
ORDER BY vend_name;
```

- 별칭(alias) : 하나의 필드나 값을 부르기 위한 또 다른 이름 = 파생열(derived coulumn)

```mysql
# 도전 과제
select vend_id as vname, vend_name, vend_address as vaddress, vend_city as vcity
from vendors
order by vname;

select prod_id, prod_price, (prod_price * 0.9) as sale_pricce
from products;
```

# 8장 데이터 조작 함수 사용하기

- SQL 함수는 각 DBMS에 종속적 -> 호환성이 낮음

- 문자열 조작 함수

  | 함수                                 | 설명                                     |
  | ------------------------------------ | ---------------------------------------- |
  | LEFT() (또는 문자열 추출 함수 사용)  | 문자열 왼쪽에서부터 문자열 일부를 추출   |
  | RIGHT() (또는 문자열 추출 함수 사용) | 문자열 오른쪽에서부터 문자열 일부를 추출 |
  | LENGTH() (또는 DATALENGTH()나 LEN()) | 문자열의 길이를 반환                     |
  | LOWER()                              | 문자열을 소문자로 변환                   |
  | UPPER()                              | 문자열을 대문자로 변환                   |
  | LTRIM()                              | 문자열의 왼쪽에 있는 공백 문자를 삭제    |
  | RTRIM()                              | 문자열의 오른쪽에 있는 공백 문자를 삭제  |
  | SUBSTR() 또는 SUBSTRING()            | 문자열의 일부분 추출                     |
  | SOUNDEX()                            | 문자열의 SOUNDEX 값을 반환               |

  - SOUNDEX()는 문자열을 소리 나는 대로 표현하는 문자열 변환 알고리즘

    ```mysql
    SELECT cust_name, cust_contact
    FROM Customers
    WHERE SOUNDEX(cust_contact) = SOUNDEX('Michael Green'); -- Michelle Green을 검색 가능
    ```

- 날짜와 시간 조작 함수
  - 거의 호환되지 않음
  - e.g. DATEPART(), DATE_PART(), EXTRACT(), YEAR(), strftime() 등
- 수치 조작 함수
  
  - ABS(), COS(), SIN(), TAN(), EXP(), PI(), SQRT() 등

```mysql
# 도전 과제
select cust_id, cust_name, 
	   concat(upper(left(cust_contact, 2)), upper(left(cust_city, 3))) 
	   as user_login
from customers;

select order_num, order_date
from orders
where (year(order_date) = 2020) and (month(order_date) = 1)
order by order_date; 
```

# 9장 데이터 요약 (AVG(), COUNT(), MAX(), MIN(), SUM())

- **그룹 함수** : 여러 행에 대한 연산을 수행하고, 하나의 값을 반환하는 함수
  - AVG(), COUNT(), MAX(), MIN(), SUM()

- AVG() 함수는 하나의 열만 사용 가능, NULL은 무시
- COUNT()
  - COUNT(*)은 NULL을 포함
  - COUNT(열 이름)은 NULL을 무시
- MAX()와 MIN()
  - NULL을 무시
  - 문자열 데이터에 사용하면 사전순으로 정렬된 열에서 가장 마지막/처음 행을 반환
- SUM()은 NULL을 무시

```mysql
# 중복되는 값에 대한 그룹 함수
select avg(distinct prod_price) as avg_price
from products
where vend_id = 'DLL01';
```

- 중복되는 값을 제거하기 위해 DISTINCT 키워드를 사용
  - COUNT(*)와는 함께 사용할 수 없음
  - DISTINCT를 사용하지 않으면 ALL로 인식
  - cf. TOP, TOP PERCENT 등은 일부분을 계산

# 10장 데이터 그룹핑 (GROUP BY, HAVING)

- GROUP BY
  - GROUP BY 절은 DBMS에게 먼저 데이터를 그룹핑한 후, 각각의 그룹에 대해 계산하라고 지시한다.
  - 중첩(nested) 그룹을 만들 수 있음, 데이터는 마지막으로 지정된 그룹에서 요약됨
  - GROUP BY 절은 WHERE 절 뒤에 그리고 ORDER BY 절 앞에 와야 한다.

```mysql
# 그룹 필터링
select cust_id, count(*) as orders
from orders
group by cust_id
having count(*) >= 2;
```

- HAVING
  - WHERE 절은 행을 필터링하고, HAVING 절은 그룹을 필터링한다.
  - **WHERE 절은 데이터가 그룹핑 되기 전에 필터링하고, HAVING 절은 데이터가 그룹핑된 후에 필터링한다.**
  - **WHERE 절에서 필터링되어 제거된 행은 그룹에 포함되지 않는다.**

  - GROUP BY 절이 있을 때만 HAVING 절을 사용하고, 행 단위로 필터링할 때는 WHERE 절을 사용하도록 하자.

```mysql
select vend_id, count(*) as num_prods
from products
where prod_price >= 4
group by vend_id
having count(*) >= 2;

# 그룹핑과 정렬
select order_num, count(*) as items
from orderitems
group by order_num
having count(*) >= 3
order by items, order_num;
```

- SELECT 문 순서 : **SELECT - FROM - WHERE - GROUP BY - HAVING - ORDER BY**

# 11장 서브쿼리 사용하기

```mysql
# 서브쿼리로 필터링하기
select cust_name, cust_contact
from customers
where cust_id in (select cust_id
				  from orders
				  where order_num in (select order_num
									  from orderitems
									  where prod_id = 'RGAN01'));

# 계산 필드로 서브쿼리 사용하기
select cust_name,
	   cust_state,
	   (select count(*)
        from orders
        where orders.cust_id = customers.cust_id) as orders
from customers
order by cust_name;
```

```mysql
# 도전 과제
select cust_id,
	   (select sum(item_price * quantity)
        from orderitems
       	where orders.order_num = orderitems.order_num) as total_ordered
from orders
order by total_ordered desc;

select prod_name, 
	   (select sum(quantity)
        from orderitems
        where products.prod_id = orderitems.prod_id) as quant_sold
from products;
```


### Map

- 순서를 보장하지 않으며 키(key)-값(value)의 한 쌍으로 이루어진 자료구조
- 키(key)는 중복을 허용하지 않고 값(value)은 중복을 허용

### HashMap
- 해싱 기법으로 데이터를 찾기 때문에 검색에 유리하지만 동기화는 지원되지 않음 

- key와 value에 null을 저장할 수 있음

### HashTable

- HashMap과 달리 동기화(synchronize)를 지원

### TreeMap

- 데이터 삽입 시, 내부적으로 정렬을 지원
- key를 기준으로 정렬을 수행하기 때문에 key에 null을 저장할 수 없음 
- HashMap과 동일하게 동기화는 지원되지 않음
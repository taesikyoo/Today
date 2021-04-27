# 01 Array vs ArrayList vs LinkedList

### 요약

- **Array**는 index로 빠르게 값을 찾는 것이 가능함
- **LinkedList**는 데이터를 중간에 삽입, 삭제할 때 유리
- **ArrayList**는 데이터를 찾는데 빠르지만, 삽입 및 삭제가 느림

# Array (배열)

- 논리적 저장 순서와 물리적 저장 순서가 일치 => 인덱스(index)로 해당 원소(element)에 접근이 가능(O(1) 시간으로 random access 가능)
- 삭제 혹은 삽입 => 인덱스 검색에 O(1) + shift로 인해 worst case의 경우 O(n)시간 만큼 소요
- 장점
  - search가 O(1), 데이터 무작위 접근 가능
- 단점
  - 데이터가 증가하거나, 데이터의 최대 사이즈를 알 수 없을 때 부적합(메모리 공간에 사이즈를 미리 할당하므로)
  - 중간에 삭제 혹은 삽입 시 비효율적

# Array List

- 장점
  - search가 O(1)
  - array처럼 크기를 정해주지 않아도 됨
- 단점
  - 중간에 삭제 혹은 삽입 시 비효율적

# Linked List

- 한 노드에 연결될 노드의 포인터 위치를 가리키는 방식

- 삽입 혹은 삭제 시 shift하지 않아도 됨
- 그러나 search에 O(n)의 time complexity 를 갖고, 삽입과 삭제에 대해서도 O(n)의 time complexity 를 가짐
- Tree에 응용

- 장점
  - array처럼 크기를 정해주지 않아도 됨
- 단점
  - 무작위 접근이 불가능하며, 순차 접근만이 가능
  - 검색과 삽입, 삭제 과정 모두 O(n)의 시간 복잡도를 가짐

# 참고 

https://github.com/WooVictory/Ready-For-Tech-Interview/blob/master/Data%20Structure/%5BData%20Structure%5D%20Array%20vs%20LinkedList.md

https://www.baeldung.com/java-collections-complexity
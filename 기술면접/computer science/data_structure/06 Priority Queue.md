# 06 Priority Queue

## 우선순위큐

- 가장 높은 우선순위를 가진 항목에 접근하거나 해당 항목을 삭제하는 연산과 임의의 우선순위를 가진 항목을 삽입하는 연산을 지원하는 자료구조
- 스택과 큐도 우선순위큐의 일종
  - 스택 : 가장 마지막으로 삽입된 항목이 가장 높은 우선순위, 최근 시간일수록 높은 우선순위를 부여
  - 큐 : 먼저 삽입된 항목이 높은 우선순위, 이른 시간일수록 더 높은 우선순위를 부여
- 새롭게 삽입되는 항목이 임의의 우선순위를 가질 때, 스택이나 큐는 정렬 상태를 유지하는데 어려움을 가짐
- 우선순위큐
  - 항목 삽입 시 정렬 상태를 유지할 필요가 없음
  - O(1) 시간에 가장 높은 우선순위를 가진 항목에 접근 가능
  - 가장 높은 우선순위를 가진 항목을 삭제하는 연산을 지원
  -  배열, 연결리스트, 힙 으로 구현이 가능, 이 중에서 힙(heap)으로 구현하는 것이 가장 효율적
    <img src="https://gmlwjd9405.github.io/images/data-structure-heap/data-structure-heap-priorityqueue.png" style="zoom:33%;" />

## 이진힙

### 정의

- 완전이진트리(마지막 레벨을 제외한 각 레벨이 노드들로 꽉 차있고, 마지막 레벨에는 노드들이 왼쪽부터 빠짐없이 채워진 트리)
- 부모의 우선순위가 자식의 우선순위보다 높은 자료구조

### 특징

- 힙의 종류
  - 최대 힙(max heap) : 키 값이 클수록 높은 우선순위를 가짐
  - 최소 힙(min heap) : 키 값이 작을수록 높은 우선순위를 가짐
- 중복된 값을 허용 (이진탐색트리는 중복된 값을 허용하지 않음)
- 1차원 배열로 구현할 때, 인덱스 1부터 시작
- 부모와 자식의 관계
  - a[i]의 자식은 a[2i]와 a[2i+1]
  - a[j]의 부모는 a[j/2] (단, j>1이고, j/2의 정수만을 취함)

### 삽입과 삭제

#### 삽입

1. 새로운 노드를 힙의 마지막 노드에 삽입

2. 새로운 노드를 부모 노드들과 교환

```java
void insert_max_heap(int x) {
    
    maxHeap[++heapSize] = x; 
    // 힙 크기를 하나 증가하고, 마지막 노드에 x를 넣음
    
    for( int i = heapSize; i > 1; i /= 2) {
        // 마지막 노드가 자신의 부모 노드보다 크면 swap
        if(maxHeap[i/2] < maxHeap[i]) {
            swap(i/2, i);
        } else {
            break;
        }
    }
}
```

#### 삭제

1. 최대 힙에서 루트 노드를 삭제 (최대 힙에서 삭제 연산은 최대값 요소를 삭제하는 것을 의미)

2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져옴

3. 힙을 재구성

```java
int delete_max_heap() {
    
    if(heapSize == 0) // 배열이 비어있으면 리턴
        return 0;
    
    int item = maxHeap[1]; // 루트 노드의 값을 저장
    maxHeap[1] = maxHeap[heapSize]; // 마지막 노드 값을 루트로 이동
    maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드 0 초기화
    
    for(int i = 1; i*2 <= heapSize;) {
        // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 끝
        if(maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
            break;
        }
        // 왼쪽 노드가 더 큰 경우, swap
        else if (maxHeap[i*2] > maxHeap[i*2+1]) {
            swap(i, i*2);
            i = i*2;
        }
        // 오른쪽 노드가 더 큰 경우
        else {
            swap(i, i*2+1);
            i = i*2+1;
        }
    }
    
    return item;
}
```

# 참고

책 <자바와 함께하는 자료구조의 이해>, 양성봉 저, 생능출판.

https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html

https://gyoogle.dev/blog/computer-science/data-structure/Heap.html
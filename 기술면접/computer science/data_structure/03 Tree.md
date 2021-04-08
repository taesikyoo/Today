# 03 Tree

# 트리의 특징

- Tree는 Stack이나 Queue와 같이 선형 구조가 아닌 비선형 자료구조이다.
- 계층적 관계를 표현한다.
- 트리는 노드로 이루어진 자료 구조
  1. 트리는 하나의 루트 노드를 갖는다.
  2. 루트 노드는 0개 이상의 자식 노드를 갖고 있다.
  3. 그 자식 노드 또한 0개 이상의 자식 노드를 갖고 있고, 이는 반복적으로 정의된다.
- 노드(node)들과 노드들을 연결하는 간선(edge)들로 구성되어 있다.
- 그래프의 한 종류
  - 사이클(cycle)이 없는 하나의 연결 그래프(Connected Graph)
  - 또는 DAG(Directed Acyclic Graph, 방향성이 있는 비순환 그래프)의 한 종류 이다.
- 종류 : 이진 트리, 이진 탐색 트리, 균형 트리(AVL 트리, red-black 트리), 이진 힙(최대힙, 최소힙) 등

# 트리의 구성 요소 및 용어 설명

- Node (노드) : 트리를 구성하는 각각의 요소.
- Edge (간선) : 트리를 구성하기 위해 노드와 노드를 연결하는 선.
- Root Node (루트 노드) : 트리 구조에서 최상위에 있는 노드.
- Terminal Node (= leaf Node, 단말 노드) : 하위에 다른 노드가 연결되어 있지 않은 노드.
- Internal Node (내부노드, 비단말 노드) : 단말 노드를 제외한 모든 노드로 루트 노드를 포함한다.
- Level (= depth) : 루트부터 0에서 시작, 아래로 내려가면서 각 층마다 1씩 증가
- Height : 트리의 최고 레벨 값

# 이진트리 (Binary Tree)

- 루트 노드를 중심으로 두 개의 서브 트리로 나누어짐
- 또한 나누어진 두 서브 트리도 모두 이진트리어야 함(재귀)
- 노드가 없는 트리도 이진트리에 포함됨
- 배열로 구현된 이진트리에서 노드의 개수가 n 개이고 root가 0이 아닌 1에서 시작할 때 
  - i 번째 노드에 대해서 parent(i) = i/2 , left_child(i) = 2i , right_child(i) = 2i + 1의 index 값을 가짐

## 이진트리의 종류

- 포화 이진 트리 (Perfect Binary Tree) : 모든 레벨이 꽉 찬 이진 트리
- 완전 이진 트리 (Complete Binary Tree) : 위에서 아래로, 왼쪽에서 오른쪽으로 순서대로 차곡차곡 채워진 이진 트리
- 정 이진 트리 (Full Binary Tree) : 모든 노드가 0개 혹은 2개의 자식 노드만을 갖는 이진 트리

![](https://media.vlpt.us/images/jaeyunn_15/post/9ac8d1d3-2ca2-4659-9242-d8e977e0cda2/image.png)

# 참고

https://ju-nam2.tistory.com/25?category=868623

https://github.com/WooVictory/Ready-For-Tech-Interview/blob/master/Data%20Structure/%5BData%20Structure%5D%20Tree.md

https://github.com/WeareSoft/tech-interview/blob/master/contents/datastructure.md#tree

https://ko.wikipedia.org/wiki/%ED%8A%B8%EB%A6%AC_%EA%B5%AC%EC%A1%B0




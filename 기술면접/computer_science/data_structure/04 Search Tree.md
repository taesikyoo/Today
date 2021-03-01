# 04 Search Tree (탐색 트리)

# 이진탐색트리 (Binary Search Tree)

- 이진탐색 + 연결리스트

  - 이진탐색 : **탐색에 소요되는 시간복잡도는 O(logN)**, but 삽입,삭제가 불가능
  - 연결리스트 : **삽입, 삭제의 시간복잡도는 O(1)**, but 탐색하는 시간복잡도가 O(N)

  - 효율적인 탐색 능력 + 자료의 삽입,삭제

## 특징

- 각 노드의 자식이 2개 이하
- 각 노드의 왼쪽 자식은 부모보다 작고, 오른쪽 자식은 부모보다 큼
- 중복된 노드가 없어야 함
  - 중복이 없어야 하는 이유는? 검색 목적 자료구조인데, 중복이 많은 경우에 굳이 트리를 사용하여 검색 속도를 느리게 할 필요가 없음 (=> 노드에 count 값을 가지게 하여 처리하는 것이 훨씬 효율적)

- **중위순회**(inorder) :  중위 순회로(왼쪽 - 루트 - 오른쪽) **정렬된 순서**를 읽을 수 있음
- [구현](https://github.com/gyoogle/tech-interview-for-developer/blob/master/Computer%20Science/Data%20Structure/code/binarySearchTree.java)

## 시간 복잡도omega sapiendd

노드 개수가 N개일 때, 삽입, 검색, 삭제 시간복잡도는 트리의 Depth에 비례

- 균등 트리 : O(logN)
- 편향 트리 : O(N)

- 편향된 트리(정렬된 상태 값을 트리로 만들면 한쪽으로 뻗음)는 시간 복잡도가 O(N) 이므로 트리를 사용할 이유가 사라짐 => AVL Tree, RedBlack Tree가 이를 개선

## 삭제

1. 자식이 없는 leaf 노드일 때 → 그냥 삭제
2. 자식이 1개인 노드일 때 → 지워진 노드에 자식을 올리기
3. 자식이 2개인 노드일 때 → 오른쪽 자식 노드에서 가장 작은 값 or 왼쪽 자식 노드에서 가장 큰 값 올리기

# 레드블랙트리 (Red-Black Tree)

- RBT(Red-Black Tree)는 BST 를 기반으로하는 트리 형식의 자료구조
- Search, Insert, Delete의 시간 복잡도 : O(log n)
- 동일한 노드의 개수일 때, depth 를 최소화하여 시간 복잡도를 줄이는 것이 핵심 아이디어 
  =>  동일한 노드의 개수일 때, depth 가 최소가 되는 경우는 tree 가 complete binary tree 인 경우임

##  Red-Black Tree 의 정의

1. 각 노드는 `Red` or `Black`이라는 색깔을 갖는다.
2. Root node 의 색깔은 `Black`이다.
3. 각 leaf node 는 `Black`이다.
4. 어떤 노드의 색깔이 `Red`라면 두 개의 children 의 색깔은 모두 `Black` 이다. 즉 `Red` 노드는 연속하여 등장하지 않는다. 
5. 각 노드에 대해서 노드로부터 descendant leaves 까지의 단순 경로는 모두 같은 수의 black nodes 들을 포함하고 있다. 이를 해당 노드의 `Black-Height`라고 한다. 
   - Black-Height : 노드 x 로부터 노드 x 를 포함하지 않은 leaf node 까지의 simple path 상에 있는 black nodes 들의 개수

<img src="https://github.com/namjunemy/TIL/blob/master/Algorithm/img/red_black_02.png?raw=true" style="zoom:67%;" />

## Red-Black Tree 의 특징

1. Binary Search Tree 이므로 BST 의 특징을 모두 갖는다.
2. Root node 부터 leaf node 까지의 모든 경로 중 최소 경로와 최대 경로의 크기 비율은 2 보다 크지 않다. 이러한 상태를 `balanced` 상태라고 한다.
3. 노드의 child 가 없을 경우 child 를 가리키는 포인터는 NIL 값을 저장한다. 이러한 NIL 들을 leaf node 로 간주한다.

*RBT 는 BST 의 삽입, 삭제 연산 과정에서 발생할 수 있는 문제점을 해결하기 위해 만들어진 자료구조이다. 이를 어떻게 해결한 것인가?*

### 삽입

우선 BST 의 특성을 유지하면서 노드를 삽입을 한다. 그리고 삽입된 노드의 색깔을 **RED**로 지정한다. Red 로 지정하는 이유는 Black-Height 변경을 최소화하기 위함이다. 삽입 결과 RBT 의 특성 위배(violation)시 노드의 색깔을 조정하고, Black-Height 가 위배되었다면 rotation을 통해 height를 조정한다. 이러한 과정을 통해 RBT 의 동일한 height 에 존재하는 internal node들의 Black-height가 같아지게 되고 최소 경로와 최대 경로의 크기 비율이 2 미만으로 유지된다.

### 삭제

삭제도 삽입과 마찬가지로 BST 의 특성을 유지하면서 해당 노드를 삭제한다. 삭제될 노드의 child 의 개수에 따라 rotation 방법이 달라지게 된다. 그리고 만약 지워진 노드의 색깔이 Black 이라면 Black-Height 가 1 감소한 경로에 black node 가 1 개 추가되도록 rotation 하고 노드의 색깔을 조정한다. 지워진 노드의 색깔이 red 라면 Violation 이 발생하지 않으므로 RBT 가 그대로 유지된다.

Java Collection에서 ArrayList도 내부적으로 RBT로 이루어져 있고, HashMap에서의 `Separate Chaining`에서도 사용된다. 그만큼 효율이 좋고 중요한 자료구조이다.

# B-트리 & B+트리 (B-Tree & B+Tree)

이진 트리는 하나의 부모가 두 개의 자식밖에 가지질 못하고, 균형이 맞지 않으면 검색 효율이 선형검색 급으로 떨어진다. 하지만 이진 트리 구조의 간결함 그리고 균형만 맞다면 검색, 삽입, 삭제 모두 O(logN)의 성능을 보이는 장점이 있기 때문에 계속 개선시키기 위한 노력이 이루어지고 있다.

## B-Tree

- 핵심 아이디어 : 노드에 수백에서 수천 개의 키를 저장하여 트리의 높이를 낮추자.

- 이진 트리를 확장해서, 더 많은 수의 자식을 가질 수 있게 일반화 시킨 것이 B-Tree

- 하나의 레벨에 더 저장되는 것 뿐만 아니라 트리의 균형을 자동으로 맞춰주는 로직까지 갖추었다.

- 단순하고 효율적이며, 레벨로만 따지면 완전히 균형을 맞춘 트리다.
- e.g. 데이터베이스의 인덱스

### 정의

- 차수(트리 노드의 최대 자식노드 수)가 M일 때,
- 루트노드의 자식 수는 2 이상이다.
- 모든 리프노드들은 동일한 깊이를 갖는다.
- 각 내부노드의 자식 수는 ⌈M/2⌉ 이상 M 이하이다.
- 각 노드의 자료(키)들은 정렬되어 있다.

## B+Tree

- 데이터의 빠른 접근을 위한 인덱스 역할만 하는 비단말 노드가 추가로 있다.
- 기존의 B-Tree와 데이터의 연결리스트로 구현된 색인구조
- B-Tree의 변형 구조로 index 부분과 leaf 노드로 구성된 순차 데이터 부분으로 이루어진다. 인덱스 부분의 key 값은 leaf에 있는 key 값을 직접 찾아가는데 사용한다.

**장점**

- 블럭 사이즈를 더 많이 이용할 수 있음 (Key 값에 대한 하드디스크 액세스 주소가 없기 때문)
- Leaf 노드끼리 연결 리스트로 연결되어 있어서 sequential한 범위 탐색에 유리함

**단점**

- B-Tree의 경우 최상 케이스일 때 루트에서 끝날 수 있지만, B+Tree는 무조건 leaf 노드까지 내려가봐야 함

### B-Tree와 B+Tree 비교

- B-Tree : 각 노드에 데이터(인덱스)가 저장된다.
  - 각 노드에 key와 data가 모두 들어갈 수 있고, data는 disk block을 가리키는 포인터가 될 수 있다.

<img src="https://ssup2.github.io/images/theory_analysis/B_Tree_B+_Tree/B_Tree.PNG" style="zoom: 50%;" />

- B+ Tree : index 노드와 leaf 노드로 분리되어 저장된다.
  - 각 노드에서 key만 들어간다. 따라서 data는 leaf 노드에만 존재한다.
  - add, delete 연산 모두 leaf 노드에서만 이루어진다.
  - leaf 노드들이 서로 연결되어 있어서 임의 접근이나 순차 접근 모두 성능이 우수하다.

<img src="https://ssup2.github.io/images/theory_analysis/B_Tree_B+_Tree/B+_Tree.PNG" style="zoom:50%;" />

# 참고

https://gyoogle.dev/blog/computer-science/data-structure/Binary%20Search%20Tree.html

https://github.com/JaeYeopHan/Interview_Question_for_Beginner/blob/master/DataStructure/README.md#red-black-tree

https://github.com/namjunemy/TIL/blob/master/Algorithm/red_black_tree_01.md

https://ssup2.github.io/theory_analysis/B_Tree_B+_Tree/
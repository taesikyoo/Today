# 07 Graph

# 1. 그래프

## 그래프 용어

- 그래프(Graph) = **정점**(Vertex)과 **간선**(Edge)의 집합
  - 하나의 간선은 두 개의 정점을 연결함
  - 그래프 G = (V, E)일 때 V는 정점의 집합이고, E는 간선의 집합
- **방향그래프**(Directed Graph) : 간선에 방향 O
- **무방향그래프**(Undirected Graph) : 간선에 방향 X
  - (a, b) : 정점 a와 b를 연결하는 간선
  - <a, b> : 정점 a와 b를 연결하는 방향이 있는 간선
- **차수**(Degree) : 해당 정점에 인접한 정점의 수
  - 방향그래프에서는 진입차수(In-degree)와 진출차수(Out-degree)로 구분
- **경로**(Path) : 시작 정점 u부터 도착점 v까지의 정점들을 나열하여 표현
  - 단순경로(Simple Path) : 경로 상의 정점들이 모두 다른 경로(중복X)
  - 사이클(Cycle) : 시작 정점과 도착점이 동일한 단순경로
- 연결성분(Connected Component) : 그래프에서 정점들이 서로 연결되어 있는 부분
- 가중치 그래프(Weighted Graph) : 간선에 가중치가 부여된 그래프
- 부분 그래프(Subgraph) : 주어진 그래프의 정점과 간선의 일부분(부분집합)으로 이루어진 그래프
- 트리(Tree) : 방향성이 있고 사이클이 없는 그래프 (DAG, Directed Acyclic Graph)
- 신장트리(Spanning Tree) : 주어진 그래프가 하나의 연결성분으로 구성되어 있을 때, 그래프의 모든 정점들을 싸이클 없이 연결하는 부분그래프

### 그래프와 트리의 차이

<img src="https://gmlwjd9405.github.io/images/data-structure-graph/graph-vs-tree.png" alt="img" style="zoom:80%;" />

## 그래프 자료구조

### 인접행렬 (Adjacency Matrix)

- n개의 정점을 가진 그래프의 인접행렬은 2차원 NxN 배열로 저장
- 배열이 a라면, 정점들을 0, 1, ,2 ... , N-1로 하여, 정점 i와 j 사이에 간선이 없으면 a[i] [j]  = 0 으로, 간선이 있으면 1로 표현
- 가중치 그래프인 경우 1 대신 가중치를 저장

###  인접리스트 (Adjacency List)

- 각 정점마다 한 개의 연결리스트를 이용하여 인접한 각 정점을 노드에 저장

  

- 희소그래프(Sparse Graph) : 정점의 평균 차수가 작음, 실세계의 대부분 그래프, 그래프의 최대 간선 수인 N(N-1)/2보다 적은 간선의 수를 가짐 => 인접리스트가 적합
- 조밀그래프(Dense Graph) : 간선의 수가 최대 간선 수에 근접한 그래프 => 인접행렬이 적합

# 2. 그래프 탐색

# 3. 기본적인 그래프 알고리즘

# 4. 최소신장트리

# 5. 최단경로 알고리즘

# 참고

책 <자바와 함께하는 자료구조의 이해>, 양성봉 저, 생능출판.

https://gmlwjd9405.github.io/2018/08/13/data-structure-graph.html

https://github.com/JaeYeopHan/Interview_Question_for_Beginner/blob/master/DataStructure/README.md#graph
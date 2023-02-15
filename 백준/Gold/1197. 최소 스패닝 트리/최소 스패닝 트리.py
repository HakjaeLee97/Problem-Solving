#간선이 많으므로 크루스칼 사용
import sys

def find(parent,x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent,a,b):
    a = find(parent,a)
    b = find(parent,b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b



V, E = map(int, sys.stdin.readline().split())
parent = [0] * ( V + 1 )
for i in range( 1, V + 1 ):
    parent[i] = i

edges = [ ]
total_cost = 0

for _ in range(E):
    A, B, C = map(int, sys.stdin.readline().split())
    edges.append([C,A,B])
edges.sort()

for i in range(E):
    cost, a, b = edges[i]
    if find(parent,a) != find(parent,b):
        union(parent,a,b)
        total_cost += cost
print(total_cost)
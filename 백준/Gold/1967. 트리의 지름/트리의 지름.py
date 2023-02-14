import sys
sys.setrecursionlimit(10**6)
#dfs를 통해 가장 먼 노드를 찾고, 그 노드에서 dfs를 통해 찾은 가장 먼 노드의 거리가 트리의 지름이다

V = int(sys.stdin.readline())
tree = [[] for i in range(V)]
for i in range(V-1):
    tmp = list(map(int, sys.stdin.readline().split()))
    tree[tmp[0]-1].append(tmp[1:3])
    tree[tmp[1]-1].append([tmp[0],tmp[2]])
global maxd, fnode
maxd, fnode = 0, 0
def dfs(tree, node,  dist, before):
    #최대 거리 갱신
    global maxd, fnode
    if dist > maxd:
        maxd = dist
        fnode = node
    
    for i in tree[node]:
        if i[0]-1 != before:
            dfs(tree,i[0]-1, dist + i[1],node) 

    
dfs(tree,0,0,0)
dfs(tree,fnode,0,fnode)
print(maxd)
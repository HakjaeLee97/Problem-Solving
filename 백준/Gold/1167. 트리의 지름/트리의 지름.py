import sys
#트리의 아무 노드에서나 dfs를 돌리면 나오는 가장 먼 두 노드의 거리의 합을 구하면 된다

V = int(sys.stdin.readline())
tree = [[] for i in range(V)]
visited = [False for i in range(V)]
for i in range(V):
    tmp = list(map(int, sys.stdin.readline().split()))
    for j in range(1,len(tmp)-2,2):
        tree[tmp[0]-1].append(tmp[j:j+2])
global maxd, fnode
maxd, fnode = 0, 0
def dfs(tree, node,  dist, visited):
    visited[node] = True
    #최대 거리 갱신
    global maxd, fnode
    if dist > maxd:
        maxd = dist
        fnode = node
    
    for i in tree[node]:
        if visited[i[0]-1] == False:
            dfs(tree,i[0]-1, dist + i[1],visited) 

    
dfs(tree,0,0,visited)
visited = [False for i in range(V)]
dfs(tree,fnode,0,visited)
print(maxd)
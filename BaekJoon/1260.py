def dfs(v):
    visit[v] = 1
    print(v, end=' ')
    for i in range(n+1):
        if visit[i] == 0 and matrix[v][i] == 1:
            dfs(i)

def bfs(v):
    queue = [v]
    visit[v] = 0

    while queue:
        v = queue.pop(0)
        print(v, end=' ')
        for i in range(n+1):
            if visit[i] == 1 and matrix[v][i]:
                queue.append(i)
                visit[i] = 0

n,m,v = map(int, input().split())

matrix = [[0]*(n+1) for i in range(0,n+1)]

for i in range(m):
    a, b = map(int,input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1
visit = [0]*(n+1)

dfs(v)
print()
bfs(v)
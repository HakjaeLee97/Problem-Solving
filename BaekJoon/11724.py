import sys
sys.setrecursionlimit(10000)# 최대 재귀 횟수 설정

N,M = map(int,input().split())
matrix = [[0]*(N+1) for _ in range (N+1)]
visited = [0]*(N+1)


count = 0

for i in range(M):
    u,v = map(int, input().split())
    matrix[u][v] = 1


def DFS(matrix,start,visited):

    visited[start] = 1
    #print(visited)
    for i in range(N+1):
        #print(i)
        if (  visited[i] == 0 )and matrix[start][i] == 1:

            DFS(matrix,i,visited)

#print(visited)

for i in range(1,len(visited)):
    if visited[i] == 0:
        count += 1
        DFS(matrix,i,visited)

print(count)
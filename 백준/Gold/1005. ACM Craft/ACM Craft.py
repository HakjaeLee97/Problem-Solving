import sys
from collections import deque

def topology_sort():
    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)    
    while q:
        now = q.popleft()
        tmp = 0
        for i in required[now]:
            tmp = max(tmp, dp[i])
        dp[now] = times[now] + tmp
        if now == goal:
            return dp[now]

        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)


T = int(sys.stdin.readline())

for _ in range (T):
    N, K = map(int, sys.stdin.readline().split())
    indegree = [0] * (N + 1)
    graph = [ [] for i in range(N + 1)]
    required = [ [] for i in range(N + 1)] #특정 건물을 짓기 위해 필요한 건물을 나타내는 역 그래프
    dp = [0] * (N + 1)
    
    times = [0] + list(map(int, sys.stdin.readline().split()))
    for i in range(K):
        a, b = map(int, sys.stdin.readline().split())
        graph[a].append(b)
        required[b].append(a)
        indegree[b] += 1
    goal = int(sys.stdin.readline())
    print(topology_sort())
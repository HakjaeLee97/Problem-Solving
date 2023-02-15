import sys
from collections import deque

N = int(sys.stdin.readline())
before = [-1 for i in range(N+1)]

visited = [-1 for i in range(N+1)]
queue = deque([N])
visited[N] = 0
while queue:
    start = queue.popleft()
    if start == 1:
        break
    if visited[start // 3] == -1 and start % 3 == 0:
        queue.append(start // 3)
        visited[start // 3] = visited[start] + 1
        before[start // 3] = start
    if visited[start // 2] == -1 and start % 2 == 0:
        queue.append(start // 2)
        visited[start // 2] = visited[start] + 1
        before[start // 2] = start
    if visited[start - 1] == -1:
        queue.append(start - 1)
        visited[start - 1] = visited[start] + 1
        before[start - 1] = start

ans = [1]
key = 1
while before[key] != -1:
    ans.append(before[key])
    key = before[key]
    
print(len(ans) - 1)
for i in range(len(ans) - 1, -1, -1):
    print(ans[i], end = ' ')
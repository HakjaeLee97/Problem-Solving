import sys
from heapq import * 

N, K = map(int, sys.stdin.readline().split())

jewels = []

bags = [0] * K

for i in range(N):
    M, V  = map(int,sys.stdin.readline().split())
    heappush(jewels, [M,V])
for i in range(K):
    bags[i] = int(sys.stdin.readline())
bags.sort()

answer = 0
tmp = []

for bag in bags:
    while jewels and bag>= jewels[0][0]:
        heappush(tmp, -heappop(jewels)[1])
    if tmp:
        answer -= heappop(tmp)
    elif not jewels:
        break

print (answer)
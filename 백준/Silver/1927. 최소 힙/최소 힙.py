import heapq,sys

N = int(sys.stdin.readline())

h = []

for _ in range(N):
  num = int(sys.stdin.readline())
  if num == 0:
    if(len(h) == 0):
      print(0)
    else:
      print(heapq.heappop(h))
  else:
    heapq.heappush(h,num)
from heapq import *
import sys
N = int(sys.stdin.readline())

left = [] #최대 힙
right = [] #최소 힙

for _ in range(N):
  tmp = int(sys.stdin.readline())
  
  if(len(left) == len(right)):
    heappush(left,(-tmp,tmp))
  else:
    heappush(right,(tmp,tmp))
  if(len(right)  == 0 ):
    print(left[0][1])
  else:
    if(right[0][1] < left[0][1]):
      tmp_l = heappop(left)[1]
      tmp_r = heappop(right)[1]
      heappush(left,(-tmp_r,tmp_r))
      heappush(right,(tmp_l, tmp_l))
    print(left[0][1])
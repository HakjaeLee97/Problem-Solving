import sys

N, C = map(int,sys.stdin.readline().split())
houses = []

for i in range(N):
  houses.append(int(sys.stdin.readline()))
houses.sort()

low = 1 #공유기 간 거리의 최소값
high = houses[-1] - houses[0] # 공유기 간 거리의 최대값
result = 0


while low <= high:
  mid = (low+high)//2
  cnt = 1
  prev = houses[0]
  for i in range(1,len(houses)):
    if houses[i] - prev >= mid:
      cnt += 1
      prev = houses[i]
  if cnt >= C:
    result = mid
    low = mid + 1
  else:
    high = mid - 1
print(result)
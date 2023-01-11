import sys

N, X = map(int, sys.stdin.readline().split())

visitor = list(map(int, sys.stdin.readline().split()))

#슬라이딩 윈도우 사용

#초기 X일 방문자 합 구하기
max_visit = 0
#최대  방문기간 개수
period = 0
for _ in range(X):
  max_visit += visitor[_]

tmp = max_visit
if(max_visit > 0):
  period = 1
for i in range(X,N):
  tmp -= visitor[i-X]
  tmp += visitor[i]
  if(tmp > max_visit):
    max_visit = tmp
    period = 1
  elif(tmp == max_visit):
    period += 1
if(max_visit == 0):
  print("SAD")
else:
  print(max_visit)
  print(period)
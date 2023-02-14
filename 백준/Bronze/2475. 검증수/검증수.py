import sys
N = list(map(int,sys.stdin.readline().split()))
result = 0
for i in N:
    result += i * i
print(result % 10)
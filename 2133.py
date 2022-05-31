"""
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
"""

N = int(input())

cases =  [0] * (N+1)
cases[0] = 0
if N >= 2:
    cases[2] = 3
if N >= 4:
    cases[4] = 11

for i in range(1,N+1):
    if N % 2 == 1:
        cases[i] = 0
    elif N >= 5:
        for i in range(4,N+1):
            cases[i] += cases[i-2] + 3
            cases[i] += cases[i-4] + 2

print(cases[N])

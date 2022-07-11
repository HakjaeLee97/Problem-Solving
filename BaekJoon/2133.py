"""
3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
"""

N = int(input())

cases =  [0] * (N+1) # 인덱스와 세로줄의 길이를 맞추기 위함

cases[0] = 1 # cases[0] =1로 하여 j가 들어가는 for문을 간결하게 함 
if N >= 2:
    cases[2] = 3
if N >= 4:
    cases[4] = 11

    if N % 2 == 1:# N이 홀수면 항상 0
        cases[N] = 0
    elif N >= 4:
        for j in range(6,N+1,2):
            cases[j] += cases[j-2] * 3 
            for k in range(4,j+1,2):
                cases[j] += cases[j-k] * 2
                
print(cases[N])

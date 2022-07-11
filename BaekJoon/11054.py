"""
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
"""


N = int(input())
seq = list(map(int, input().split()))
part_seq_inc = [1]*N
part_seq_dec = [1]*N

for i in range(0,N):
    for j in range(0,i):
        if seq[i] > seq[j]:
            part_seq_inc[i] = max(part_seq_inc[i], part_seq_inc[j]+1)
#증가하는 수열의 길이
for i in range(N-1,-1,-1):
    for j in range(N-1,i,-1):
        if seq[i] > seq[j]:
            part_seq_dec[i]  = max(part_seq_dec[i], part_seq_dec[j]+1)
#감소하는 수열의 길이

part_seq_bitonic = [part_seq_dec[i] + part_seq_inc[i] -1 for i in range(N)]
#둘을 합하고 겹치는 분인 1을 빼줌

print(max(part_seq_bitonic))



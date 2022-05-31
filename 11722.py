"""수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다."""

N = int(input())
seq = list(map(int,input().split()))
part_seq = [1] * N

for i in range(0,N):
    for j in range(0,i):
        if seq[i] < seq[j]:
            part_seq[i] = max(part_seq[i], part_seq[j]+1)

print(max(part_seq))
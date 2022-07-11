"""
10989 수 정렬하기 3 
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

"""

import sys

N = int(sys.stdin.readline())
MAX_NUM = 10000

count = [0]*(MAX_NUM+1)

for _ in range(N):
    num = int(sys.stdin.readline())
    count[num] += 1

for i in range(1,MAX_NUM+1):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)

# for i in range(1,MAX_NUM+1):
#     count[i] = count[i-1] + count[i]
# #print(count)

# sorted = [0] *(N+1)

# for i in range(MAX_NUM,0,-1):
#     while count[i] > count[i-1]:
#         sorted[count[i]] = i
#         count[i] -= 1

# #print(sorted)

# # for i in range(1,len(sorted)):
# #     if sorted[i] == 0 and sorted[i-1] > 0:
# #         sorted[i] = sorted[i-1]

# for i in range(1,N+1):
#     print(sorted[i])
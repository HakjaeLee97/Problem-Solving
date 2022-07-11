"""
1373 2진수 8진수

2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
"""

import sys

# N = int(sys.stdin.readline().rstrip(),2)

# print(str(oct(N))[2:])

num =[]
N = (sys.stdin.readline().rstrip())
while len(N) % 3 != 0:
    N = '0' + N

for i in range(len(N) // 3):
    n = N[ i*3 : i*3 + 3]
    cnt = 0
    if n[0] == '1': cnt |= 4
    if n[1] == '1': cnt |= 2
    if n[2] == '1': cnt |= 1
    num.append(cnt)
print(''.join((map(str,num))))
"""
10872 팩토리얼
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
"""

import sys

N = int(sys.stdin.readline())
result = 1
for i in range(2,N+1):
    result *= i
print(result)
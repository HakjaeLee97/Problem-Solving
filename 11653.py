"""
11653 소인수분해

정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.

"""

import sys


num = int(sys.stdin.readline())

while True:
    for i in range(2,int(num)+1):
        if num % i == 0:
            num /= i
            print(i)
            break
    if num == 1:
        break
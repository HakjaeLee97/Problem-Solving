"""
2588 곱셈

"""
import sys
input = sys.stdin.readline

A = int(input())
B = int(input())

mul = B

while mul != 0:
    print(A * (mul %10))
    mul //= 10

ans = A * B
print(ans)
import sys

A,B,C = map(int,sys.stdin.readline().split())

def fpow(a,b,c):
    if b == 1:
        return a % C
    temp = fpow(a, b // 2 , c)

    if b % 2 == 0:
        return temp * temp % C
    else:
        return temp * temp * a % C
print(fpow(A,B,C))
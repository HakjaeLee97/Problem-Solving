"""
1850 최대공약수

모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.

예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.
"""
from sys import stdin

def getgcd(num1,num2):
    while num2>0:
        num1,num2 = num2,num1 % num2
    return num1

if __name__ == "__main__":

    num1,num2 = map(int,stdin.readline().split())


    gcd = getgcd(num1,num2)
    for i in range(gcd):
        print(1,end='')


    100 1002
    


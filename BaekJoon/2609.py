"""
2609 최대공약수와 최소공배수

두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
"""
from sys import stdin

def getgcd(num1,num2):
    while num2>0:
        num1,num2 = num2,num1 % num2
    return num1

def getlcm(num1,num2):

    return int(num1 * num2 / (getgcd(num1,num2)))

num1,num2 = map(int,stdin.readline().split())

print(getgcd(num1,num2))
print(getlcm(num1,num2))


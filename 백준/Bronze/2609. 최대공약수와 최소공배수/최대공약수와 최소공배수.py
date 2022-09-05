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
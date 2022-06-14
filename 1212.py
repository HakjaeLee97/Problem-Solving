"""
1212 8진수 2진수
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

"""

import sys

num =[]
N = (sys.stdin.readline().rstrip())

for i in range(len(N)):
    n = N[i]
    cnt = ''
    if n == '1': cnt = '001'
    elif n == '2': cnt = '010'
    elif n == '3': cnt = '011'
    elif n == '4': cnt = '100' 
    elif n == '5': cnt = '101'
    elif n == '6': cnt = '110'
    elif n == '7': cnt = '111'       
    elif n == '0': cnt = '000'    
    num.append(cnt)

num = (''.join(num)).lstrip('0')
if num =='':
    print(0)
else:
    print(num)

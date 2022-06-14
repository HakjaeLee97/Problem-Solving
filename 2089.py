"""
2089 -2진수

-2진법은 부호 없는 2진수로 표현이 된다. 2진법에서는 20, 21, 22, 23이 표현 되지만 -2진법에서는 (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8을 표현한다. 10진수로 1부터 표현하자면 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 등이다.

10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.
"""

import sys

n =  int(sys.stdin.readline())
if n == 0:
    print(0)
    
result = []
while(n != 0):
    res = n % -2
    if res == -1:
        res = 1
        n //= -2 
        n += 1
    else:
        n //= -2
    result.append(res)



result.reverse()
for i in result:
    print(i,end='')

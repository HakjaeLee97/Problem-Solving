"""
2745 진법 변환

B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

"""

import sys

n, b = sys.stdin.readline().split()
b= int(b)
sum = 0
c = 1
for i in range(len(n) -1 ,-1,-1):
    if ord(n[i]) >= ord('A'):
        this =  ord(n[i]) - ord('A') + 10
    else:
        this  = int(n[i])

    sum += this * c

    c *= b 
    #n = n[:len(n)-1]
print(sum)
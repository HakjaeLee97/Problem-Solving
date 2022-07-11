"""
2004 조합 0의 개수
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
"""

import sys

def check_2or5(num):
    num = num
    cnt_2,cnt_5 = 0,0
    while True:
        if num % 2 == 0:
            cnt_2 += 1
            num /= 2
        elif num % 5 == 0:
            cnt_5 += 1
            num /= 5
        else:
            break
    return cnt_2,cnt_5

def calc(N,start = 2):
    cnt_2 ,cnt_5 = 0,0    
    for i in range(start+1,N+1):
        cnt_2, cnt_5 = tuple(sum(elem) for elem in zip((cnt_2,cnt_5),check_2or5(i)))
    return cnt_2,cnt_5

if __name__ == "__main__":
    
    n , m = map(int,(sys.stdin.readline().split()))
    upper = calc(n,m)
    lower2 = tuple(-1*elem for elem in calc(n-m))
    final = tuple(sum(elem) for elem in zip(upper,lower2))
    print(min(final))


"""
1676 팩토리얼 0의 개수
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
"""
import sys

N = int(sys.stdin.readline())


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

cnt_2 ,cnt_5 = 0,0
for i in range(2,N+1):
    cnt_2, cnt_5 = tuple(sum(elem) for elem in zip((cnt_2,cnt_5),check_2or5(i)))
print((min(cnt_2,cnt_5)))


import sys


num = int(sys.stdin.readline())

while True:
    for i in range(2,int(num)+1):
        if num % i == 0:
            num /= i
            print(i)
            break
    if num == 1:
        break
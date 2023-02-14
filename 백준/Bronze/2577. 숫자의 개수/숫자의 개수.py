import sys
res = 1
for _ in range(3):
    res *= int(sys.stdin.readline())
cnts = [0]*10
for i in str(res):
    cnts[ord(i)-ord('0')] += 1
for i in (cnts):
    print (i)
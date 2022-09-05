
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
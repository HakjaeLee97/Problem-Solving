import sys
max, maxcnt = 0, 0
for _ in range(9):
    tmp = int(sys.stdin.readline())
    if tmp > max:
        max = tmp
        maxcnt = _ + 1
print(max)
print(maxcnt)
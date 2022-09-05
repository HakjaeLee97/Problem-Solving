
from sys import stdin

str = stdin.readline().strip()

suffix = []

for i in range(0,len(str)):
    suffix.append(str[i:])
suffix.sort()
for suf in suffix:
    print(suf)

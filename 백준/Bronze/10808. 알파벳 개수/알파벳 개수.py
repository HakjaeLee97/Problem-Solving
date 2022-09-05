
from sys import stdin
from collections import defaultdict

str = stdin.readline()

freq = defaultdict(int)
def init(dict):
    str = 'abcdefghijklmnopqrstuvwxyz'
    for char in str:
        dict[char] = 0

init(freq)

for char in str:
    if char in freq:
        freq[char] +=1
freq = sorted(freq.items())

for k in freq:
    if k != 'z':
        print(k[1], end = ' ')
    else:
        print(k[1],end = '')
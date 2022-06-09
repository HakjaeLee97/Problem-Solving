"""
10808 알파벳 개수

알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
"""

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
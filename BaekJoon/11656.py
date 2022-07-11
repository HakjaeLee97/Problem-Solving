"""
11656 접미사 배열

접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
"""

from sys import stdin

str = stdin.readline().strip()

suffix = []

for i in range(0,len(str)):
    suffix.append(str[i:])
suffix.sort()
for suf in suffix:
    print(suf)

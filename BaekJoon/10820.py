"""
10820 문자열 분석
문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.

각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
"""

from sys import stdin

lines = stdin.readlines()

for line in lines:
    small = 0 #소문자 개수
    large = 0 #대문자 개수
    nums = 0 #숫자 개수
    spaces = 0 #공백 개수

    for char in line:
        if 'a' <= char  and char <= 'z':
            small += 1
        elif 'A' <= char and char <= 'Z':
            large +=1 
        elif '0' <= char and char <= '9':
            nums += 1
        elif ' ' == char:
            spaces +=1
    print(small,large,nums,spaces)
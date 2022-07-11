"""
1978 소수 찾기

주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
"""

import sys

M, N = list(map(int,sys.stdin.readline().split()))

nums = [i for i in range(N+1)]


prime = [True]*(N+1)
prime[0] = False
prime[1] = False

for i in range(len(prime)):
    if i >= int(N**0.5)+1:
        break
    if prime[i]:
        for j in range(i*2,N+1,i):
            prime[j] = False
for i in range(M,len(prime)):
    if prime[i]:
        sys.stdout.write(str(nums[i])+'\n')
        
"""
9613 GCD 합

양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
"""

import sys, math

t=int(sys.stdin.readline())


for _ in range(t):

    nums = list(map(int, sys.stdin.readline().split()))
    nums = nums[1:]
    sum = 0
    for i in range(len(nums)):
        for j in range(len(nums)-1,i,-1):
 
            sum+= math.gcd(nums[i],nums[j])
    print(sum)

"""

4 10 20 30 40

2
4
2
4

10
10
10

10
20

10


"""
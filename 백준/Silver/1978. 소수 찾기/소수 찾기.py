import sys

N = int(sys.stdin.readline())

nums = list(map(int,sys.stdin.readline().split()))

#max = (int(1000**0.5))+1
primes= [2,3,5,7,11,13,17,19,23,29,31]

for prime in primes:
    idx = 0
    while idx <= len(nums)-1:
        if (nums[idx] % prime == 0 or nums[idx] == 1) and nums[idx] != prime: #소수가 아님
            del nums[idx]
        else:
            idx += 1
print(len(nums))
"""
2751 수 정렬하기 2
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
"""

import sys

N = int(sys.stdin.readline())
nums = []
for _ in range(N):
    nums.append(int(sys.stdin.readline()))
#N이 최대 1000000개이므로 input() 대신 sys.stdin.readline()을 사용한다

def merge_sort(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) //2
    low_arr = merge_sort(arr[:mid])
    high_arr = merge_sort(arr[mid:])

   
    l ,h, k = 0, 0, 0
    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l] < high_arr[h]:
            arr[k] = (low_arr[l])
            l += 1

        else:
            arr[k] = (high_arr[h])
            h += 1
        k += 1
    if l == len(low_arr):
        while h < len(high_arr):
            arr[k] = high_arr[h]
            h += 1
            k +=1
    elif h == len(high_arr):
        while l < len(low_arr):
            arr[k] = low_arr[l]
            l += 1
            k += 1
    return arr


merge_sort(nums)

for i in nums:
    print(i)
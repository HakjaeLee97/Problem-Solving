"""
10814 나이순 정렬

온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
"""
#stable 정렬을 해야 한다.
import sys

N = int(sys.stdin.readline())
names= []
for _ in range(N):
    age, name = sys.stdin.readline().split()
    age = int(age)
    names.append([age,name])


def merge_sort(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) //2
    low_arr = merge_sort(arr[:mid])
    high_arr = merge_sort(arr[mid:])

   
    l ,h, k = 0, 0, 0
    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l][0] <= high_arr[h][0]:
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

merge_sort(names)

for i in names:
    print(i[0], i[1])
"""
11651 좌표 정렬하기 2
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
"""



import sys

N = int(sys.stdin.readline())
dots = []
for _ in range(N):
    x, y = map(int,sys.stdin.readline().split())
    dots.append([x,y])


def merge_sort(dots_arr):
    if len(dots_arr) < 2:
        return dots_arr

    mid = len(dots_arr) // 2
    low_arr = merge_sort(dots_arr[:mid])
    high_arr = merge_sort(dots_arr[mid:])

    l,h,k = 0,0,0 #low_arr, high_arr, arr의 포인터
    
    while l < len(low_arr) and h < len(high_arr) :
        if low_arr[l][1] <= high_arr[h][1]:
            if low_arr[l][1] < high_arr[h][1]: 

                dots_arr[k] = low_arr[l]
                l += 1
            elif low_arr[l][0] < high_arr[h][0]: # y좌표가 같은경우 x좌표 비교
                dots_arr[k] = low_arr[l]
                l += 1
            else:
                dots_arr[k] = high_arr[h]
                h += 1

        else:
            dots_arr[k] = high_arr[h]
            h += 1
        k+=1
    if l == len(low_arr):
        while h < len(high_arr):
            dots_arr[k] = high_arr[h]
            h +=1
            k +=1
    if h == len(high_arr):
        while l < len(low_arr):
            dots_arr[k] = low_arr[l]
            l += 1
            k +=1 
    return dots_arr
merge_sort(dots)

for i in dots:
    print(i[0],i[1])
    
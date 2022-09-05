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
    
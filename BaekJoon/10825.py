"""
10825 국영수

도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)

"""


import sys
sys.setrecursionlimit(10**5) #recursion error 방지

N = int(sys.stdin.readline())

scores = []

for _ in range(N):
    name,kor,eng,math = sys.stdin.readline().split()
    kor, eng, math = map(int,(kor,eng,math))
    scores.append([name,kor,eng,math])


def quick_sort(arr,subject):
    sub = subject 
    if len(arr) <= 1:
        return arr

    if subject == 0: #국어 점수 비교
        index = 1
        desc = 1 #내림차순

    elif subject == 1: #영어 점수 비교
        index = 2
        desc = 0 # 오름차순
    
    elif subject ==2: #수학 점수 비교
        index = 3
        desc = 1 #내림차순
    elif subject == 3: # 이름 비교
        index = 0
        desc = 0 #오름차순 
    else:
        index = -1
        desc = -1

    if subject == 3:
        pivot = arr[0][index]
    else:
        #print(arr)
        pivot = arr[len(arr) // 2 ][index]

    lesser_arr, equal_arr, greater_arr = [],[],[]




    if desc == 0: # 오름차순
        for num in arr:
            if num[index] < pivot:
                lesser_arr.append(num)
            elif num[index] > pivot:
                greater_arr.append(num)
            else:
                equal_arr.append(num)
        return quick_sort(lesser_arr,sub) + quick_sort(equal_arr,(sub+1)) + quick_sort(greater_arr,sub)
    else: #내림차순 정렬
        for num in arr:
            if num[index] > pivot:
                lesser_arr.append(num)
            elif num[index] < pivot:
                greater_arr.append(num)
            else:
                equal_arr.append(num)
        return quick_sort(lesser_arr,sub) + quick_sort(equal_arr,(sub+1)) + quick_sort(greater_arr,sub)        

sorted_scores  = quick_sort(scores,0)

for i in sorted_scores:
    print(i[0])

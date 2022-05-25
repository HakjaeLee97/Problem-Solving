N = int(input())


# 1 <= N <= 10**6


#동적계획법을 사용한다.
#부분해가 전체 문제의 해를 구하는데 사용된다.
#ex) 18을 3으로 나눴을 떄 나온 값인 6에 대한 해가 있으면 그 해 + 1이 전체 문제의 해이다.

answer_list = [0] * (N + 1)

if N == 1:
    print(0)
elif N ==2:
    print(1)
elif N ==3:
    print(1)


else:
    
    answer_list[1] = 0 #1은 0회 연산
    answer_list[2] = 1 #2는 1회 연산
    answer_list[3] = 1 #3은 1회 연산


    for i in range(2,N+1):
        temp_answer= [1000000,1000000,1000000]
        
        if i % 3 == 0:
            temp_answer[0] = answer_list[int(i/3)] + 1
        if i % 2 == 0:
            temp_answer[1] = answer_list[int(i/2)] + 1
        
        temp_answer[2] = answer_list[i-1] + 1

        answer_list[i] = min(temp_answer)

    #print(answer_list)

    print(answer_list[N])



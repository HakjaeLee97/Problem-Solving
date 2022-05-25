N = int(input())

answer_list = [0] * N

if N ==1:
    print(1)
elif N == 2:
    print(3)

else:
    answer_list[0] = 1
    answer_list[1] = 3
    answer_list[2] = 5 
    
    for i in range(3,N):
        answer_list[i] = answer_list[i-2] *2 + answer_list[i-1] 

    print(answer_list[N-1]%10007)


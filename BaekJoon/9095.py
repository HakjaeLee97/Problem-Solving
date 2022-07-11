#from cgi import test


T = int(input())
test_cases = [input() for _ in range(T)]
#print(test_cases)

def calc_sum(N):
#    N = int(input())

    if N == 1:
        print(1)
    elif N ==2:
        print(2)
    elif N == 3:
        print(4)
    else:
        answer_list = [1,2,4]
        answer_list_res = [0] * (N - 3)
        answer_list.extend(answer_list_res)
        for i in range(3,N):
            answer_list[i] = answer_list[i-3] + answer_list[i-2] + answer_list[i-1]

        print(answer_list[N-1])

for i in range(0,T):
    calc_sum(int(test_cases[i]))
T = int(input())
for test_case in range(1, T + 1):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    res = -201
    tmp =0
    if N <= M:
        for j in range(0,M-N+1):
            for i in range(0,N):
                tmp += (A[i] * B[i + j])
            if tmp > res:
        
                res = tmp
            tmp = 0 
    else:
        for j in range(0,N-M+1):
            for i in range(0,M):
                tmp += (A[i+j] * B[i])
            if tmp > res:
        
                res = tmp
            tmp = 0         
    print("#%d"%test_case,res)
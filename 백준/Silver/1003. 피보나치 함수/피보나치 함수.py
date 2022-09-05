import sys
input = sys.stdin.readline #input()보다 sys.stdin.readline()이 빠름

#문제에서 주어진 함수
# def fibonacci(n):
#     if (n == 0):
#         print("0")
#         return 0
#     elif (n == 1):
#         print("1")
#         return 1
#     else: 
#         return (fibonacci(n-1) + fibonacci(n-2))


T = int(input())

for _ in range(T): # 반복의 횟수만이 중요하기 때문에 따로 변수를 지정하지 않고 _로 씀
    N = int(input())
    dp=[[0,0] for i in range(N+1)] # dp 배열은 [[0,0], [0,0],[0,0], .... ,[0,0]] 으로 초기화됨
    dp[0] = [1,0] # fibonacci(0) 호출시 0 1회 1 0회 출력

    if N >= 1: # N이 0으로 입력됐을 때 indexerror 방지
        dp[1] = [0,1] # fibonacci(1) 호출시 0 0회 1 1회 출력
    if N >= 2:
        for i in range(2,N+1):
            dp[i] = [dp[i-1][j] + dp[i-2][j] for j in range(2)]
    print(' '.join(map(str,dp[N])))
    

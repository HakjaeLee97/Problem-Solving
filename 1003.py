"""
1003 피보나치 함수

다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.

int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.

fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
fibonacci(0)은 0을 출력하고, 0을 리턴한다.
fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

"""
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
            dp[i] = [dp[i-1][j] + dp[i-2][j] for j in range(2)] #dp[i]의 각 항끼리 더함
    print(' '.join(map(str,dp[N])))
    

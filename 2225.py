N , K = map(int,(input().split()))


dp = [[ 0 for col in range(K+1)] for row in range(N+1)]
dp[0][0] = 1
#for n in range(N+1):
    #dp[1][n] = 1

for i in range(0,N+1):
    #dp[i][1] = i
    for j in range(1,K+1):
            dp[i][j] = dp[i][j-1] + dp[i-1][j]
print(dp[N][K]%1000000000) 
#dp[2][2] = dp[2][1] + dp[1][1] + dp[0][1]
#(1,1),(2,0),(0,2) = (2,0) + (1,1) + (0,2)        
"""
0부터 n까지의 정수 k개를 더해서 그 합이 n이 되는 경우의 수
(n,k)

(n,k) = (n, k-1) + (n-1, k-1) + (n -2, k-1) + ... (1,k-1) + (0, k-1)



""" 

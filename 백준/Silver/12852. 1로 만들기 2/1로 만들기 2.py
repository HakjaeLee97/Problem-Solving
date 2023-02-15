import sys
N = int(sys.stdin.readline())
dp = [0] * (N + 1)
hist = [[]for i in range(N+1)]

dp[1] = 0
hist[1] = [1]


for i in range(2,N+1):
    dp[i] = dp[i-1] + 1
    hist[i] = i - 1
    if i % 3 == 0 and dp[i] > dp[i//3] + 1:
        dp[i] = dp[i//3] +1
        hist[i] = i//3
    if i % 2 == 0 and dp[i] > dp[i//2] + 1:
        dp[i] = dp[i//2] + 1
        hist[i] = i//2


print(dp[N])
h = N
while True:
    print(h, end=' ')
    if h == 1:
        break
    h = hist[h]
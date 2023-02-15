import sys
N = int(sys.stdin.readline())
dp = [0] * (N + 1)
hist = [[]for i in range(N+1)]

if N == 1:
    print(0)
    print(1)
elif N ==2:
    print(1)
    print("2 1")
elif N ==3:
    print(1)
    print("3 1")

else:
    dp[1] = 0
    hist[1] = [1]
    dp[2] = 1 
    hist[2] = [2, 1]
    dp[3] = 1 
    hist[3] = [3, 1] 


    for i in range(2,N+1):
        tmp= [1000000,1000000,1000000]
        
        if i % 3 == 0:
            tmp[0] = dp[int(i/3)] + 1
        if i % 2 == 0:
            tmp[1] = dp[int(i/2)] + 1
        
        tmp[2] = dp[i-1] + 1

        next = min(tmp)
        dp[i] = next
        if tmp[0] == next:
            hist[i] = [i] + hist[int(i/3)]
        elif tmp[1] == next:
            hist[i] = [i] + hist[int(i/2)]
        else:
            hist[i] = [i] + hist[i-1]


    print(dp[N])
    for i in hist[N]:
        print (i, end = " ")


T = int(input())

for test_case in range(1,T + 1):
    N,M = map(int,input().split())
    flies = []
    for _ in range(N):
        flies.append(list(map(int,input().split())))
    dead_fly = 0
    if N == M:
        for _ in range(N):
            dead_fly += sum(flies[_])    
        print("#%d"%test_case,dead_fly)
    else:
        tmp = 0
        for i in range(N-M+1):
            for j in range(N-M+1):
                for k in range(M):
                    tmp += sum(flies[i+k][j:j+M])
                if tmp > dead_fly:
                    dead_fly = tmp
                tmp = 0
        print("#%d"%test_case,dead_fly)

    
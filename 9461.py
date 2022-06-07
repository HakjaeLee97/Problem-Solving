T = int(input())


for _ in range(T):
    N = int(input())
    p= [0] * (N+6)
    
    p[1] = 1
    p[2] = 1
    p[3] = 1
    p[4] = 2
    p[5] = 2
    
    for i in range(6,N+1):
        p[i] = p[i-1] + p[i-5]
    print(p[N])
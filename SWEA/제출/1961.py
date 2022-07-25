T = int(input())
for test_case in range(1,T+1):
    N = int(input())
    mat = []
    for _ in range(N):
        mat.append(list(map(int,input().split())))
    print("#%d"%test_case)
    for j in range(1,N+1):
        for i in range(1,N+1):
            print(mat[N-i][j-1],end='')
        print(' ',end='')
        for i in range(1,N+1):
            print(mat[N-j][N-i],end='')
        print(' ',end='')
        for i in range(1,N+1):
            print(mat[i-1][N-j],end ='')
        print()
        
    
import sys

def subset(depth, sindex, eindex, i):
    global ans,x,y
    if depth == N:
        ans =  min(ans,calc())
    
    if sindex < N/2:
        x -= dots[i][0]
        y -= dots[i][1]
        subset(depth+1, sindex +1,eindex, i+1)
        x += dots[i][0]
        y += dots[i][1]

    if eindex < N/2:
        x += dots[i][0]
        y += dots[i][1]
        subset(depth+1, sindex, eindex+1, i+1)
        x -= dots[i][0]
        y -= dots[i][1]

def calc():
    result = (x ** 2 + y ** 2)**0.5
    return result

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    dots = [ [] for i in range(N) ]
    for i in range(N):
        dots[i] = list(map(int,sys.stdin.readline().split()))
    ans = 10 ** 7
    x, y = 0, 0
    subset(0,0,0,0)
    print(ans)

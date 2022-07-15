from collections import deque

T= 10

dx,dy = [-1,1,0,0],[0,0,-1,1]

for test_case in range(1,T+1):
    tc = int(input())
    road_map = [list(map(int,list(input()))) for _ in range(16)]

    x, y = 0,0
    queue = deque()
    queue.append(x,y)

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x +dx[i] , y+ dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if road_map[nx][ny] ==0:
                continue
            if road_map[nx][ny]== 1:
                road_map[nx][ny] = road_map[x][y] + 1
                queue.append((nx,ny))
    
    print("#%d"%test_case,road_map[N-1][N-1])

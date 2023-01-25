import sys
from collections import deque

#불이 번지는 처리
def fire_spread():
    while(len(fq) != 0):
        now = fq.popleft()
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if(nx >= R or nx < 0 or ny >= C or ny < 0 or maze[nx][ny] != '.') : 
                continue
            elif(maze[nx][ny] == '.'):
                maze[nx][ny] = now[2] + 1
                fq.append([nx,ny,now[2]+1])

            elif maze[nx][ny] > now[2] + 1:
                maze[nx][ny] = now[2] + 1
                fq.append([nx,ny,now[2]+1])


#지훈이 이동하는 bfs
def bfs_jihun():
    while(len(q) != 0):
        now = q.popleft()
        if(now[0] == R-1 or now[0] == 0 or now[1] == C-1 or now[1] == 0 ):
            if maze[now[0]][now[1]] == '.' or now[2]  < maze[now[0]][now[1]]:
                return now[2]
        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if(nx >= R or nx < 0 or ny >= C or ny < 0 or maze[nx][ny] == '#' or visited_J[nx][ny] == True) : 
                continue
            q.append([nx,ny, now[2]+1])
            visited_J[nx][ny] = True
    return "IMPOSSIBLE"


if __name__ == "__main__":
    # sys.stdin = open("input.txt")
    # 입력값 받기
    R, C = map(int,sys.stdin.readline().split())
    maze = [list(sys.stdin.readline().rstrip()) for _ in range (R)]
   
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    q = deque() #지훈이가 있을 수 있는 위치들 bfs용 큐
    fq = deque() #불의 위치 bfs용 큐

    #지훈이의 초기위치 찾기 및 불 변경

    for i in range(R):
        for j in range(C):
            if maze[i][j] == 'J':
                q.append([i,j,1]) # 리스트의 3번째 값은 분을 체크하는 용도
                maze[i][j] = '.' # 지나갈 수 있는 공간으로 변경처리
            elif maze[i][j] =='F':
                maze[i][j] = 1 # 숫자로 변경
                fq.append([i,j,1])

    #지훈이 방문처리용 배열
    visited_J = [[False]*C for _ in range(R)]

    fire_spread()

    print(bfs_jihun())

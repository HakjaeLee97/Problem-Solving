T = int(input())
for test_cases in range(1,T+1):
    N,K = map(int,input().split())
    puzzle = []
    result = 0
    for i in range(N):
        puzzle.append(input().split() + ['0'])
    puzzle.append(['0']*(N+1))
    for i in range(N+1):
        count = 0
        for j in range(N+1):
            if puzzle[i][j] == '1':
                count += 1

            elif puzzle[i][j] == '0' and count == K:
                result += 1
                count = 0
            else:
                count = 0

    for i in range(N+1):
        count = 0
        for j in range(N+1):
            if puzzle[j][i] == '1':
                count += 1
            elif puzzle[j][i] == '0' and count == K:
                result += 1
                count = 0
            else:
                count = 0
    print("#%d"%test_cases,result)

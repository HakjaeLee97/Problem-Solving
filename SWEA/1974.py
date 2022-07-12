

T = int(input())
for test_case in range(1,T+1):
    sdoku = []
    for _ in range(9):
        sdoku.append(list(map(int,input().split())))
    small_square = [0] * 9
    row = small_square[:]
    col = small_square[:]

    ans = 1
    for i in range(9):
        for j in range(9):
            row[sdoku[i][j]-1] += 1
            col[sdoku[j][i]-1] += 1
        for ele in row:
            if ele != 1:
                ans = 0
        for ele in col:
            if ele != 1:
                ans = 0
        row = [0] * 9
        col = [0] * 9
    for l in range(0,9,3):
        for k in range(0,9,3):
            for i in range(0,3):
                for j in range(0,3):
                    small_square[sdoku[i+l][j+k]-1] += 1
            for ele in small_square:
                if ele != 1:
                    ans = 0
            small_square = [0] * 9

    print("#%d"%test_case,ans)
    


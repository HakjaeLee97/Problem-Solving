T = int(input())
for _ in range(0,T): #테스트 케이스만큼 반복
    n = int(input())
    scores = [list(map(int, input().split())) for _ in range(2)]

    max_scores = [[0]*n, [0]*n]
    if n == 1:
        
        print(max(scores[0][0],scores[1][0]))
    
    else:
        max_scores[0][0] = scores[0][0]
        max_scores[1][0] = scores[1][0]        
        
        max_scores[0][1] = scores[1][0]+scores[0][1]
        max_scores[1][1] = scores[0][0]+scores[1][1]


        for i in range(2,n):

            max_scores[0][i] = max(max_scores[1][i-1] + scores[0][i], max_scores[1][i-2] + scores[0][i])
            max_scores[1][i] = max(max_scores[0][i-1] + scores[1][i], max_scores[0][i-2] + scores[1][i])

        print(max(max_scores[0][n-1], max_scores[1][n-1]))

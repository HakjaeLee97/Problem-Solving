import sys

N, B  = map(int,(sys.stdin.readline().split()))

matrix = [[0]*N for _ in range(N)]

#분할정복
# A ^ B = (A ^ (B/2)) * (A ^ (B/2))
dict= {}

#행렬 입력 받기 
for _ in range(N):
    matrix[_] = list(map(int,sys.stdin.readline().split()))


#행렬곱 함수
def mul(mat1,mat2,N):
    result = [[0]*N for _ in range(N)]
    for row in range(N):
        for col in range(N):
            for i in range(N):
                result[row][col] += mat1[row][i] * mat2[i][col]
            result[row][col] %= 1000       
    return result

#결과 출력 함수 
def printmat(mat,N):
    for row in range(N):
        for col in range(N):
            print(mat[row][col] % 1000, end = ' ')
        print()
    return

#행렬 거듭제곱 함수
def matpower(mat,N,B,dict):
    if B in dict: 
        return dict[B]
    elif B == 1:
        dict[B] = mat
        return mat
    elif B % 2 == 0:
        dict[B] = mul(matpower(mat,N,B//2,dict), matpower(mat,N,B//2, dict),N)
        return dict[B]
    else:
        dict[B] = mul(matpower(mat,N,B//2, dict), matpower(mat,N,B//2+1, dict),N)
        return dict[B]


printmat(matpower(matrix,N,B, dict),N)

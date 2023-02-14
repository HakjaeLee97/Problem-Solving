import sys
# 각 사람을 집합으로 만듦
# 진실을 아는 사람들을 전부 하나의 집합으로 union
# 각 파티를 하나의 집합으로 union
# 마지막에 집합의 개수 - 1이 결과

def init(N):
    parent = [i for i in range ( 0, N +1 )] 
    return parent
def union(a,b, parent):
    a = find(a, parent)
    b = find(b, parent)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
def find(x, parent):
    if parent[x] != x:
        parent[x] = find(parent[x],parent)
    return parent[x]
if __name__ == "__main__":
    N, M = map(int,sys.stdin.readline().split() )
    parent = init(N)

    #진실을 아는 사람들
    truth = list(map(int, sys.stdin.readline().split()))
    #유니온 처리
    if(truth[0] >= 2):
        for i in range(1, truth[0] ):
            union(truth[i],truth[i+1], parent)

    heads = [] # 각 파티별 대표 멤버 저장하는 리스트

    #각 파티 별 반복
    for i in range(M):
        party = list(map(int, sys.stdin.readline().split()))
        heads.append(party[1])
        for j in range(1,party[0]):
            union(party[j], party[j+1],parent)
    
    #거짓말이 가능한 파티 수 세기
    result = 0
    for i in range(M):
        if truth[0] == 0 or find(heads[i],parent) != find(truth[1],parent):
            result+=1
    print(result)
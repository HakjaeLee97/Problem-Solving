M=int(input())
N=int(input())

cnt=0
list=[]

for i in range(M,N+1): # M부터 N까지 돈다
    cnt=0 # cnt는 i가 증가할때마다 초기화 됨
    for j in range(2,(M+1)): #1부터 M까지 돈다.
        if i % j == 0: # i를 j로 나눈 나머지가 0이면
            cnt += 1 # cnt를 더한다
    if cnt == 0:  # 끝까지 돌았는데 cnt가 2이면
        list.append(i)  # 리스트에 i를 더한다.

if len(list) == 0:
    print(-1)
else:
    print(sum(list))
    print(min(list))


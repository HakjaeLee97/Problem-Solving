import sys

def subset_sum(seq,depth, sum,result):
    if depth == len(seq): 
        result.append(sum)
        return
    sum += seq[depth]
    subset_sum(seq,depth+1,sum, result)
    sum -= seq[depth]
    subset_sum(seq,depth+1,sum, result)

N,S = map(int,sys.stdin.readline().split())
seq = list(map(int, sys.stdin.readline().split()))

left = seq[:N//2]
right = seq[N//2:]

lsum = []
rsum = []
subset_sum(left,0,0,lsum)
subset_sum(right,0,0,rsum)

lsum.sort()
rsum.sort()

pos1 = 0
pos2 = len(rsum)-1
count = 0

while pos1<len(lsum) and pos2 >= 0:
    if lsum[pos1] + rsum[pos2] < S:
        pos1 +=1 
    elif lsum[pos1] + rsum[pos2] == S:
        tmp = lsum[pos1]
        lcnt = 0
        while pos1 < len(lsum) and lsum[pos1] == tmp:
            lcnt += 1
            pos1 += 1
        tmp = rsum[pos2]
        rcnt = 0
        while pos2>= 0 and rsum[pos2] == tmp:
            rcnt += 1
            pos2 -= 1
        count += lcnt * rcnt
    else:
        pos2 -= 1
if S != 0:
    print(count)
else:
    print(count-1)
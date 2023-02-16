import sys
input=sys.stdin.readline

n,m=map(int,input().split())
arr=list(map(int,input().split()))
answer=0 if m!=0 else -1
dic={}

def lback(idx,end,ssum,s):
    if idx==end:
        if s.get(ssum)==None:
            s[ssum]=1
        else:
            s[ssum]+=1
        return
    lback(idx+1,end,ssum,s)
    lback(idx+1,end,ssum+arr[idx],s)

def rback(idx,end,ssum,s):
    if idx==end:
        if s.get(m-ssum)!=None:
            global answer
            answer+=s[m-ssum]
        return
    rback(idx+1,end,ssum,s)
    rback(idx+1,end,ssum+arr[idx],s)
    
lback(0,n//2,0,dic)
rback(n//2,n,0,dic)

print(answer)     
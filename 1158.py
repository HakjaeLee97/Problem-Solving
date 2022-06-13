"""
1158 요세푸스 문제

요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
"""
import sys
 
# 세그먼트 트리 생성
input = sys.stdin.readline

def init(node, start, end):
  if start == end:
    tree[node] = 1
    return
  
  mid = (start+end)//2
  init(2*node, start, mid)
  init(2*node+1, mid+1, end)
  tree[node] = tree[node*2]+tree[node*2+1]


def query(node, start, end, order):
  tree[node] -= 1
  if start == end:
    return start
  mid = (start+end)//2
  if tree[2*node] >= order:
    return query(2*node, start, mid, order)
  
  return query(2*node+1, mid+1, end, order - tree[2*node])


n, k = map(int, input().split())
tree = [0]*300000
order = k
init(1,1,n)
print("<", end = "")
for _ in range(1, n):
  print(query(1,1,n, order), end = ", ")
  order += k-1
  order = (order-1)%tree[1]+1

print(query(1,1,n,order), end = ">")
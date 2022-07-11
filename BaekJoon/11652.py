import sys
from collections import defaultdict

INF = 2**62

N = int(sys.stdin.readline())
dic = defaultdict(int)

max_count = 1
for _ in range(N):
    num = int(sys.stdin.readline())
    dic[num] += 1
    if dic[num] > max_count:
        max_count = dic[num]

#print(dic)
result = INF
#print("max",max_count)
for ele in dic:
    if dic.get(ele) == max_count and result > ele:
        result = ele


print(result)

# maxes = [k for k, v in dic.items() if max(dic.values()) == v]
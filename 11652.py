import sys

INF = 100000

N = int(sys.stdin.readline())
dic = {}
for _ in range(N):
    num = int(sys.stdin.readline())
    max_count = 1
    if num in dic:
        dic[num] += 1
        if dic[num] > max_count:
            max_count = dic[num]
    else:
        dic[num] = 1
result = INF
for ele in dic:
    if dic.get(ele) == max_count and result > dic.get(ele):
        result = ele

print(result)

# maxes = [k for k, v in dic.items() if max(dic.values()) == v]
N = int(input())

last_num_freq = [0,1]
new_freq = [0,1]
for i in range(1,N):
    new_freq[0] = last_num_freq[0] + last_num_freq[1]
    new_freq[1] = last_num_freq[0]
    last_num_freq = new_freq[:] # 리스트 복사 방지
print(last_num_freq)
print(sum(last_num_freq))
"""
1
10
100 101
1000 1010 1001
"""
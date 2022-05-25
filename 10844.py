
N = int(input())


last_num_freq=[0,1,1,1,1,1,1,1,1,1]
new_freq = [0]*10
for i in range(1,N):
    new_freq[0] = last_num_freq[1]
    for j in range(1,9):
        new_freq[j] = last_num_freq[j-1] + last_num_freq[j+1]
    new_freq[9] = last_num_freq[8]
    last_num_freq = new_freq[:] # 리스트 복사 방지

#print(last_num_freq)
print(sum(last_num_freq) % 1000000000)
"""


1 2 3 4 5 6 7 8 9  / 0,1,1,1,1,1,1,1,1,1

10
12 
21 23
32 34
43 45
54 56
65 67
76 78
87 89
98  / 1, 1, 2, 2, 2, 2, 2, 2, 2, 1


210
101 121 321
212 232 432
123 323 343 543

/ 1 3 3 4 4 4 4 4 3 2
32개

"""
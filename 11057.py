
N = int(input())


last_num_freq=[1,1,1,1,1,1,1,1,1,1]
new_freq = [0]*10
for i in range(1,N):

    for j in range(0,10):
        temp = 0
        for k in range(j,10):
            temp += last_num_freq[k]
        new_freq[j] = temp


    last_num_freq = new_freq[:] # 리스트 복사 방지

#print(last_num_freq)
print(sum(last_num_freq) % 10007)
"""


0 1 2 3 4 5 6 7 8 9  / 1,1,1,1,1,1,1,1,1,1

00 01 02 03 04 05 06 07 08 09
11 12 13 14 15 16 17 18 19
22 23 24 25 26 27 28 29
33 34 ....
44 45 ..
55 56 ..
66 67 ..
77 78 79
88 89
99  / 10, 9, 8 ,7 ,6 ,5 ,4 ,3 ,2 ,1 


"""
N = int(input())
seq = list(map(int,(input().split())))

part_seq = [1]*N
#for _ in range(N):
#    part_seq.append([])

#part_seq[0].append(seq[0])

for i in range(N):
    for j in range(i):
        if seq[i] > seq[j]:
            part_seq[i] = max(part_seq[i],part_seq[j] + 1)



N = int(input())
seq = list(map(int, input().split()))
serial_sum = [0] * N
serial_sum[0] = seq[0]

for i in range(1,N):
    if seq[i] + serial_sum[i-1] > seq[i]:
        serial_sum[i] = serial_sum[i-1] + seq[i]
    else:
        serial_sum[i] = seq[i]

print(max(serial_sum)) 
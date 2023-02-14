import sys
T = int(sys.stdin.readline())
for _ in range (T):
    num, S = sys.stdin.readline().split()
    num = int(num)
    for i in S:
        sys.stdout.write(i * num)
    sys.stdout.write("\n")
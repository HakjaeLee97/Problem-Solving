N = int(input())
for i in range(1,N+1):
    for k in range(i+1, N+1):
        print(" ", end = "")
    for j in range(1,i+1):
        print("*", end = "")
    print()
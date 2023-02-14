import sys

N = 1000000
prime = [True]*(N)
prime[0] = False
prime[1] = False

for i in range(2,1001):
    if prime[i]:
        for j in range(i*2,N,i):
            prime[j] = False

tcase = -1
while True:
    tcase = int(sys.stdin.readline())
    if tcase == 0:
        break
    a ,b = 3, tcase - 3
    while a <=b:
        if prime[a] and  prime[b]:
            sys.stdout.write(f"{tcase} = {a} + {b}\n")
            break
        else:
            a +=2
            b -=2
    if a > b:
        print("Goldbach's conjecture is wrong.")
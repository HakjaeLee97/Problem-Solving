n= int(input())
amount = []
for _ in range(n):
    amount.append(int(input()))

max_drink = amount[:]

if n == 1:
    print(amount[0])

else:
    max_drink[1] += max_drink[0] 

    for i in range(2,n):
        if i == 2:

            tmp1 = max_drink[i-2] + amount[i] #이번걸 마시고 직전걸 안마심
            tmp2 = amount[i-1] + amount[i] #이번거,직전거 마시고 2번째 전걸 안마심
            tmp3 = max_drink[i-1]#이번에 안마심
            max_drink[i] = max(tmp1,tmp2,tmp3) 
        else:
            tmp1 = max_drink[i-2] + amount[i] 
            tmp2 = amount[i-1] + amount[i] + max_drink[i-3] #i -3  존재
            tmp3 = max_drink[i-1]
            max_drink[i] = max(tmp1,tmp2,tmp3)             

    print(max_drink[n-1])

N = int(input())
times = list(map(int,input().split()))
YFee = 0
MFee = 0
for time in times:
    YFee += time // 30 * 10 + 10
    MFee += time // 60 * 15 + 15
if YFee > MFee:
    print("M", end = ' ')
    print(MFee)
elif YFee == MFee:
    print("Y M", end = ' ')
    print(MFee)
else:
    print("Y", end= ' ')
    print(YFee)
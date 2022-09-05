N = int(input())
for i in range(1,N+1):
	for j in range(N-i):
		print(" ",end='')
	for k in range(i*2-1):
		print("*",end='')
#	for l in range(N-i):
#		print(" ",end='')
	print("")
"""2004 조합 0의 개수
nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
"""

# nC m = n! / ((n-m)!m!)

def insu(num,div):
	res = 0
	dividor = div
	while (num >= dividor):
		res += int(num/dividor)
		dividor *= div
	return res

if __name__ == "__main__":
	n,m = map(int,(input().split()))
	result5 = 0
	div = 5
	result5 += insu(n,div)
	result5 -= insu(m,div)
	result5 -= insu(n-m,div)
	result2 = 0
	div = 2
	result2 += insu(n,div)
	result2 -= insu(m,div)
	result2 -= insu(n-m,div)
	print(min(result5,result2))
			

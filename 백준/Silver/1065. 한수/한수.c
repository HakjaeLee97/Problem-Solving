#include <stdio.h>

int isHansu(int num)
{
	int d,d_new,tmp; //공차 d,새 공차 d_new, 자리별 차이 비교용 임시 변수 tmp
	tmp = num%10; // 1의자리로 초기화
	num = num /10;
	d = num%10 -tmp; // 첫 번째 공차 계산

	while (num!=0)
	{
		d_new = num%10 - tmp;
		tmp = num%10;
		num = num/10;
		
		if (d_new != d)
		{
			return 0;
		}
	}
	return 1;
}

int CountHansu(int N)
{
	int count = 0;
	for (int i=1; i<N+1; i++)
	{
		if (isHansu(i))
			count++;
	}
	return count;
}


int main(void)
{
	int N;
	scanf("%d",&N);
	printf("%d",CountHansu(N));

}
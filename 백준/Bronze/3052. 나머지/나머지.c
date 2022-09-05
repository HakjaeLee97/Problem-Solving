#include <stdio.h>
 
int main(void)
{
	int dividend,sum=0;
	int remainder[42];
	for (int i=0; i<42; i++)
		remainder[i]=0; //초기화
	for (int i=0; i<10; i++)
	{
		scanf("%d\n",&dividend);
		remainder[dividend % 42] = 1; 
	}
	
	for (int i=0; i<42; i++)
	{
		if(remainder[i] == 1)
			sum++;
	}
	printf("%d",sum);
	return 0;
}

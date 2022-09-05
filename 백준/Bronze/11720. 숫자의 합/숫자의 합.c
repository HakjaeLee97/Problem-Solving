#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int N,index=0;
	int num = 0;
	int sum = 0;
	scanf("%d\n",&N);
	
	char numbers[N+1];
	scanf("%s", numbers);
	while( numbers[index]!= '\0')
	{
		num = numbers[index]-48;
		sum += num;
		index++;
	}
	printf("%d",sum);
	return 0;

}
#include <stdio.h>
 
int main(void)
{
	int a,b,c;
	int frequency[] = {0,0,0,0,0,0,0,0,0,0};
	scanf("%d\n%d\n%d",&a,&b,&c);
	int mul = a*b*c;
//	printf("%d",mul);
	while(mul!=0)
	{
		frequency[mul%10]++;
		mul = mul / 10;
	}
	for(int i=0; i<10;i++)
		printf("%d\n",frequency[i]);
	return 0;
}
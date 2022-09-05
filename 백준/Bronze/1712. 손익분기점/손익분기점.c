#include <stdio.h>
 
int main(void) {
	int A,B,C;
	scanf("%d %d %d", &A,&B,&C);
	double ans;
	if (C<=B)
	{
		printf("%d",-1);
	}
	else
	{
		ans = floor (A/(C-B)) +1 ;
		printf("%.0f",ans);
	}
	return 0;
}
#include <stdio.h>

int main(void) {
	int T,a,b;
	scanf("%d\n",&T);
	for (int i=1;i<T+1;i++)
	{
		scanf("%d %d",&a,&b);
		printf("Case #%d: %d\n",i, a+b);
	}
	return 0;
}

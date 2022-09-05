#include <stdio.h>

int main(void) {
	int N,x,tmp;
	scanf("%d %d\n", &N,&x);
	for (int i=0; i<N; i++)
	{
		scanf("%d ", &tmp);
		if (tmp<x)
			printf("%d ",tmp);
	}
	return 0;
}
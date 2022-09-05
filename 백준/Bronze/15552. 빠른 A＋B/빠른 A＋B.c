#include <stdio.h>

int main(void) {
	int T,a,b;
	scanf("%d\n",&T);
	for (T;T>0;T--)
	{
		scanf("%d %d\n", &a, &b);
		printf("%d\n", a+b);
	}
	return 0;
}

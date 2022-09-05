#include <stdio.h>

int main(void) {
	int a,b,c;
	scanf("%d %d %d", &a,&b,&c);
	if ((a>=b && b>c) || (c>b && b>=a)) printf("%d",b);
	if ((a>c && c>=b) || (b>=c && c>a)) printf("%d",c);
	if ((b>a && a>=c) || (c>=a && a>b) || (a ==b && b == c)) printf("%d",a);
	
	return 0;
}
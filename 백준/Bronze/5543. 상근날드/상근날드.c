#include <stdio.h>

int main(void) {
	int burger_min = 2000,drink_min=2000,tmp;
	for (int i=0; i<3; i++)
	{
		scanf("%d\n",&tmp);
		if (tmp<burger_min)
			burger_min = tmp;
	}
	for(int j=0; j<2; j++)
	{
		scanf("%d\n",&tmp);
		if(tmp<drink_min)
			drink_min = tmp;
	}
	printf("%d",burger_min + drink_min -50);
	return 0;
}


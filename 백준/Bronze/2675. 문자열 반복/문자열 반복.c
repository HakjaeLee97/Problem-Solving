#include <stdio.h>

int main(void)
{
	int T,R;
	scanf("%d\n",&T);
	char txt[21];
	
	for (int i=0; i<T; i++)
	{
		scanf("%d ",&R);
		scanf("%s",txt);
		int index = 0;
		while(txt[index] != '\0')
		{
			for (int j=0; j<R; j++)
				printf("%c",txt[index]);
			index++;
		}
		printf("%c",'\n');
	}
	return 0;
}
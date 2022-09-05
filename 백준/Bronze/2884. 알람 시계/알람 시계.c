#include <stdio.h>

int main(void)
{
    int hour,min;
    scanf ("%d %d", &hour, &min); // 시간 입력값 저장
    if (min >= 45)
    	printf("%d %d", hour,min-45);
    else if (min <45 && hour >= 1)
    	printf("%d %d", hour-1, min+15);
	else
		printf("%d %d", hour+23, min+15);
	return 0;
}
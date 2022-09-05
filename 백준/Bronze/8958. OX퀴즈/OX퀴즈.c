#include <stdio.h>

int main(void) {
	
	int N;//테스트 케이스의 개수
	scanf("%d\n", &N); //첫째줄 N 입력
	
	int scores[N]; // 점수 배열
	for (int i=0; i<N; i++)
		scores[i] = 0; // 점수 배열 초기화
		

	char string[81]; //정오답 문자열
	
// 첫째줄만 예시로 구현
	for (int i=0; i<N; i++)
	{
		scanf("%s\n",string);
		int length;
		length = strlen(string);
		int streak=0; //연속된 정답의 개수
		for (int j=0; j<length; j++)
		{
			if (string[j]=='O')
			{
				streak++;
				scores[i] = scores[i] + streak;
			}
			else
				streak = 0;
		}
		printf("%d\n",scores[i]);
	}

	return 0;
}

#include <stdio.h>

int main(void) {
	char string[1000001];
	scanf("%s",string); // 단어 입력받기

	
	int frequency[26];
	for (int i=0; i<26; i++)
		frequency[i] = 0; // 알파벳 빈도함수
	
	
	int index=0; // 반복문용 변수
	int alphabet_index = 0;

	
	while(string[index]!='\0')
	{
		if (string[index]<'a') // 대문자인 경우
			alphabet_index = string[index]-'A';

		else // 소문자인 경우
			alphabet_index = string[index]-'a';
			
		frequency[alphabet_index]++;
		index++;
	}

	int max = 0, isDuplicate =-1, max_index = 0;	

	for (int i=0; i<26; i++)
	{
		if (frequency[i] > max)
		{
			max = frequency[i];
			max_index = i;
		}
	}
	for (int i = 0; i<26; i++)
	{
		if (frequency[i] == max)
			isDuplicate++;
	}
	
	if (isDuplicate)
		printf("%c",'?');
	else
		printf("%c",max_index+'A');
		
	return 0;
}

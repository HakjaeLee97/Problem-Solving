#include <stdio.h>
#include <math.h>

   /* 거리가 1인 범위 : 1~1
   거리가 2인 범위 : 2 ~ 7
   거리가 3인 범위 : 8 ~ 19
   거리가 4인 범위 : 20 ~ 37..

   계차 : 6, 12 , 18,  .. 6n

   각 범위의 끝값은 계차가 등차수열을 이루는 수열이다.

   계차의 합 sum(b(n)) : 3 * n*(n+1)

   원 수열의 일반항 a(n) : a(1) + sum(b(n-1))
    = 1 + 3 * n*(n-1)

    a(n) > N이 되는 최초의 n을 찾으면 된다.
    3n^2-3n-1  > N

    n에 sqrt(N) /sqrt(3)을 대입할 경우 반드시 N보다 작다. 그후로 n을 1씩 증가시키며 N보다 커지는 시점을 찾는다.  */

int honeycomb_range(int num)
{
	if (num == 0) // N = 1일때의 예외처리
	{
		return 0;
	}
   else
   {
   	return 1 + 3 * (num-1) * num;
	}
} // 범위의 끝값을 구하는 함수


int main(void) {

   int input_num;
   scanf("%d", &input_num); // 입력값 N을 input_num에 저장

   int check_num = sqrt(input_num)/3;

   while ( honeycomb_range(check_num) < input_num )
   {
		check_num++;
   }

   printf("%d", check_num);

   return 0;
}

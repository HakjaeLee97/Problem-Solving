# Problem-Solving
백준 온라인 저지(https://www.acmicpc.net/) 및 SWEA(https://swexpertacademy.com/) 에 수록된 문제를 푸는 repository입니다.


비트 연산을 이용한 빠른 입력 받기


	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

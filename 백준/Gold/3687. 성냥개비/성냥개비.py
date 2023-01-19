import sys

need = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
#0,1,2,3,4,5,6,7,8,9를 만들기 위해 필요한 성냥의 개수

# 성냥개비로 만들 수 있는 가장 작은 수 dp

T = int(sys.stdin.readline())


def init_dp():
  dp = [0] * (101)
  dp[0] = 0
  dp[1] = 0
  dp[2] = 1
  dp[3] = 7
  dp[4] = 4
  dp[5] = 2
  dp[6] = 6
  dp[7] = 8
  dp[8] = 10
  dp[9] = 18
  dp[10] = 22
  dp[11] = 20
  dp[12] = 28
  dp[13] = 68
  dp[14] = 88
  for i in range(15, 101):
    tmp = insertnum(dp[i-2] , 1)
    tmp = min(tmp,insertnum( dp[i-3] , 7))
    tmp = min(tmp, insertnum(dp[i-4], 4))
    tmp = min(tmp, insertnum(dp[i-5], 2))
    tmp = min(tmp, insertnum(dp[i-6], 0))
    tmp = min(tmp, insertnum(dp[i-7], 8 ))
    dp[i] = tmp
  return dp

def insertnum(num1,num2):
  #num1에서 num2를 최대한 작은 숫자로 꽂아넣는 함수
  num1str = []
  flag = False #num2를 끼워넣었는지 체크하는 플래그
  
  for i in  range(len(str(num1))):
    if(int(str(num1)[i]) >  num2):
      if(num2 == 0 and i == 0):
        pass #맨앞자리가 0이 될 수는 없다
      elif flag == False:
        num1str.append(num2)
        flag = True
    num1str.append(int(str(num1)[i]))
  if flag == False:
    #제일 뒷자리에 끼워넣는다
    num1str.append(num2)
  # print(num1str)
  result = 0
  for i in range(len(num1str)):
    result *= 10
    result += int(num1str[i])
    
  return result

def solve(match, dp):
  # 가장 작은 수 출력
  print(dp[match], end = " ")

  # 가장 큰 수 출력
  # 전략 : 자리수를 최대한 늘리기
  # 111111 or 71111
  if (match % 2 == 0):
    print('1' * (match // 2))
  else:
    print('7' + '1' * (match // 2 - 1))


dp = init_dp()  #dp 초기화
for _ in range(T):
  match = int(sys.stdin.readline())
  solve(match, dp)

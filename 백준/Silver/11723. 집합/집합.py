import sys

M = int(sys.stdin.readline())

s = set()

for _ in range(M):
  query = sys.stdin.readline().split()
  word = query[0]
  if(len(query)>1):
    num = int(query[1])
  if query[0] == "add":
    s.add(num)
  elif query[0] == "remove":
    s.discard(num)
  elif query[0] == "check":
    if num in s:
      print(1)
    else:
      print(0)
  elif query[0] == "toggle":
    if num in s:
      s.remove(num)
    else:
      s.add(num)
  elif query[0] == "all":
    s = set(range(1,21))
  else:
    s = set()
  
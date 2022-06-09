"""
10866 덱

정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""

from sys import stdin

class my_deque:
    def __init__(self):
        self.deque = []
    def push_front(self,num):
        self.deque.insert(0,num)
    def push_back(self,num):
        self.deque.append(num)
    def pop_front(self):
        if len(self.deque) == 0:
            print(-1)
        else:
            print(self.deque.pop(0))
    def pop_back(self):
        if len(self.deque) == 0:
            print(-1)
        else:
            print(self.deque.pop())
    def size(self):
        print(len(self.deque))

    def empty(self):
        if len(self.deque) == 0:
            print(1)
        else:
            print(0)
    
    def front(self):
        if len(self.deque) == 0:
            print(-1)
        else:
            print(self.deque[0])

    def back(self):
        if len(self.deque) == 0:
            print(-1)
        else:
            print(self.deque[-1])
if __name__ == "__main__":
    N = int(stdin.readline())
    deque_ = my_deque()
    for _ in range(N):
        word = (stdin.readline().split())
        order = word[0]
        if order == "push_front":
            deque_.push_front(int(word[1]))
        elif order == "push_back":
            deque_.push_back(int(word[1]))
        elif order == "pop_front":
            deque_.pop_front()
        elif order == "pop_back":
            deque_.pop_back()
        elif order == "size":
            deque_.size()
        elif order == "empty":
            deque_.empty()
        elif order == "front":
            deque_.front()
        elif order == "back":
            deque_.back()
        else:
            print("order error")
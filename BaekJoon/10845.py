"""
10845 큐

정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
"""

from sys import stdin

class my_queue:
    def __init__(self):
        self.queue = []
    def push(self,num):
        self.queue.append(num)
    def pop(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            print(self.queue.pop(0))
    def size(self):
        print(len(self.queue))

    def empty(self):
        if len(self.queue) == 0:
            print(1)
        else:
            print(0)
    
    def front(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            print(self.queue[0])

    def back(self):
        if len(self.queue) == 0:
            print(-1)
        else:
            print(self.queue[-1])
if __name__ == "__main__":
    N = int(stdin.readline())
    queue_ = my_queue()
    for _ in range(N):
        word = (stdin.readline().split())
        order = word[0]
        if order == "push":
            queue_.push(int(word[1]))
        elif order == "pop":
            queue_.pop()
        elif order == "size":
            queue_.size()
        elif order == "empty":
            queue_.empty()
        elif order == "front":
            queue_.front()
        elif order == "back":
            queue_.back()
        else:
            print("order error")

"""
11004 K번째 수
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
"""

import sys
import random
random.seed(11004)


#Using Quick selection'

class Kth(object):
    def __init__(self, n_list,k):
        self.arr = n_list
        self.k = K

    def _quick_selection(self,arr,k):
        mid_num = arr[random.randint(0, len(arr) -1)]
        left,mid,right = [],[],[]

        for i in arr:
            if i < mid_num:
                left.append(i)
            elif i == mid_num:
                mid.append(i)
            else:
                right.append(i)
        
        _len = [len(left), len(left)+len(mid)]
        if k <= _len[0]:
            del arr,mid,right
            return self._quick_selection(left,k)
        elif k <= _len[1]:
            del arr,left,mid,right
            return mid_num
        else:
            del arr,left,mid
            return self._quick_selection(right,k-_len[1])

    def solve(self):
        ans = self._quick_selection(self.arr, self.k)
        print(ans)

if __name__ == "__main__":
    N, K = map(int,sys.stdin.readline().split())
    An = list(map(int,sys.stdin.readline().split()))
    Kth_problem = Kth(An,K)
    Kth_problem.solve()
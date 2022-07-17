import sys
sys.stdin = open("input (1).txt" ,"r")


def get_dist(pos1,pos2):
    return(abs(pos1[0]-pos2[0]) + abs(pos1[1]-pos2[1]))

def get_result(seq,home,work,threshold):
    result = 0
    result += get_dist(home,seq[0])
    for i in range(len(seq)-1):
        result += get_dist(seq[i],seq[i+1])
    result += get_dist(seq[-1],work)
    if result > threshold:
        return 100000
    return result

def DFS(clients, start_node):
    


T = int(input())

for tc in range(1,T+1):
    N = int(input())
    poses = list(map(int,(input().split())))
    pos_home = poses[0:2]
    pos_work = poses[2:4]
    pos_clients = []
    for i in range(4,2*N+4,2):
        pos_clients.append(poses[i:i+2])
    min = 100000
 

    print("#%d"%tc,min)
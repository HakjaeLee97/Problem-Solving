import sys

def preorder(tree,now):
    sys.stdout.write(now)
    next = tree[ord(now)-ord('A')]
    if next[0] != ".":
        preorder(tree,next[0])
    if next[1] != ".":
        preorder(tree, next[1])

def inorder(tree,now):
    next = tree[ord(now)-ord('A')]
    if next[0] != ".":
        inorder(tree,next[0])
    sys.stdout.write(now)
    if next[1] != ".":
        inorder(tree, next[1])

def postorder(tree,now):
    next = tree[ord(now)-ord('A')]
    if next[0] != ".":
        postorder(tree,next[0])
    if next[1] != ".":
        postorder(tree, next[1])
    sys.stdout.write(now)

if __name__ == "__main__":
    
    N = int(sys.stdin.readline())
    tree = [ [] for i in range(N)]
    for i in range(N):
        tmp = sys.stdin.readline().split()
        tree[ord(tmp[0])-ord('A')] = tmp[1:]
    preorder(tree,"A")
    sys.stdout.write("\n")
    inorder(tree,"A")
    sys.stdout.write("\n")
    postorder(tree,"A")

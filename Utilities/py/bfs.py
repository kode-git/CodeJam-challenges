'''''''''''
Pseudo-code for BFS algorithm

bfs(V, E, s : Node) -> TreeNode :

    for each v in V do
        v.mark := false

    Q := new Queue()
    Q.enqueue(s)
    s.mark := true
    s.dist := 0
    s.parent := null

    while(!Q.isEmpty()) do
        v := Q.dequeue()
        for each x in v.adj  do
            if x.mark == false then
                x.mark = true
                x.parent := v
                x.dist := v.dist + 1
                Q.enqueue(x)
            endif
        endfor
    endwhile

    return s

Complexity :  O(n + m) :: |V| = n and |E| = m

'''''''''

from queue import Queue
from random import Random


class Node:
    def __init__(self):
        self.mark = False
        self.dist = 0
        self.parent = None
        self.adj = []
        self.value = 0
    
    # avoiding to defines set and get


class Graph:

    def __init__(self):
        self.nodes = []

    def setNodes(self, nodes : Node):
        self.nodes = nodes

    def getNodes(self):
        return self.nodes


def bfs(g : Graph, s : Node):
    for node in g.nodes:
        node.mark = False

    queue  = Queue()
    s.mark = True
    s.parent = 0
    s.dist = 0

    queue.put(s)
    while not queue.empty():
        v = queue.get()
        for x in v.adj:
            if x.mark == False:
                x.mark = True
                x.parent = v
                x.dist = v.dist + 1
                queue.put(x)
            # endif
        # endfor
    # endwhile
    return s



if __name__ == '__main__':
    g = Graph()

    # construct
    for i in range(10):
        n = Node()
        g.nodes.append(n)
    
    # link
    for i in range(10):
        n = Random().randint(0, 9)
        for j in range(n):
            x = Random().randint(0,9)
            if x not in set(g.nodes[i].adj):
                g.nodes[i].adj.append(g.nodes[x])
    
    # bfs
    tree = bfs(g, g.nodes[0])




# Nodes with adj list implementation
class Node:
    def __init__(self):
        self.value = 0
        self.adj = []
    
    def addAdj(self, node):
        if self.adj.index(node) is None:
            self.adj.append(node)
    
    def get_value(self):
        return self.value
    
    def get_edges(self):
        return self.adj
    
    def set_value(self, value):
        self.value = value
    
    def set_edges(self, edges):
        self.edges = edges




from src.tree_node import Node

class  NodeTest():

    def __init__(self):
        self.node = Node()

    def get_value(self):
        assert self.node.value == self.get_value(), "Failed get_value() invocation"
    
    def set_value(self, value):
        self.node.set_value(value)
        assert self.get_value() == value, "Failed set_value() invocation"

    def get_right(self):
        assert self.node.right == self.node.get_right(), "Failed getting the right Node"
    
    def get_left(self):
        assert self.node.left == self.node.get_left(), "Failed getting the left Node"

    def set_right(self, node):
        if type(node) == type(Node()):
            self.node.set_right(node)
            assert self.node.right == node, "Failed setting right node"

    def set_left(self, node):
        if type(node) == type(Node()):
            self.node.set_left(node)
            assert self.node.left == node, "Failed setting left node"
    

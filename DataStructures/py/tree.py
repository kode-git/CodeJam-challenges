
from node import Node

class Tree():

    def __init__(self):
        self.root = Node()
        self.current = self.root
    
    def visitLeft(self):
        self.current = self.current.get_left()
    
    def visitRight(self):
        self.current = self.current.get_right()

    def getValue(self):
        return self.current.value

    def set_value(self, value):
        self.current.set_value(value)

    def in_order(self, current):
        if current is not None:
            self.in_order(self.get_left())
            print(current.get_value())
            self.in_order(self.get_right())

    def pre_order(self, current):
        if current is not None:
            print(current.get_value())
            self.pre_order(self.get_left())
            self.pre_order(self.get_right())
    
    def post_order(self, current):
        if current is not None:
            self.post_order(self.get_left())
            self.post_order(self.get_right())
            print(current.get_value())
# testing based on the node 
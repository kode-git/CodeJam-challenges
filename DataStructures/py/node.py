

class  Node():

    def __init__(self):
        self.value = 0
        self.right = None
        self.left = None

    def get_value(self):
        return self.value
    
    def set_value(self, value):
        self.value = value

    def get_right(self):
        return self.right
    
    def get_left(self):
        return self.left

    def set_right(self, node):
        if type(node) == type(Node()):
            self.right = node
    
    def set_left(self, node):
        if type(node) == type(Node()):
            self.left = node
    

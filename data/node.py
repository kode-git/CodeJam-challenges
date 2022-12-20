class Node():
    def __init__(self, node):
        self.value = 0
        self.next_node = node

    def set_next_node(self, node):
        self.next_node = node
    
    def get_next_node(self):
        return self.next_node

    def set_value(self, value):
        self.value = value
    
    def get_value(self):
        return self.value




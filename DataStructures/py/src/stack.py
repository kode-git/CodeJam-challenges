

class Stack():

    def __init__(self):
        self.data = list()

    def push(self, item):
        self.data = self.data + [item]
    
    def peek(self):
        if self._isEmpty():
            return None
        return self.data[-1]
    
    def pop(self):
        if self._isEmpty():
            return None
        value = self.data[-1]
        self.data = self.data[:-1]
        return value

    def _isEmpty(self):
        return len(self.data) == 0
        

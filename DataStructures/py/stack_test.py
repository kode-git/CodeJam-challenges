from src.stack import Stack

class StackTest():

    def __init__(self):
        self.stack = Stack()
    
    def push(self, item):
        n = len(self.stack.data)
        self.stack.push(item)
        assert len(self.stack.data) > n, f'Failed pushing {item}. Current size: {len(self.stack.data)}'
    

    def pop(self):
        if not self.stack._isEmpty():
            value = self.stack.pop()
            assert value is not None, f'Failed pop the peek item. Current size : {len(self.stack.data)}'
            return value
    
    def peek(self):
        if not self.stack._isEmpty():
            assert self.stack.peek() is not None, f'Failed check the peek. Results is None'
            return self.stack.peek()
        assert self.stack.peek() is None, f'Failed check the peek. Stack is empty and peek is not None'
        return None
    
    def _isEmpty(self):
        if len(self.stack.data):
            assert not self.stack._isEmpty(), f'Stack empty method and size didn\'t match'
        else:
            assert self.stack._isEmpty(), f'Stack empty method and size didn\'t match'
        return self.stack._isEmpty()
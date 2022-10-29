

class Stack():

    def __init__(self):
        self.data = list()

    def push(self, item):
        self.data = self.data + [item]
    
    def head(self):
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
            assert value is not None, f'Failed pop the head item. Current size : {len(self.stack.data)}'
            return value
    
    def head(self):
        if not self.stack._isEmpty():
            assert self.stack.head() is not None, f'Failed check the head. Results is None'
            return self.stack.head()
        assert self.stack.head() is None, f'Failed check the head. Stack is empty and head is not None'
        return None
    
    def _isEmpty(self):
        if len(self.stack.data):
            assert not self.stack._isEmpty(), f'Stack empty method and size didn\'t match'
        else:
            assert self.stack._isEmpty(), f'Stack empty method and size didn\'t match'
        return self.stack._isEmpty()

    

if __name__ == '__main__':
    test = StackTest()
    print(f'Stack empty: {test._isEmpty()}')
    test.push(10)
    print(f'Pushed: {test.head()}')
    print(f'Stack empty: {test._isEmpty()}')
    print(f'Pop: {test.pop()}')
    print(f'Stack empty: {test._isEmpty()}')

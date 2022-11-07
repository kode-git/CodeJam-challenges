from src.queue import Queue


class QueueTest():

    def __init__(self):
        self.queue = Queue()
    
    def push(self, item):
        n = len(self.queue.data)
        self.queue.push(item)
        assert len(self.queue.data) > n, f'Failed pushing {item}. Current size: {len(self.queue.data)}'
    

    def pop(self):
        if not self.queue._isEmpty():
            value = self.queue.pop()
            assert value is not None, f'Failed pop the peek item. Current size : {len(self.queue.data)}'
            return value
    
    def peek(self):
        if not self.queue._isEmpty():
            assert self.queue.peek() is not None, f'Failed check the peek. Results is None'
            return self.queue.peek()
        assert self.queue.peek() is None, f'Failed check the peek. queue is empty and peek is not None'
        return None
    
    def _isEmpty(self):
        if len(self.queue.data):
            assert not self.queue._isEmpty(), f'queue empty method and size didn\'t match'
        else:
            assert self.queue._isEmpty(), f'queue empty method and size didn\'t match'
        return self.queue._isEmpty()
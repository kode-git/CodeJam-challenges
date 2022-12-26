'''''
A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. 
The elements in a linked list are linked using pointers as shown in the below image:
'''

class LinkedNode():

    def __init__(self):
        self.value = None
        self.next = None

    def get_value(self):
        return self.value

    def set_value(self, value):
        self.value = value

    def get_next(self):
        return self.next

    def set_next(self, next):
        self.next = next


class LinkedList():

    def __init__(self):
        self.head = None
    
    def get_head(self):
        return self.head

    def set_head(self, head):
        self.head = head
    

    def add(self, element):
        el = LinkedNode()
        el.set_value(element)
        el.set_next(None)
        current = self.head
        if current == None:
            self.head = el
        else:
            while current.next != None:
                current = current.next
            current.next = el


    def add_on_index(self, index : int, element):
        i = 0
        current = self.head
        previous = self.head
        if current == None and index > 0:
            raise IndexError('Adding element in an index greater than the dimension of the linked list')
        else:
            while current != None:
                if i == index:
                    node = LinkedNode() 
                    node.set_value(element) 
                    previous.next = node
                    node.next = current
                    return
                if current != self.head:
                    previous = previous.next
                current = current.next
                i+= 1
            raise IndexError('Add operation: Index out of bound')
        

    def addAll(self, elements : list):
        for el in elements:
            self.add(el)
    
    def clear(self):
        self.head = None

    def addAll(self, index: int, elements : list):
        current = self.head
        if current == None and index == 0:
            for el in elements:
                self.add(el)
            return
        if current == None and index > 0:
            raise IndexError('Adding element in an out of bound index, the current list is void')
        else:
            i = 0
            inserted = False
            while current != None:
                if index == i:
                    inserted = True
                    last = current.next
                    current_inner = current
                    for el in elements:
                        node = LinkedNode()
                        node.set_value(el)
                        current_inner.next = node
                        current_inner = node
                    current_inner.next = last
                current = current.next
                i += 1
            if inserted == False:
                raise IndexError('Index out of bound')


    def get(self, index: int):
        if (self.head == None and index > 0) or index < 0:
            return None
        current = self.head
        i = 0
        while current != None:
            if i == index:
                return current
            current = current.next
            i = i + 1
        return None

    def getFirst(self):
        return self.get(0)

    def getLast(self):
        if self.head == None:
            return None
        current = self.head
        while current.next != None:
            current = current.next
        return current

    def pool(self):
        if self.head == None:
            return None
        current = self.head
        self.head = current.next
        return current.value

    def set(self, index: int, value):
        if self.head == None and index > 0:
            return False
        else:
            current = self.head
            i = 0
            while current != None:
                if i == index:
                    current.set_value(value)
                    return True
                current = current.next
                i = i + 1
        return False


    def contains(self, element):
        current = self.head
        while current != None:
            if current.value == element:
                return True
            current = current.next
        return False


    def remove(self, index):
        if self.size() == 1: 
            self.head = None
            return
        if self.head == None and index > 0:
            return
        current = self.head
        i = 0
        while current != None:
            if i == index:
                if current.next != None:
                    current.next = current.next.next
            i += 1
            current = current.next


    def size(self):
        if self.head == None:
            return 0
        current = self.head
        counter = 0
        while current != None:
            counter += 1
            current = current.next   
        return counter        





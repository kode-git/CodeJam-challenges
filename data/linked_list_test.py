
from unittest import TestCase
from linked_list import LinkedList, LinkedNode

list = LinkedList()
node = LinkedNode()


class LinkedNodeTest(TestCase):

    def test_get_set_value(self):
        node = LinkedNode()
        node.set_value(10)
        self.assertTrue(node.get_value() == 10)

    def test_get_set_next(self):
        node = LinkedNode()
        node.set_value(10)
        node2 = LinkedNode()
        node2.set_value(20)
        node.set_next(node2)
        self.assertTrue(node.get_next() == node2)


class LinkedListTest(TestCase):

    def test_size(self):
        list.clear()
        node = LinkedNode()
        node.value = 1
        node.next = None
        node2 = LinkedNode()
        node2.value = 2
        node2.next = None
        node.next = node2
        list.head = node
        self.assertEqual(list.size(), 2)

    def test_add(self):
        list.clear()
        self.assertEqual(list.size(), 0)
        list.add(5)
        self.assertEqual(list.size(), 1)
        list.add(6)
        self.assertEqual(list.size(), 2)
        list.clear()

    def test_add_on_index(self):
        list.clear()
        try:
            list.add_on_index(4, 10)
        except IndexError:
            self.assertLogs('Correct catching exception', level='INFO')
        list.clear()
        list.add(10)
        list.add(20)
        self.assertEqual(list.size(), 2)
        list.add_on_index(1, 100)
        self.assertEqual(list.size(), 3)
        self.assertEqual(list.get(1).value, 100)
        list.clear()

    def test_addAll(self):
        list.clear()
        list.addAll(0, [1, 2, 3, 4, 5])
        self.assertEqual(list.size(), 5)
        self.assertEqual(list.get(1).value, 2)
        list.clear()

    def test_get(self):
        list.clear()
        list.add(10)
        self.assertEqual(list.get(0).value, 10)
        self.assertEqual(list.get(1000), None)
        list.clear()

    def test_getFirstLast(self):
        list.clear()
        self.assertEqual(list.size(), 0)
        list.add(10)
        list.add(20)
        list.add(30)
        self.assertEqual(list.getFirst().value, 10)
        self.assertEqual(list.getLast().value, 30)
        list.clear()

    def test_pool(self):
        list.clear()
        list.add(10)
        self.assertEqual(list.pool(), 10)
        self.assertEqual(list.size(), 0)
        list.clear()

    def test_set(self):
        list.clear()
        list.add(10)
        list.add(20)
        list.add(30)
        self.assertEqual(list.get(1).value, 20)
        list.set(1, 1000)
        self.assertEqual(list.get(1).value, 1000)
        list.clear()

    def test_contains(self):
        list.clear()
        list.add(20)
        self.assertTrue(list.contains(20), 'Error - 20 is included')
        self.assertFalse(list.contains(40), 'Error - 40 is not in the list')
        list.clear()

    def test_remove(self):
        list.clear()
        list.add(10)
        list.add(12)
        self.assertEqual(list.size(), 2)
        list.remove(0)
        self.assertEqual(list.size(), 1)
        list.remove(0)
        self.assertEqual(list.size(), 0)
        list.clear()

    def test_get_set_head(self):
        list.clear()
        node = LinkedList()
        node.value = 10
        node.next = None
        list.set_head(node)
        self.assertEqual(list.get_head().value, 10)
        node2 = LinkedList()
        node2.value = 20
        node2.next = node
        list.set_head(node2)
        self.assertEqual(list.get_head().value, 20)
        list.clear()

    def test_clean(self):
        list.clear()
        list.add(30)
        self.assertTrue(list.size() != 0)
        list.clear()
        self.assertTrue(list.size() == 0)
        list.clear()

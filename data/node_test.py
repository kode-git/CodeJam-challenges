from unittest import TestCase
from node import Node

node = Node(None)

class NodeTest(TestCase):

    def test_set_value(self):
        node.set_value(6)
        self.assertEqual(node.value, 6)
    
    def test_get_value(self):
        self.assertEqual(node.value, node.get_value())
    
    def test_set_node(self):
        n = Node(None)
        n.set_value(5)
        node.set_value(6)
        node.set_next_node(n)
        self.assertEqual(node.next_node, n)
    
    def test_get_node(self):
        self.assertEqual(node.get_next_node(), node.next_node)
    


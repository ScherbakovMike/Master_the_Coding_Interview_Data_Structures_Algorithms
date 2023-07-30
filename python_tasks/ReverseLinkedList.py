class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def add(self, value):
        cur_node = self.head
        while cur_node.next:
            cur_node = cur_node.next
        cur_node.next = Node(value)

    def reverse(self):
        cur_node = self.head
        next_node = cur_node.next
        while next_node:
            buf = next_node.next
            next_node.next = cur_node
            cur_node = next_node
            next_node = buf
        self.head.next = None
        self.head = cur_node

    def print(self):
        cur_node = self.head
        while cur_node:
            print(cur_node.value, " ")
            cur_node = cur_node.next


class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next


list = LinkedList(10)
list.add(20)
list.add(30)

list.print()
list.reverse()
list.print()

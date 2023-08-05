import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinarySearchTree {
    static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.format("value = %d%nleft = %s%nright = %s%n", value,
                    left == null ? "" : left.toString(),
                    right == null ? "" : right.toString());
        }

        public String toString(int tabs) {
            return String.format("value = %d%n%sleft = %s%n%sright = %s%n",
                    value,
                    "\t".repeat(tabs), left == null ? "" : left.toString(tabs + 1),
                    "\t".repeat(tabs), right == null ? "" : right.toString(tabs + 1));
        }

        public void insert(int value) {
            if (value < this.getValue()) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }

        public void delete(int value) {
            var deletedNodeAddress = findNode(value, this);
            if (deletedNodeAddress == null) {
                return;
            }
            var deletedNode = deletedNodeAddress.getKey();
            var deletedNodeParent = deletedNodeAddress.getValue();
            if (deletedNode.left == null && deletedNode.right == null) {
                deleteNodeWithSingleChild(deletedNode, deletedNodeParent, null);
            }
            if (deletedNode.left != null && deletedNode.right == null) {
                deleteNodeWithSingleChild(deletedNode, deletedNodeParent, deletedNode.left);
            }
            if (deletedNode.right != null && deletedNode.left == null) {
                deleteNodeWithSingleChild(deletedNode, deletedNodeParent, deletedNode.right);
            }
            if (deletedNode.left != null && deletedNode.right != null) {
                var minNodeAddressInRight = deletedNode.findMinNodeInRightNode();
                var minNode = minNodeAddressInRight.getKey();
                var minNodeParent = minNodeAddressInRight.getValue();
                minNodeParent.delete(minNode.value);
                deletedNode.value = minNode.value;
            }
        }

        private static void deleteNodeWithSingleChild(Node deletedNode, Node deletedNodeParent, Node replacement) {
            if (deletedNode.value < deletedNodeParent.value) {
                deletedNodeParent.left = replacement;
            } else {
                deletedNodeParent.right = replacement;
            }
        }

        private Map.Entry<Node, Node> findNode(int value, Node parent) {
            if (this.value == value) {
                return Map.entry(this, parent);
            }
            if (value < this.value) {
                if (this.left != null) {
                    return this.left.findNode(value, this);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.findNode(value, this);
                } else {
                    return null;
                }
            }
        }

        private Map.Entry<Node, Node> findMinNodeInRightNode() {
            var minValue = this.right.value;
            var curNode = this.right;
            var curParent = this;
            while (true) {
                if (curNode.value < minValue) {
                    minValue = curNode.value;
                }
                if (curNode.left == null) {
                    break;
                } else {
                    curParent = curNode;
                    curNode = curNode.left;
                }
            }
            return Map.entry(curNode, curParent);
        }

    }

    public static void main(String[] args) {
        //var tree = initTree();
        //printTree(tree);

        var smallTree = new Node(50);
        smallTree.insert(30);
        smallTree.insert(70);
        smallTree.insert(10);
        printTree(smallTree);
//        smallTree.insert(40);
//        smallTree.insert(50);
//        smallTree.insert(80);
        //bfsIterative(smallTree);

        //bfsRecursive(new LinkedList<>(List.of(smallTree)));

        dfsPostOrder(smallTree);
    }

    private static Node initTree() {
        var tree = new Node(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(10);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(5);
        tree.insert(20);
        tree.insert(25);
        tree.insert(75);
        tree.insert(35);
        tree.insert(45);
        return tree;
    }

    private static void printTree(Node node) {
        System.out.println(node.toString(1));
    }

    private static void bfsIterative(Node node) {
        var queue = new LinkedList<Node>();
        queue.push(node);
        while (!queue.isEmpty()) {
            var curNode = queue.poll();
            System.out.println(curNode.value);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    private static void bfsRecursive(LinkedList<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        var curNode = queue.poll();
        System.out.println(curNode.value);
        if (curNode.left != null) {
            queue.add(curNode.left);
        }
        if (curNode.right != null) {
            queue.add(curNode.right);
        }
        bfsRecursive(queue);
    }

    private static void dfsPreOrder(Node node) {
        System.out.println(node.value);
        if(node.left!=null) {
            dfsPreOrder(node.left);
        }
        if(node.right!=null) {
            dfsPreOrder(node.right);
        }
    }

    private static void dfsInOrder(Node node) {
        if(node.left!=null) {
            dfsInOrder(node.left);
        }
        System.out.println(node.value);
        if(node.right!=null) {
            dfsInOrder(node.right);
        }
    }

    private static void dfsPostOrder(Node node) {
        if(node.left!=null) {
            dfsPostOrder(node.left);
        }
        if(node.right!=null) {
            dfsPostOrder(node.right);
        }
        System.out.println(node.value);
    }
}

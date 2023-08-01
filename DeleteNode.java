import java.util.Map;

public class DeleteNode {
    public static void main(String[] args) {
        var tree = initTree();
        printTree(tree);

        tree.delete(70);
        printTree(tree);
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
}

class Node {
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
            if (deletedNode.value < deletedNodeParent.value) {
                deletedNodeParent.left = null;
            } else {
                deletedNodeParent.right = null;
            }
        }
        if (deletedNode.left != null && deletedNode.right == null) {
            if (deletedNode.value < deletedNodeParent.value) {
                deletedNodeParent.left = deletedNode.left;
            } else {
                deletedNodeParent.right = deletedNode.left;
            }
        }
        if (deletedNode.right != null && deletedNode.left == null) {
            if (deletedNode.value < deletedNodeParent.value) {
                deletedNodeParent.left = deletedNode.right;
            } else {
                deletedNodeParent.right = deletedNode.right;
            }
        }
        if (deletedNode.left != null && deletedNode.right != null) {
            var minNodeAddressInRight = deletedNode.findMinNodeInRightNode();
            var minNode = minNodeAddressInRight.getKey();
            var minNodeParent = minNodeAddressInRight.getValue();
            minNodeParent.delete(minNode.value);
            deletedNode.value = minNode.value;
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
            if(curNode.left==null) {
                break;
            } else {
                curParent = curNode;
                curNode = curNode.left;
            }
        }
        return Map.entry(curNode, curParent);
    }

}

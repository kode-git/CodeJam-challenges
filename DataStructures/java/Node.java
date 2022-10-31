
public class Node implements Cloneable {
    int value;
    Node left;
    Node right;

    public Node() {
        // void constructor
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node right, Node left) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return this.value;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (value != other.value)
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (this.left != null && this.right != null)
            return "Node[value=" + this.value + ", left=" + this.left.toString() + ", right=" + this.right.toString()
                    + "]";
        else if (this.left == null)
            return "Node[value=" + this.value + ", left=Null" + ", right=" + this.right.toString() + "]";
        else
            return "Node[value=" + this.value + ", left=" + this.left.toString() + ", right=Null]";
    }

    @Override
    public Node clone() {
        try {
            Node cloned = (Node) super.clone();
            cloned.left = this.left.clone();
            cloned.right = this.right.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
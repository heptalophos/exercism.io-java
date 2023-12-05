import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        insert(root, value);
    }

    private void insert(Node<T> node, T value) {
        if (root == null) root = Node.newNode(value);
        else if (value.compareTo(node.getData()) <= 0) {
            if (node.getLeft() == null) node.setLeft(value);
            else insert(node.getLeft(), value);
        }
        else if (value.compareTo(node.getData()) > 0) {
            if (node.getRight() == null) node.setRight(value);
            else insert(node.getRight(), value);
        }
    } 

    Node<T> getRoot() {
        return root;
    }

    List<T> getAsSortedList() {
        List<T> sorted = new ArrayList<>();
        getAsSortedList(root, sorted);
        return sorted;
    }

    private void getAsSortedList(Node<T> node, List<T> values) {
        if (node != null) {
            getAsSortedList(node.getLeft(), values);
            values.add(node.getData());
            getAsSortedList(node.getRight(), values);
        }
    }

    List<T> getAsLevelOrderList() {
        List<T> levelOrderList = new ArrayList<>();
        int depth = depth(root) + 1;
        for (int level = 1; level < depth; level++)
            getAsLevelOrderList(root, level, levelOrderList); 
        return levelOrderList;
    }

    private void getAsLevelOrderList(Node<T> node, int depth, List<T> values) {
        if (node == null) return;
        if (depth == 1) values.add(node.getData());
        if (depth > 1) {
            getAsLevelOrderList(node.getLeft(), depth - 1, values);
            getAsLevelOrderList(node.getRight(), depth - 1, values);
        }
    }

    private int depth(Node<T> node) {
        if (node == null) return 0;
        else return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    static class Node<T> {
        private T data;
        private Node<T> left = null, 
                        right = null;

        public static <T> Node<T> newNode(T data) {
            return new Node<>(data);
        }
        private Node(Node<T> left, Node<T> right, T data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        private Node(T data) {
            this(null, null, data);
        }
        public Node(T data, Node<T> left, Node<T> right) { 
            this.data = data; 
            this.left = left;
            this.right = right;
        }
        Node<T> getLeft() { return left; }
        Node<T> getRight() { return right; }
        public void setLeft(T data) { this.left = newNode(data); }
        public void setRight(T data) { this.right = newNode(data); }
        T getData() { return data; }
    }
}

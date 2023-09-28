package trees;

import java.util.ArrayList;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }

    private Node root;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else return true;
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public int height() {
        return height(root);
    }

    public int minimumValue() {
        return minimumValue(root);
    }

    public boolean equals(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public ArrayList<Integer> valueAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        valueAtDistance(root, distance, list);
        return list;
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (root.leftChild == null || root.rightChild == null) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int minimumValue(Node root) {
        if (root == null) return 0;
        if (root.leftChild == null || root.rightChild == null) return root.value;
        int left = minimumValue(root.leftChild);
        int right = minimumValue(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private int binarySearchTreeMin(Node root) {
        if (root == null) throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;

        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    private void valueAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }

        valueAtDistance(root.leftChild, distance - 1, list);
        valueAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (var value : valueAtDistance(i)) {
                System.out.println(value);
            }
        }
    }

}

package trees;

import java.util.ArrayDeque;
import java.util.Queue;

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
            return "Node: " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
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
            } else {
                return true;
            }
        }

        return false;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int binarySearchMin() {
        return binarySearchMin(root);
    }

    private int binarySearchMin(Node root) {
        if (root == null) throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.rightChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void kthNodesFromRoot(int distance) {
        kthNodesFromRoot(root, distance);
    }

    private void kthNodesFromRoot(Node root, int distance) {
        if (root == null) return;
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }

        kthNodesFromRoot(root.leftChild, distance - 1);
        kthNodesFromRoot(root.rightChild, distance - 1);
    }

    public void traverseLevelOrder() {
        traverseLevelOrder(root);
    }

    private void traverseLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.value);

            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return root.value;

        int left = max(root.leftChild);
        int right = max(root.rightChild);

        return Math.max(left, right);
    }

    public void printLeftView() {
        printLeftView(root);
    }

    private void printLeftView(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        printLeftView(root.leftChild);
    }


    public boolean childrenSumProperty() {
        return childrenSumProperty(root);
    }

    private boolean childrenSumProperty(Node root) {
        if (root == null) return true;
        if (root.leftChild == null && root.rightChild == null) return true;

        int sum = 0;
        if (root.leftChild != null) sum += root.leftChild.value;
        if (root.rightChild != null) sum += root.rightChild.value;

        return (root.value == sum && childrenSumProperty(root.leftChild) && childrenSumProperty(root.rightChild));
    }


    public int maxWidth() {
        return maxWidth(root);
    }

    private int maxWidth(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int result = 0;

        while (!queue.isEmpty()) {
            result = Math.max(result, queue.size());
            Node current = queue.remove();

            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }

        return result;
    }


}

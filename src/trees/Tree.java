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

    public int heightOfBinaryTree() {
        return heightOfBinaryTree(root);
    }

    private int heightOfBinaryTree(Node root) {
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) return 0;
        return 1 + Math.max(heightOfBinaryTree(root.leftChild), heightOfBinaryTree(root.rightChild));
    }

    public void printNodesAtKDistance(int distance) {
        printNodesAtKDistance(root, distance);
    }

    private void printNodesAtKDistance(Node root, int distance) {
        if (root == null) return;
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        printNodesAtKDistance(root.leftChild, distance - 1);
        printNodesAtKDistance(root.rightChild, distance - 1);
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
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

    public int minimumValue() {
        return minimumValue(root);
    }

    private int minimumValue(Node root) {
        if (root.leftChild == null && root.rightChild == null) return root.value;
        int left = minimumValue(root.leftChild);
        int right = minimumValue(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    public int maximumValue() {
        return maximumValue(root);
    }

    private int maximumValue(Node root) {
        if (root.leftChild == null && root.rightChild == null) return root.value;
        int left = maximumValue(root.leftChild);
        int right = maximumValue(root.rightChild);

        return Math.max(root.value, Math.max(left, right));
    }


}

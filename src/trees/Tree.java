package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    // O(n)
    private int min(Node root) {
        if (root.leftChild == null || root.rightChild == null) return root.value;
        return Math.min(Math.min(min(root.leftChild), min(root.rightChild)), root.value);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root.leftChild == null || root.rightChild == null) return root.value;
        return Math.max(Math.max(max(root.leftChild), max(root.rightChild)), root.value);
    }

    public int minBinarySearchTree() {
        return minBinarySearchTree(root);
    }

    //O(log n)
    private int minBinarySearchTree(Node root) {
        if (root == null) throw new IllegalStateException();
        Node current = root;
        Node previous = current;
        while (current != null) {
            previous = current;
            current = current.leftChild;
        }

        return previous.value;
    }

    public boolean equals(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild)
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

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            var list = getNodesAtDistance(i);

            list.forEach(System.out::println);
        }
    }

    public void traverseLevelOrderUsingQueue() {
        traverseLevelOrderUsingQueue(root);
    }

    private void traverseLevelOrderUsingQueue(Node root) {
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

    public boolean childrenSumProperty() {
        return childrenSumProperty(root);
    }

    private boolean childrenSumProperty(Node root) {
        if (root == null) return true;
        if (root.leftChild == null || root.rightChild == null) return true;

        return root.leftChild.value + root.rightChild.value == root.value
                && childrenSumProperty(root.leftChild)
                && childrenSumProperty(root.rightChild);
    }

    public boolean isHeightBalanced() {
        int result = isHeightBalanced(root);
        return result >= 0;
    }

    private int isHeightBalanced(Node root) {
        if (root == null) return 0;
        int lh = isHeightBalanced(root.leftChild);
        if (lh == -1) return -1;
        int rh = isHeightBalanced(root.rightChild);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;
        else return Math.max(lh, rh) + 1;
    }

}

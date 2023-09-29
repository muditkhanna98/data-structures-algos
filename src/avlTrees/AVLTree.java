package avlTrees;

public class AVLTree {
    private AVLNode root;

    private class AVLNode {
        private int height;
        private AVLNode left;
        private AVLNode right;
        private int value;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else root.right = insert(root.right, value);

        return root;
    }
}

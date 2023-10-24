package trees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(3);
        tree.insert(9);
        tree.insert(19);
        tree.insert(1);

        tree.traverseLevelOrderUsingQueue();
    }
}

package trees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(20);
        tree.insert(30);
        tree.insert(21);
        tree.insert(13);
        tree.insert(1);
        tree.insert(3);
        tree.insert(4);

        System.out.println(tree.maxWidth());
    }
}

package trees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(3);
        tree.insert(9);

        System.out.println(tree.childrenSumProperty());
    }
}

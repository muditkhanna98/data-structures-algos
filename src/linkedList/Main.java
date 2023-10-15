package linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(40);

        System.out.println(list.indexOf(20));
        System.out.println(list.contains(30));
    }
}

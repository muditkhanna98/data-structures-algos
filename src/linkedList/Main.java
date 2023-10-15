package linkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        list.addLast(10);
        list.addLast(20);
        System.out.println(list.size());
        list.addLast(30);
        list.addFirst(40);
        System.out.println(list.size());

        list.removeLast();
        System.out.println(list.size());

        list.reverse();
        int[] item = list.toArray();
        System.out.println(Arrays.toString(item));
    }
}

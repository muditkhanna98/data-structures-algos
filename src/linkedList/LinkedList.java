package linkedList;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int value) {
        int index = 0;
        Node current = first;

        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            Node previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public int[] toArray() {
        int[] arr = new int[size];
        int index = 0;
        Node current = first;
        while (current != null) {
            arr[index++] = current.value;
            current = current.next;
        }

        return arr;
    }

    public void reverse() {
        /*[10 -> 20 -> 30]
        p      c     n
        so with every iteration we start to move all three pointers one step ahead, and we stop when the c
        is null
        [10 -> 20 -> 30]
                p     c     n*/
        /*[10 -> 20 -> 30]
                        p    c    n*/
        if (isEmpty()) return;
        Node previous = first;
        Node current = first.next;


        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        //since in the last iteration previous will refer to the last element
        last = first;
        last.next = null;
        first = previous;

    }

    public int getKthFromTheEnd(int k) {
        Node a = first;
        Node b = first;

        for (int i = 0; i <= k - 1; i++) {
            b = b.next;
            if (b == null) {
                throw new IllegalArgumentException();
            }
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }


}

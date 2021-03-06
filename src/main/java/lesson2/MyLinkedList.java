package lesson2;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node first;
    private Node last;
    private int size = 0;

    class Node<T> {
        T value;
        Node next;
        Node prev;

        public Node(Node prev, T value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void addFirst(T value) {
        Node newNode = new Node(value, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return (T) oldFirst.value;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldLast = last;
        if (last.prev != null) {
            last.prev.next = null;
        } else {
            first = null;
        }
        last = last.prev;
        size--;
        return (T) oldLast.value;
    }

    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(value)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if(current == last){
            removeLast();
            return true;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }

}

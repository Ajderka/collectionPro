package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void revert() {
        Node<T> previousNode = null;
        Node<T> currentNode = head;
        Node<T> nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> tail = head;
            T value;
            if (tail.next == null) {
                value = tail.value;
                size--;
                return value;
            }
            for (int i = 0; i < size - 2; i++) {
                tail = tail.next;
            }
            value = tail.next.value;
            tail.next = null;
            size--;
            return value;
        }
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
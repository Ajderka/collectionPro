package map;

import java.util.Iterator;

/**
 * Ассоциативный массив на базе хэш-таблицы должен быть унифицирован через генерики и иметь методы:
 * boolean insert(K key, V value);
 * V get(K key);
 * boolean delete(K key);
 * <p>
 * Реализовывать итератор.
 * Внутренняя реализация должна использовать массив. Нужно обеспечить фиксированное время вставки и получение.
 * Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 * Методы разрешения коллизий реализовывать не надо. Например: если при добавлении ключ уже есть, то возвращать false.
 **/

public class MyHashMap<K, V> implements Iterable<MyHashMap.Node<K, V>> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] nodeArray;
    private int size;
    private int modification = 0;

    public MyHashMap() {
        this.nodeArray = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    }

    private int indexDefinition(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16) & nodeArray.length;
    }

    public V get(K key) throws NullPointerException {
        if (nodeArray[indexDefinition(key)].value == null) {
            throw new NullPointerException("This item is missing");
        }
        modification++;
        return nodeArray[indexDefinition(key)].value;
    }

    public boolean insert(K key, V value) {
        if (nodeArray[indexDefinition(key)] != null) {
            return false;
        }
        Node<K, V> node = new Node<>(key, value);
        nodeArray[indexDefinition(key)] = node;
        size++;
        modification++;
        if (size / DEFAULT_LOAD_FACTOR > nodeArray.length) {
            newArraySize();
        }
        return true;
    }

    public boolean delete(K key) {
        if (nodeArray[indexDefinition(key)] == null) {
            return false;
        }
        nodeArray[indexDefinition(key)] = null;
        modification++;
        return true;
    }

    private void newArraySize() {
        Node<K, V>[] newArray = (Node<K, V>[]) new Node[nodeArray.length << 1];
        Iterator<Node<K, V>> it = iterator();

        Node<K, V> next;
        while (it.hasNext()) {
            next = it.next();
            if (next.key == key) {
                return next.value;
            }
        }


        for (Node<K, V> n : nodeArray) {
            if (n != null) {
                newArray[indexDefinition(n.key)] = n;
            }
        }
        nodeArray = newArray;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            final Node<K, V>[] node = nodeArray;
            private int point = 0;
            final int mod = modification;

            @Override
            public boolean hasNext() {
                for (int i = point; i < nodeArray.length; i++) {
                    if (node[i] != null && mod == modification) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Node<K, V> next() {
                if (hasNext() && mod == modification) {
                    return node[point++];
                }
                return null;
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

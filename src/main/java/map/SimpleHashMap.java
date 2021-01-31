package map;

import java.util.Iterator;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] nodeArray;
    private int loadMassive;
    private int modification = 0;

    public SimpleHashMap() {
        this.nodeArray = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public SimpleHashMap(int length) {
        this.nodeArray = (Node<K, V>[]) new Node[length];
    }

    private int getIndex(Object key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() & (nodeArray.length - 1);
    }

    public V get(K key) throws NullPointerException {
        if (nodeArray[getIndex(key)].value == null) {
            throw new NullPointerException("This item is missing");
        }
        modification++;
        return nodeArray[getIndex(key)].value;
    }

    public boolean insert(K key, V value) {
        int index = getIndex(key);
        if (nodeArray[index] != null) {
            return false;
        } else if (loadMassive / DEFAULT_LOAD_FACTOR > nodeArray.length) {
            this.newArraySize();
        }
        Node<K, V> node = new Node<>(key, value);
        nodeArray[index] = node;
        loadMassive++;
        modification++;
        return true;
    }

    public boolean delete(K key) {
        if (nodeArray[getIndex(key)] == null) {
            return false;
        }
        nodeArray[getIndex(key)] = null;
        loadMassive--;
        modification++;
        return true;
    }

    private void newArraySize() {
        SimpleHashMap<K, V> simpleHashMap = new SimpleHashMap<>(loadMassive << 1);
        Iterator<Node<K, V>> it = this.iterator();
        while (it.hasNext()) {
            Node<K, V> next = it.next();
            simpleHashMap.insert(next.key, next.value);
        }
        nodeArray = simpleHashMap.nodeArray;
        loadMassive = simpleHashMap.loadMassive;
        modification = simpleHashMap.modification;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private final Node<K, V>[] node = nodeArray;
            private int point = 0;
            private final int mod = modification;

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
        private final K key;
        private V value;

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

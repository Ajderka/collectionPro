package set;

import generic.SimpleArray;

import java.util.Iterator;

/**
 * Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать
 * void add(E e) и реализовывать Iterable<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 * <p>
 * <p>
 * Код будет идентичным, как и в SimpleArray(Это код из задания реализации списка на массиве).
 * как можно за счет композиции сократить количества кода?
 * Здесь нужно использовать SimpleArray в реализации SimpleSet
 */
public class SimpleSet<T> implements Iterable<Object> {
    private final SimpleArray<T> simpleArray;

    public SimpleSet() {
        simpleArray = new SimpleArray<>();
    }

    public void add(T element) {
        if (unique(element)) {
            simpleArray.add(element);
        }
    }

    public int size() {
        return simpleArray.getSize();
    }

    private boolean unique(T element) {
        for (int i = 0; i < size(); i++) {
            if (element == simpleArray.get(i)
                    || ((element != null) && element.equals(simpleArray.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<Object> iterator() {
        return simpleArray.iterator();
    }
}


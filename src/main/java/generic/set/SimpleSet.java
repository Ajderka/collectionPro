package generic.set;

import generic.SimpleArray;

import java.util.Iterator;

/**
 * Реализовать коллекцию SimpleSet. Коллекция должна обеспечивать
 * void add(E e) и реализовывать Iterable<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует обычные массивы.
 *
 *
 * Код будет идентичным, как и в SimpleArray(Это код из задания реализации списка на массиве).
 * как можно за счет композиции сократить количества кода?
 * Здесь нужно использовать SimpleArray в реализации SimpleSet
 */
public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray array;

    public SimpleSet() {
        array = new SimpleArray();
    }

    public void add(T element) {
        array.add(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}

package generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int point = 0;

    public SimpleArray() {
        array = new Object[10];
    }

    public SimpleArray(int length) {
        this.array = new Object[length];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return point <= array.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new ArrayIndexOutOfBoundsException("нет свободных ячеек");
                }
                return (T) array[count++];
            }
        };
    }

    public void add(T model) {
        array[point++] = model;
    }

    public void set(int index, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, point);
        array[index] = model;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        point--;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, point);
        return array[index];
    }
}

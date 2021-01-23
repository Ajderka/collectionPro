package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private int[] mass;
    private int index = 0;

    public EvenIterator(int[] mass) {
        this.mass = mass;
    }

    @Override
    public boolean hasNext() {
        for (; index < mass.length; index++) {
            if (mass[index] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return mass[index++];
    }
}

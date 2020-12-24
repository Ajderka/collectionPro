package generic;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenNumberRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(6);
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(6));
    }

    @Test
    public void whenNumberSet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(6);
        simpleArray.set(1, 23);
        int result = (int) simpleArray.get(1);
        assertThat(result, is(23));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutBound() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(3);
        simpleArray.add(2);
        simpleArray.add(6);
        simpleArray.set(4, 23);
    }

    @Test
    public void whenRunIterator() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        for (int i = 0; i < 10; i++) {
            simpleArray.add(i + 1);
        }
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));

    }
}
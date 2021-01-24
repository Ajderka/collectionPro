package set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    @Test
    public void whenAddElementThenGetIt() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(2);
        simpleSet.add(4);
        simpleSet.add(5);
        simpleSet.add(5);
        Iterator<Object> iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
    }
}
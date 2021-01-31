package map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {

    @Test
    public void whenAddFiveElements() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        for (int i = 0; i < 4; i++) {
            simpleHashMap.insert(i, i);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(simpleHashMap.get(i));
            assertThat(i, is(simpleHashMap.get(i)));
        }
    }
}
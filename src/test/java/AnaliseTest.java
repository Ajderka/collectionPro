import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class AnaliseTest {

    @Test
    public void when4ElAddThen2Delete() {
        Analise analise = new Analise();
        List<Analise.User> previous = new ArrayList<>();
        previous.add(new Analise.User(1, "Ayderka"));
        previous.add(new Analise.User(2, "Ivanka"));
        previous.add(new Analise.User(3, "Petya"));
        previous.add(new Analise.User(4, "Zoryana"));
        List<Analise.User> current = new ArrayList<>();
        current.add(new Analise.User(1, "Ayderka"));
        current.add(new Analise.User(4, "Zoryana"));
        analise.diff(previous, current);
        assertThat(analise.getDelete(), is(2));
        assertThat(analise.getAdded(), is(0));
        assertThat(analise.getChanged(), is(0));
    }

    @Test
    public void when4ElAddThen1DeleteAnd1ElChanged() {
        Analise analise = new Analise();
        List<Analise.User> previous = new ArrayList<>();
        previous.add(new Analise.User(1, "Ayderka"));
        previous.add(new Analise.User(2, "Ivanka"));
        previous.add(new Analise.User(3, "Petya"));
        previous.add(new Analise.User(4, "Zoryana"));
        List<Analise.User> current = new ArrayList<>();
        current.add(new Analise.User(1, "Ayderka"));
        current.add(new Analise.User(4, "Zoryana"));
        current.add(new Analise.User(3, "Anya"));
        analise.diff(previous, current);
        assertThat(analise.getDelete(), is(1));
        assertThat(analise.getAdded(), is(0));
        assertThat(analise.getChanged(), is(1));
    }

    @Test
    public void when4ElAddThen1DeleteAnd1ElChangedAnd2Added() {
        Analise analise = new Analise();
        List<Analise.User> previous = new ArrayList<>();
        previous.add(new Analise.User(1, "Ayderka"));
        previous.add(new Analise.User(2, "Ivanka"));
        previous.add(new Analise.User(3, "Petya"));
        previous.add(new Analise.User(4, "Zoryana"));
        List<Analise.User> current = new ArrayList<>();
        current.add(new Analise.User(1, "Ayderka"));
        current.add(new Analise.User(4, "Zoryana"));
        current.add(new Analise.User(3, "Anya"));
        current.add(new Analise.User(5, "Vadim"));
        current.add(new Analise.User(6, "John"));
        analise.diff(previous, current);
        assertThat(analise.getDelete(), is(1));
        assertThat(analise.getAdded(), is(2));
        assertThat(analise.getChanged(), is(1));
    }
}
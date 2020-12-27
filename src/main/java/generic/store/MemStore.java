package generic.store;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean res = false;
        if (mem.get(Integer.parseInt(id)) != null) {
            mem.set(Integer.parseInt(id), model);
            res = true;
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res = false;
        if (mem.get(Integer.parseInt(id)) != null) {
            mem.remove(Integer.parseInt(id));
            res = true;
        }
        return res;
    }

    @Override
    public T findById(String id) {
        if (mem.get(Integer.parseInt(id)) != null) {
            return mem.get(Integer.parseInt(id));
        }
        return null;
    }
}
package list;

/**
 * Метод poll() - должен возвращать первое значение и удалять его из коллекции.
 * Метод push(T value) - помещает значение в конец.
 *
 * @param <T>
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.getSize() == 0) {
            while (in.getSize() > 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}

package list;

/**
 * Метод pop() - должен возвращать значение и удалять его из коллекции.
 * Метод push(T value) - помещает значение в коллекцию.
 * <p>
 * Внутри класса SimpleStack есть поле ForwardLinked. Это связанный список из предыдущего задания.
 * Мы можем добавить значение в ForwardLinked. Вам нужно в этот класс добавить метод deleteLast().
 * Чтобы реализовать метод SimpleStack.poll
 *
 * @param <T>
 */
public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<T>();

    public int getSize() {
        return linked.getSize();
    }

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    public T poll() {
        return linked.deleteFirst();
    }
}

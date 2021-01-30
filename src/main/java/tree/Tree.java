package tree;

import java.util.*;

/**
 * Метод add - Должен находить узел по значению parent и добавлять в него дочерний узел
 * со значением child.
 * В этом методе нужно проверить, что значения child еще нет в дереве а parent есть.
 * Если child есть, то метод должен вернуть false.
 *
 * @param <E>
 */

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> optionalENode = findBy(parent);
        List<Node<E>> nodeList;
        if (optionalENode.isPresent()) {
            nodeList = optionalENode.get().children;
            for (Node<E> n : nodeList) {
                if (n.equals(child)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        nodeList.add(new Node<>(child));
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
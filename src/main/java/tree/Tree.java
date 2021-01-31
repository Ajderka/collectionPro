package tree;

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary(E value) {
        Optional<Node<E>> optionalENode = findBy(value);
        return optionalENode.filter(eNode -> eNode.getChildren().size() <= 2).isPresent();
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> optionalENode = findBy(parent);
        List<Node<E>> nodeList;
        if (optionalENode.isPresent()) {
            nodeList = optionalENode.get().getChildren();
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
            if (el.getValue().equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
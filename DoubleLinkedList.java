public class DoubleLinkedList<T>
        extends AbstractList<T> {
    // Atributos
    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    //Métodos
    @Override
    public void add(T element) { // Insertar al final
        Node<T> n = new Node<>(null, element, null);
        if (isEmpty()) {
            first = n;
        } else {
            last.next = n;
            n.previous = last;
        }
        last = n;
        size++;
    }

    @Override
    public void addAt(int index, T element) {
        isIndexOutOfBound(index);
        Node<T> n = new Node<>(null, element, null);
        if (index == 0) {
            n.next = first;
            first.previous = n;
            first = n;
        } else {
            Node<T> aux = first;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            aux.previous.next = n;
            n.previous = aux.previous;
            aux.previous = n;
            n.next = aux;
        }
        size++;
    }

    @Override
    public void update(int index, T element) {
        isIndexOutOfBound(index);
        Node<T> n = first;
        for (int i = 0; i < index; i++)
            n = n.next;
        n.element = element;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        isIndexOutOfBound(index);
        Node<T> n = first;
        for (int i = 0; i < index; i++)
            n = n.next;
        return n.element;
    }

    @Override
    public void remove(int index) {
        isIndexOutOfBound(index);
        if (index == 0) {
            first = first.next;
            first.previous = null;
        } else {
            Node<T> aux = first;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            aux.previous.next = aux.next;
            aux.next.previous = aux.previous;
            aux.next = null;
            aux.previous = null;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (Node<T> aux = first; aux.next != null; aux = aux.next) {
                aux.previous = null;
            }
            size = 0;
        }
    }

    void isIndexOutOfBound(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("El índice está fuera de rango: " + index);
    }

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.next = next;
            this.previous = prev;
        }
    }
}

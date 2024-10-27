public class DoubleLinkedList<T>
        extends AbstractList<T> {
    // Atributos
    private int size = 0;
    private Node<T> first = null;
    private Node<T> prev = null;
    private Node<T> last = null;

    //Métodos
    @Override
    public void add(T element) {
        Node<T> n = new Node<>(element, null, null);
        if (isEmpty()) {
            first = n;
        } else {
            last.next = n;
        }
        last = n;
        size++;
    }

    @Override
    public void addAt(int index, T element) {

    }

    @Override
    public void update(int index, T element) {

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
    void remove(int index) {
        isIndexOutOfBound(index);

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
        if(!isEmpty()) {
            for(int i = 0; i < size - 1; i++) {
                Node<T> aux = first;
                first = first.next;
                // last = last.next; ???
                aux.next = null;
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
        Node<T> prev;


        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }
}
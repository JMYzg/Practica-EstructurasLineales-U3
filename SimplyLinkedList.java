/**
 * <b>Lista de acciones a implementar en la clase:</b>
 * <ol>
 * <li>Insertar al final.
 * <li>Insertar en la i-ésima posición.
 * <li>Actualizar el elemento en la i-ésima posición.
 * <li>Consultar el elemento en la i-ésima posición.
 * <li>Eliminar el elemento en la i-ésima posición.
 * <li>Obtener el tamaño de la lista.
 * <li>Consultar si la lista está vacía.
 * <li>Vaciar la lista.
 * </ol>
 */
public class SimplyLinkedList<T>
        extends AbstractList<T> {
    // Atributos
    private int size = 0;
    private Node<T> first = null;
    private Node<T> last = null;

    // Métodos
    @Override
    public void add(T element) { // Insertar al final.
        Node<T> n = new Node<>(element, null);
        if (isEmpty()) {
            first = n;
        } else {
            last.next = n;
        }
        last = n;
        size++;
    }

    @Override
    public void addAt(int index, T element) { // Insertar en la i-ésima posición.
        isIndexOutOfBound(index);
        Node<T> n = new Node<>(element, null);
        if (index == 0) {
            n.next = first;
            first = n;
        } else {
            Node<T> aux = first;
            Node<T> prev = aux;

            for (int i = 0; i < index; i++) {
                prev = aux;
                aux = aux.next;
            }
            prev.next = n;
            n.next = aux;
        }
        size++;
    }

    @Override
    public void update(int index, T element) { // Actualizar el elemento en la i-ésima posición.
        isIndexOutOfBound(index);
        Node<T> n = first;
        for (int i = 0; i < index; i++)
            n = n.next;
        n.element = element;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException { // Consultar el elemento en la i-ésima posición.
        isIndexOutOfBound(index);
        Node<T> n = first;
        for (int i = 0; i < index; i++)
            n = n.next;
        return n.element;
    }

    @Override
    public void remove(int index) { // Eliminar el elemento en la i-ésima posición.
        isIndexOutOfBound(index);
        Node<T> aux = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<T> prev = aux;
            for (int i = 0; i < index; i++) {
                prev = aux;
                aux = aux.next;
            }
            prev.next = aux.next;
        }
        aux.next = null;
        size--;
    }

    @Override
    public int size() { // Obtener el tamaño de la lista.
        return size;
    }

    @Override
    public boolean isEmpty() { // Consultar si la lista está vacía.
        return size <= 0;
    }

    @Override
    public void clear() { // Vaciar la lista.
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                Node<T> aux = first;
                first = first.next;
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
        // Atributos
        T element;
        Node<T> next;

        // Constructor
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }
}

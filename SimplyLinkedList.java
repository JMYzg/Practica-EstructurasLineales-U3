//Lista de acciones a implementar en la clase:
// Insertar al final.
// Insertar en la i-ésima posición.
// Actualizar el elemento en la i-ésima posición.
// Consultar el elemento en la i-ésima posición.
// Eliminar el elemento en la i-ésima posición.
// Obtener el tamaño de la lista.
// Consultar si la lista está vacía.
// Vaciar la lista.

public class SimplyLinkedList<T> extends AbstractList<T> {
    // Atributos
    int size = 0;
    Node<T> head = null;
    Node<T> tail = null;

    // Métodos
    @Override
    public void add(T element) {
        Node<T> n = new Node<>(element, null);
        if (isEmpty()) {
            head = n;
        } else {
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    @Override
    public void addIn(int index, T element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("El índice está fuera de rango: " + index);
        }
        if(isEmpty()) {
            add(element);
        } else if (index == 0) {
            Node<T> n = new Node<>(element, null);
            n.setNext(head);
            head = n;
            size++;
        } else {
            Node<T> n = new Node<>(element, null);
            Node<T> aux = head;
            Node<T> prev = head;

            for (int i = 0; i < index; i++) {
                prev = aux;
                aux = aux.getNext();
            }

            prev.setNext(n);
            n.setNext(aux);
            size++;
        }
    }

    @Override
    public void update(int index, T element) {
        if (isEmpty() || index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("El índice está fuera de rango: " + index);
        }
        else {
            Node<T> aux = head;
            Node<T> prev = head;
            for (int i = 0; i < index; i++) {
                prev = aux;
                aux = aux.getNext();
            }
            Node<T> n = new Node<>(element, aux.getNext());
            prev.setNext(n);
            aux.setNext(null);
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("El índice está fuera de rango: " + index);
        }
        Node<T> n = head; // new Node<>(head.getElement(), head.getNext());
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        return n.getElement();
    }

    @Override
    public void remove(int index) {
        if (isEmpty() || index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("El índice está fuera de rango: " + index);
        }
        else if (index == 0) {
            Node<T> aux = head;
            head = head.getNext();
            aux.setNext(null);
            size--;
        } else {
            Node<T> aux = head;
            Node<T> prev = head;
            for (int i = 0; i < index; i++) {
                prev = aux;
                aux = aux.getNext();
            }
            prev.setNext(aux.getNext());
            aux.setNext(null);
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                Node<T> aux = head;
                head = head.getNext();
                aux.setNext(null);
            }
            size = 0;
        }
    }

//    public T getHead() {
//        return head.getElement();
//    }
//
//    public T getTail() {
//        return tail.getElement();
//    }


    private static class Node<T> {
        // Atributos
        private final T element;
        private Node<T> next;

        // Constructor
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        //Métodos
        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}

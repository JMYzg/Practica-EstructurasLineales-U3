public class CircularLinkedList<T>
        extends AbstractList<T> {
    // Atributos
    public static final int increaseCapacity = 10;
    int capacity = 0;
    int first = 0;
    int last = capacity - 1;
    int size = 0;
    @SuppressWarnings("unchecked")
    T[] nodes = (T[]) new Object[capacity];

    // Métodos
    @Override
    void add(T element) {
        if (isFull()) {
            resize();
        }
        last = next(last);
        nodes[last] = element;
        size++;
    }

    @Override
    void addAt(int index, T element) {
        if (isFull()) {
            resize();
        }
        for (int i = last; i >= index; i--) {
            nodes[next(i)] = nodes[i];
        }
        nodes[index] = element;
        last = next(last);
        size++;
    }

    @Override
    void update(int index, T element) {nodes[index] = element;}

    @Override
    T get(int index) {return nodes[index];}

    @Override
    void remove(int index) {
        if (isEmpty()) return;
        else if (index == first) {
            first = next(first);
        } else if (index == last) {
            last = (last - 1) % capacity;
        } else {
            int pos = next(index + first - 1);
            for (int i = next(pos); i <= last; i++) {
                nodes[(i - 1) % capacity] = nodes[i];
            }
            last = (last - 1) % capacity;
        }
        size--;
    }

    @Override
    int size() {return size;}

    @Override
    boolean isEmpty() {return size <= 0;}

    @Override
    void clear() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[0];
        nodes = temp;
        first = size = capacity = 0;
        last = capacity - 1;
    }

    boolean isFull() {return size == capacity;}

    int next(int position) {return (position + 1) % capacity;}

    void resize(){
        int increase = capacity < (increaseCapacity / 2) ?
                increaseCapacity : capacity >> 1;
        int n = capacity;
        capacity = capacity + increase;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity];
        if (n >= 0) System.arraycopy(nodes, 0, temp, 0, n);
        nodes = temp;
    }
}

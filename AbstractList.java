public abstract class AbstractList<T> {
    abstract void add(T e);
    abstract void addIn(int i, T e);
    abstract void update(int i, T e);
    abstract T get(int i);
    abstract void remove(int i);
    abstract boolean isEmpty();
    abstract void clear();
}

package by.it.poprugo.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3 / 2 + 1));
        if (contains(t)) return false;
        elements[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int ind = indexOfElement(o);
        if (ind > -1) {
            System.arraycopy(elements, ind + 1, elements, ind, size - ind -1);
            size--;
            return true;
        }
        return false;
    }

    private int indexOfElement(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null) return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) { return indexOfElement(o) > -1; }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> arr) {
        int count = 0;
        for (T element : arr) {
            if (add(element))
                count++;
        }
        return count > 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null || c.isEmpty())
            return false;
        for (Object element : c) {
            if (!contains(element)) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        if (c == null || c.isEmpty())
            return false;
        for (Object element : c) {
            if (remove(element)) count++;
        }
        return count > 0;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[]{};
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
}

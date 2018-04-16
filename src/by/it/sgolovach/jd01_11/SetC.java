package by.it.sgolovach.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;
    private int n = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimetr).append(elements[i]);
            delimetr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (o == null && n == 0) {
                n = 1;
                return false;
            }
            if (o == element) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        if (contains(t) == false)
            elements[size++] = t;
        return false;
    }

    public T remove(int index) {
        T deleted = elements[index];
        if (index + 1 < size)
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return deleted;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) remove(index);
        return (index > -1);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        for (Object o : a) {
            add((T) o);
        }
        return true;

    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}

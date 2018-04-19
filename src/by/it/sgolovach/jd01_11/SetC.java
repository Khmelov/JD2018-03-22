package by.it.sgolovach.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

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
        return indexOf(o) >= 0;
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
        if (!contains(t))
            elements[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            size--;
        }
        return (index > -1);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext())
            if (!contains(iterator.next())) return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] eleme = (T[]) c.toArray();
        for (T t : eleme) {
            add(t);
        }
        return false;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        T[] eleme = (T[]) c.toArray();
        for (T t : eleme) {
            remove(t);
            res = true;
        }
        return res;
    }

    @Override
    public void clear() {
        System.arraycopy(elements, 0, elements, 0, 0);
        size = 0;
    }
}

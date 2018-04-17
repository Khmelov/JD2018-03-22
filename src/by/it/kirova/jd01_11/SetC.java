package by.it.kirova.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        if (contains(element))
            return false;
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexElement(o);
        if (index > -1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            size--;
            return true;
        }
        return false;
    }


    private int indexElement(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }


    @Override
    public boolean contains(Object o) {
        return indexElement(o) > -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> array) {
        int count = 0;
        for (T element : array) {
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
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        for (Object element : c) {
            if (remove(element))
                count++;
        }
        return count > 0;
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

    @SuppressWarnings("all")
    @Override
    public void clear() {
        elements = (T[]) new Object[]{};
        size = 0;
    }

    //Task C ok =======================================================================================================

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


}

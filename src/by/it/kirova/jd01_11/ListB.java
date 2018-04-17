package by.it.kirova.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    public ListB() {

    }

    public ListB(T[] elements) {
        this.size = elements.length;
        this.elements = elements;
    }

    @Override
    public boolean add(T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        elements[size++] = element;
        return false;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        if (index + 1 < size)
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return deleted;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> array) {
        if (array != null && array.size() != 0) {
            int newSize = size + array.size();
            if (newSize > elements.length)
                elements = Arrays.copyOf(elements, newSize);
            Object[] tmp = this.elements;//для обхода warning с копированием из object[] в T[]
            System.arraycopy(array.toArray(), 0, tmp, size, array.size());
            size = newSize;
            return true;
        }
        return false;
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

    //TaskB ok =====================================================================================

    @Override
    public int size() {
        return size;
    }

    @Override
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
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1)
            remove(index);
        return index > -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }


    // TaskB + additional task =======================================================================
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}



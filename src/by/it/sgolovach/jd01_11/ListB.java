package by.it.sgolovach.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    T elementData(int index) {
        return (T) elements[index];
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
        T oldValue = elementData(index);
        elements[index] = element;
        return oldValue;
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
    public boolean addAll(Collection<? extends T> c) {

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    public void ensureCapacity(int minCapacity) {
        modCount++;
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            Object oldData[] = elements;
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            elements = Arrays.copyOf(elements, newCapacity);
        }

    }

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
    public Object[] toArray() {

        return Arrays.copyOf(elements, size);
    }


    // End,,,

    @Override
    public Iterator<T> iterator() {

        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
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

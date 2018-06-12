package by.it.poprugo.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    public ListB() {}

    public ListB(T[] elements) {
        this.size = elements.length;
        this.elements = elements;
    }

    @Override
    public boolean add(T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size*3/2+1));
        elements[size++] = element;
        return false;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        if ((index + 1) < size)
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
        T changed = elements[index];
        elements[index] = element;
        return changed;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;

        /*тест проверяет вставку 3 элементов: нач., середину и кон.
        T[] copyElements = Arrays.copyOf(elements, size+1);
        if ((index + 1) <= size) {
            System.arraycopy(elements, index, copyElements, index + 1,size - index);
            copyElements[index] = element;

        }
        elements = Arrays.copyOf(copyElements, size + 1);
        System.out.println();
        System.out.println("very new elements");
        for (T t : elements) {
            System.out.print(t+" ");
        }*/
    }

    @Override
    public boolean addAll(Collection<? extends T> arr) {
        if (arr != null) {
            int sizeNew = size + arr.size();
            if (sizeNew > elements.length)
                elements = Arrays.copyOf(elements, sizeNew);
            System.arraycopy((arr.toArray()), 0, elements, size, arr.size());
            size = sizeNew;
            return true;
        }
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
    public int indexOf(Object o) {
        return 0;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
}

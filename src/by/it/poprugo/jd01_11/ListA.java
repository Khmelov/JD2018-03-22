package by.it.poprugo.jd01_11;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public abstract class ListA<T> implements List<T> {
    //? действительно должен быть абстрактным?

    @SuppressWarnings("all")
    private T[] elements = (T[]) new Object();
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        elements[size] = element;
        return false;
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index-1);
        size--;
        return deleted;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

//    @Override
//    public boolean removeIf(Predicate<? super T> filter) {
//        return false;
//    }
//
//    @Override
//    public Stream<T> stream() {
//        return null;
//    }
//
//    @Override
//    public Stream<T> parallelStream() {
//        return null;
//    }
//
//    @Override
//    public void forEach(Consumer<? super T> action) {
//
//    }
//
//    public ListA() {
//        super();
//    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public boolean contains(Object o) {
//        return false;
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return null;
//    }
//
//    @Override
//    public Object[] toArray() {
//        return new Object[0];
//    }
//
//    @Override
//    public <T1> T1[] toArray(T1[] a) {
//        return null;
//    }
//
//    @Override
//    public boolean containsAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(Collection<? extends T> c) {
//        return false;
//    }
//
//    @Override
//    public boolean addAll(int index, Collection<? extends T> c) {
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public boolean retainAll(Collection<?> c) {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    @Override
//    public T set(int index, T element) {
//        return null;
//    }
//
//    @Override
//    public void add(int index, T element) {
//
//    }
//
//    @Override
//    public T remove(int index) {
//        return null;
//    }
//
//    @Override
//    public int indexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public int lastIndexOf(Object o) {
//        return 0;
//    }
//
//    @Override
//    public ListIterator<T> listIterator() {
//        return null;
//    }
//
//    @Override
//    public ListIterator<T> listIterator(int index) {
//        return null;
//    }
//
//    @Override
//    public List<T> subList(int fromIndex, int toIndex) {
//        return null;
//    }
//
//    @Override
//    public void replaceAll(UnaryOperator<T> operator) {
//
//    }
//
//    @Override
//    public void sort(Comparator<? super T> c) {
//
//    }
//
//    @Override
//    public Spliterator<T> spliterator() {
//        return null;
//    }
//
//
}

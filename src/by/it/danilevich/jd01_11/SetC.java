package by.it.danilevich.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        String delimeter ="";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter =", ";
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
        if (size==0) return true;
        else return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T el: elements) {
            if (el!=null)
            if (el.equals(o)) return true;
        }
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
    public boolean add(T element) {
        //map.put(e, PRESENT)==null;
        if (size==elements.length)
            elements = Arrays.copyOf(elements,(size*3)/2+1);
        int a= size++;
        elements[a] = element;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index>-1)remove(index);
        return (index>-1);
    }
    public int indexOf(Object o) {
        if (o ==null){
            for (int i = 0;i<size;i++)  if (elements[i]==null) return i;

        }
        else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return i;

            }
        }
        return -1;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int sizeTemp = size;
        int count = 0;
        for (T element : c) {
            if (add(element))
                count++;
        }
            return (size ==(sizeTemp+count));
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
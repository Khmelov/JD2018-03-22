package by.it.lyukovich.jd_01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements = (T[])new Object[]{};
    private int size =0;

    @Override     // Overridden
    public int size() {
        return size;
    }

    @Override // Overridden
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (o==null){
                if(element==null)
                    return true;
            } else {
                if (element!=null && element.equals((T)o))
                    return true;
            }
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

    @Override // Overriden
    public boolean add(T element) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1);
        elements[size]=element;
        size++;
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
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
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

    @Override // Overridden
    public T get(int index) {
        return elements[index];
    }

    @Override // Overridden
    public T set(int index, T element) {
        T deleted = elements[index];
        elements[index]=element;
        return deleted;
    }

    @Override // Overridden
    public void add(int index, T element) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1);
        System.arraycopy(elements,index, elements, index+1,size-index);
        set(index,element);
        ++size;
    }

    @Override // Overridden
    public T remove(int index) {
        T deleted = elements[index];
        if (index+1<size)
            System.arraycopy(elements,index+1, elements, index,size-index-1);
        size--;
        return deleted;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (o==null){
                if(elements[i]==null)
                    return i;
            } else {
                if (elements[i]!=null && elements[i].equals((T)o))
                    return i;
            }
        }
        return -1;
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

    @Override // Overridden
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        StringBuilder delimiter = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter=new StringBuilder(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
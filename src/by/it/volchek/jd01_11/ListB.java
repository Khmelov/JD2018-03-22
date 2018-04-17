package by.it.volchek.jd01_11;

import java.util.*;

/**
 * Created by volchek on 16.04.18.
 */
public class ListB<T> implements List<T>{
    @SuppressWarnings("all")
    private T[] elements = (T[])new Object[]{};
    private int size = 0;

    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder("[");
        String delimeter="";
        for (int i = 0; i <size ; i++) {

            sb.append(delimeter).append(elements[i]);
            delimeter=", ";
        }
        sb.append("]");
        return sb.toString();
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
    public boolean add(T element) {
        if(size==elements.length)
            elements= Arrays.copyOf(elements,(size*3/2+1));
        elements[size++] = element;
        return true;
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

        if (c.isEmpty()) {
            System.out.println("попытка добваить пустое множество");
            return false;
        } else {
            Iterator<? extends T> iter = c.iterator();
            while (iter.hasNext()) {
                if (size == elements.length)
                    elements = Arrays.copyOf(elements, (size * 3 / 2 + 1));
                elements[size++] = iter.next();
            }
            return true;

        }
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
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index>size) {
            System.out.println("Введен неправильный индекс");

            return element;
        }
        else {
            T elem  = elements[index];
            elements[index] = element;

            return elem;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index>=elements.length) {
            System.out.println("Введен неправильный индекс, элемент будет добавлен в конец списка.");
            add(element);

        }
        else {
            size++;
            T[] elementsArr =(T[])new Object[]{};
            elementsArr = Arrays.copyOf(elements,elements.length);
            if(size==elements.length)
                elements=Arrays.copyOf(elements,(size*3/2+1));
            for (int i = 0; i < index ; i++) {
                elements[i] = elementsArr[i];
            }
            elements[index] = element;
            for (int i = index+1; i <size ; i++) {
                elements[i]=elementsArr[i-1];
            }


        }
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-index);
        size--;
        return deleted;
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
}

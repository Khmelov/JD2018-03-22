package by.it.kovko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T>{

    private T[] elements = (T[])new Object[]{};
    private int size =0;

    @Override // Overridden
    public int size() {
        return size;
    }

    @Override // Overridden
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {
            if (o==null){
                if(elements[i]==null){
                    return true;
                }

            } else {
                if (elements[i]!=null && elements[i].equals((T)o))
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

    @Override
    public boolean add(T element) {
        if (!contains(element)){
            if (size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1);
            elements[size]=element;
            size++;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index=-1;
        for (int i = 0; i < size; i++) {
            if (o==null){
                if(elements[i]==null){
                    index=i; break;
                }
            } else {
                if (elements[i]!=null && elements[i].equals(o)){
                    index=i; break;
                }
            }
        }
        if (index>=0){
            if (index+1<size)
                System.arraycopy(elements,index+1, elements, index,size-index-1);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
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
        Iterator myIt = c.iterator();
        for (int i = 0; i < c.size(); i++) {
            remove(myIt.next());
        }
        return true;
    }

    @Override
    public void clear() {
        System.arraycopy(elements,0, elements, 0,0);
        size=0;
    }

    @Override
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

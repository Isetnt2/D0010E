package labb2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@SuppressWarnings("serial")
public class MyArrayList<E> implements Serializable, Cloneable, Iterable<E>,
        Collection<E>, List<E>, RandomAccess {
    public E[] arr;
    public static final Object[] EMPTYOBJECT = {};

    // ---------------------------------------------------------------

    public static void main(String[] args) {
        MyArrayList<String> strlist = new MyArrayList<String>();

        // testa metoder härifrån

    }

    // ---------------------------------------------------------------

    public MyArrayList(int initialCapacity) {
        if(initialCapacity > -1){
            this.arr = (E[]) new Object[initialCapacity];
        } else{
            throw new IllegalArgumentException();
        }
    }

    public MyArrayList() {

        this.arr = (E[])EMPTYOBJECT;
    }

    // -- 1 --

    @Override
    public int size() {
        return this.arr.length;
        //return -1; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public boolean isEmpty() {
        /* ska implementeras */
        if(this.arr.length == 0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void clear() {
        this.arr = (E[]) new Object[this.arr.length];
    }

    // -- 2 --

    public void ensureCapacity(int minCapacity) {
        E[] temp = (E[]) new Object[minCapacity];
        for (int i = 0; i < this.arr.length; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
    }

    public void trimToSize() {
        /* ska implementeras */
        int count = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] != null){
                count++;
            }
        }
        E[] temp = (E[]) new Object[count];
        int tempIndex = 0;
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] != null){
                temp[i-tempIndex] = this.arr[i];
            } else {
                tempIndex++;
            }
        }
        this.arr = temp;
    }

    // -- 3 --

    @Override
    public void add(int index, E element) {
        if(this.arr.length < index){
            E[] temp = (E[]) new Object[index];
            for (int i = 0; i < this.arr.length; i++) {
                temp[i] = this.arr[i];
            }
            temp[index] = element;
            this.arr = temp;
        } else{
            E[] temp = (E[]) new Object[this.arr.length+1];
            for (int i = 0; i < this.arr.length; i++) {
                if(i == index){
                    temp[i] = element;
                } else if(i > index){
                    temp[i] = this.arr[i-1];
                } else {
                    temp[i] = this.arr[i];
                }
            }
            this.arr = temp;
        }
    }

    @Override
    public boolean add(E e) {
        /* ska implementeras */
        try {
                ensureCapacity(this.arr.length + 1);
                this.arr[this.arr.length-1] = e;
                return true;
        } catch (Error err) {
            return false; /* bara med för att Eclipse inte ska klaga */
        }
    }

    // -- 4 --

    @Override
    public E get(int index) {
        /* ska implementeras */
        try {
            return this.arr[index];
        } catch (Error e){
            return null; /* bara med för att Eclipse inte ska klaga */
        }
    }

    @Override
    public E set(int index, E element) {
        /* ska implementeras */
        this.arr[index] = element;
        return null; /* bara med för att Eclipse inte ska klaga */
    }

    // -- 5 --

    @Override
    public E remove(int index) {
        int moved = this.arr.length - 1 - index;
        E oldVal = (E) this.arr[index];
        if(moved > 0){
            for (int i = index; i < this.arr.length-1; i++) {
                this.arr[i] = this.arr[i+1];
            }
        }
        return oldVal; /* bara med för att Eclipse inte ska klaga */
    }

    protected void removeRange(int fromIndex, int toIndex) {
        /* ska implementeras */
        if(this.arr.length >= fromIndex && this.arr.length >= toIndex) {
            for (int i = fromIndex; i < toIndex; i++) {
                this.arr[i] = null;
            }
        } else{
            throw new IndexOutOfBoundsException();
        }
    }

    // -- 6 --

    @Override
    public int indexOf(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == o){
                return i;
            }
        }

        return -1; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public boolean remove(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == o){
                int moved = this.arr.length - 1 - i;
                if(moved > 0){
                    for (int j = i; j < this.arr.length-1; j++) {
                        this.arr[j] = this.arr[j+1];
                    }
                }
                return true;
            }
        }
        return false; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public boolean contains(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == o){
                return true;
            }
        }
        return false; /* bara med för att Eclipse inte ska klaga */
    }

    // -- 7 --

    @Override
    public Object clone() {
        /* ska implementeras */
        MyArrayList<E> myArr = new MyArrayList<>();
        for (int i = 0; i < this.arr.length; i++) {
            myArr.add(this.arr[i]);
        }
        return myArr;
    }

    @Override
    public Object[] toArray() {
        /* ska implementeras */
        Object[] temp = new Object[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            temp[i] = this.arr[i];
        }
        return temp;
    }

    // --- Rör ej nedanstående kod -----------------------------------

    public MyArrayList(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    private class InternalIterator implements Iterator {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Object next() {
            return get(current++);

        }

    }

    @Override
    public Iterator<E> iterator() {
        return new InternalIterator();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

}

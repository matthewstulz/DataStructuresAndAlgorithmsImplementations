package datastructures;

import java.util.Iterator;

public class Array<T> implements Iterable<T> {

    private T[] array;
    private int maxLength;
    private int currLength = 0;

    public Array() {
        this.maxLength = 16;
        array = (T[]) new Object[maxLength];
    }

    public Array(int length) {
        this.maxLength = length;
        array = (T[]) new Object[maxLength];
    }

    public int size() { return this.currLength; }

    public boolean isEmpty() { return size() == 0; }

    public T get(int index) { return array[index]; }

    public void set(T value, int index) { array[index] = value; }

    public void clear() {
        for (int i = 0; i < maxLength; i++) {
            array[i] = null;
        }
        currLength = 0;
    }

    public void add(T value, int index) {
        if (currLength + 1 > maxLength) {
            resize();
        }
        currLength++;
        for (int i = currLength; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public void add(T value) {
        if (currLength + 1 > maxLength) {
            resize();
        }
        array[currLength++] = value;
    }

    public void resize() {
        int newMaxLength = maxLength * 2;
        T[] newArray = (T[]) new Object[newMaxLength];
        for (int i = 0; i < currLength; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        maxLength = newMaxLength;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < currLength; i++) {
            if (array[i].equals(object)) {
                removeAt(i);
            }
        }
        return false;
    }

    public T removeAt(int index) {
        T value = array[index];
        for (int i = index; i < currLength - 1; ++i) {
            array[i] = array[i + 1];
        }
        maxLength = --currLength;
        return value;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < currLength; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    public void trimToSize() {
        T[] newArray = (T[]) new Object[currLength];
        for (int i = 0; i < currLength; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public String subList(int fromIndex, int toIndex) {
        int subListSize = toIndex - fromIndex;
        if (currLength == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(subListSize).append("[");
            for (int i = fromIndex; i < toIndex - 1; i++) {
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[toIndex - 1]);
            sb.append("]");
            return sb.toString();
        }
    }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < currLength;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override public String toString() {
        if (currLength == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(currLength).append("[");
            for (int i = 0; i < currLength - 1; i++) {
                sb.append(array[i]);
                sb.append(", ");
            }
            sb.append(array[currLength - 1]);
            return sb.append("]").toString();
        }
    }
}

package lesson2;

public class MyArray<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int size = 0;

    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    public void add(T item) {
        if(size == array.length-1) {
            resize(array.length * 2);
        }
        array[size++] = item;
    }

    public void remove(int index) {
        for (int i = index; i< size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        if (array.length > INIT_SIZE && size < array.length / CUT_RATE) {
            resize(array.length/2);
        }
    }

    public void remove(T object) {
        for (int i = 0; i < size; i++) {
            if(object.equals(array[i])){
                remove(i);
            }
        }
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        for (int i = 0; i < size - 1; i++) {
            str.append(array[i] + ", ");
        }
        str.append(array[size-1] + " ]");
        return str.toString();
    }
}

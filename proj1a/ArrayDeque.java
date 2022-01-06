
public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 0;
        this.nextLast = 1;
    }
    // Resize array into capacity cap//
    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        int oldIdx = addOne(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[oldIdx];
            oldIdx = addOne(oldIdx);
        }
        this.items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private int minusOne(int idx) {
        return (idx - 1 + items.length) % items.length;
    }

    private int addOne(int idx) {
        return (idx + 1) % items.length;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;

    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = addOne(nextFirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(i);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int firstIdx = addOne(nextFirst);
        T res = items[firstIdx];
        items[firstIdx] = null;
        nextFirst = addOne(nextFirst);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return res;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int lastIdx = minusOne(nextLast);
        T res = items[lastIdx];
        items[lastIdx] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return res;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int target = (addOne(nextFirst) + index) % items.length;
        return items[target];

    }

}

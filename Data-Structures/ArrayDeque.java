public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFront;
    private int nextBack;

    //initiates an empty ArrayDeque
    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFront = 0;
        this.nextBack = 1;
    }

    //Resizes array if original is too small and resizes down if too big
    private void resizeArray(int arrLength) {
        int temp = this.items.length;
        T[] newArr = (T[]) new Object[arrLength];
        int start = (nextFront + 1) % items.length;
        int end = (items.length + nextBack - 1) % items.length;
        int finalPos = items.length - (items.length - start);

        if (items.length > arrLength) {
            if (items.length <= 8) {
                return;
            } else if (start <= end) {
                System.arraycopy(this.items, start, newArr, 0, size);
                this.items = newArr;
                this.nextFront = items.length - 1;
                this.nextBack = 0;
            } else {
                System.arraycopy(this.items, start, newArr, 0, items.length - start);
                System.arraycopy(this.items, 0, newArr, items.length - start,
                        size - (items.length - start));
                this.items = newArr;
                this.nextFront = items.length - 1;
                this.nextBack = 0;
            }
        } else {
            System.arraycopy(this.items, start, newArr, 0, items.length - start);
            System.arraycopy(this.items, 0, newArr, items.length - start, finalPos);
            this.items = newArr;
            this.nextFront = this.items.length - 1;
            this.nextBack = temp;
        }
    }

    //Add T type item to the front of the array
    @Override
    public void addFirst(T item) {
        if (this.items[nextFront] != null) {
            resizeArray(size * 2);
        }
        this.items[nextFront] = item;
        this.nextFront = (items.length + nextFront - 1) % items.length;
        this.size += 1;
    }

    @Override
    public void addLast(T item) {
        if (this.items[nextBack] != null) {
            resizeArray(size * 2);
        }
        this.items[nextBack] = item;
        this.nextBack = (nextBack + 1) % items.length;
        this.size += 1;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    private T returnFront() {
        return get(0);
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T returnedItem = returnFront();
        this.items[(nextFront + 1) % items.length] = null;
        nextFront = (nextFront + 1) % items.length;
        size -= 1;
        if (items.length >= 2 * size) {
            resizeArray(items.length / 2);
        }
        return returnedItem;
    }

    private T returnBack() {
        return get(size - 1);
    }

    //returns the last element and then replaces it
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T returnedItem = returnBack();
        this.items[(items.length + (nextBack - 1)) % items.length] = null;
        nextBack = (items.length + (nextBack - 1)) % items.length;
        size -= 1;
        if (items.length >= 2 * size) {
            resizeArray(items.length / 2);
        }
        return returnedItem;
    }

    @Override
    public T get(int index) {
        if (this.isEmpty() || index >= size) {
            return null;
        }
        int index0 = this.nextFront + 1;
        int trueIndex = (index0 + index) % this.items.length;
        return this.items[trueIndex];
    }
}

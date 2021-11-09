public class LinkedListDeque<T> {
    private int size;
    private Node first;
    private Node last;

    private class Node {
        private T item;
        private Node previous;
        private Node next;

        Node(T item, Node p, Node n) {
            this.item = item;
            this.previous = p;
            this.next = n;
        }
    }

    public LinkedListDeque() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    //adds new node to in front of the list
    public void addFirst(T item) {
        Node newNode = new Node(item, null, null);
        if (this.size == 0) {
            this.size += 1;
            this.first = newNode;
            this.last = newNode;
            return;
        }
        this.size += 1;
        Node temp = this.first;
        this.first = newNode;
        newNode.next = temp;
        temp.previous = newNode;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, null, null);
        if (this.isEmpty()) {
            this.size += 1;
            this.first = newNode;
            this.last = newNode;
            return;
        }
        this.size += 1;
        Node temp = this.last;
        this.last = newNode;
        newNode.previous = temp;
        temp.next = newNode;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node curr = this.first;
        if (curr.next != null) {
            for (int i = 0; i <= this.size; i++) {
                System.out.print(this.first.item + " ");
            }
            curr = curr.next;
        } else {
            return;
        }
    }

    //remove wo looping or recursion
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else if (size == 1) {
            this.size -= 1;
            Node temp = this.first;
            this.first = null;
            this.last = null;
            return temp.item;
        }
        Node temp = this.first;
        this.first = this.first.next;
        this.first.previous = null;
        this.size -= 1;
        return temp.item;

    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else if (size == 1) {
            this.size -= 1;
            Node temp = this.last;
            this.first = null;
            this.last = null;
            return temp.item;
        }
        Node temp = this.last;
        this.last = this.last.previous;
        this.last.next = null;
        this.size -= 1;
        return temp.item;

    }

    //get w iteration
    public T get(int index) {
        if (this.isEmpty() || index >= size) {
            return null;
        }
        Node curr = this.first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    private T helper(int index, Node curr) {
        if (index == 0) {
            return curr.item;
        } else {
            return helper(index - 1, curr.next);
        }
    }


    public T getRecursive(int index) {
        return helper(index, this.first);
    }
}

class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;

    void push(T value) {
        Element<T> elem = new Element<>(value);
        if (tail == null) { head = elem; }
        else {
            elem.setPrev(tail);
            tail.setNext(elem);
        }
        tail = elem;
    }

    T pop() {
        if (tail == null) return null;
        Element<T> curr = tail;
        if (curr.getPrev() == null) {
            tail = null;
            head = null;
        }
        else {
            curr.getPrev().setNext(null);
            tail = curr.getPrev();
        }
        return curr.getValue();
    }

    void unshift(T value) {
        Element<T> elem = new Element<>(value);
        if (head == null) { tail = elem; }
        else {
            elem.setNext(head);
            head.setPrev(elem);
        }
        head = elem;
    }

    T shift() {
        if (head == null) return null;
        Element<T> curr = head;
        if (curr.getNext() == null) {
            head = null;
            tail = null;
        }
        else {
            curr.getNext().setPrev(null);
            head = curr.getNext();
        }
        return curr.getValue();
    }
}

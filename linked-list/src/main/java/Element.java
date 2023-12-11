public class Element<T> {
    private final T value;
    private Element<T> prev;
    private Element<T> next;
    
    Element(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    
    T getValue() { return value; }
    Element<T> getNext() { return next; }
    Element<T> getPrev() { return prev; }
    void setNext(Element<T> element) { this.next = element; }
    void setPrev(Element<T> element) { this.prev = element; }
}
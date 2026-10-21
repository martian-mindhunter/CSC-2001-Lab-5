public interface MyQueue {
    void enqueue(String elt);
    String dequeue();
    String peek();
    int size();
    boolean is_empty();
}

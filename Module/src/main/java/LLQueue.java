import java.util.NoSuchElementException;
import java.util.Objects;


class LLQueue implements MyQueue{

    Pair llqueueHead;
    Pair llqueueTail;

    public LLQueue ( Pair l, Pair r ){
        this.llqueueHead= l;
        this.llqueueTail= r;
    }

    public LLQueue(){
        this.llqueueHead = null;
        this.llqueueTail = null;
    }

    // Returns an empty queue w/o arguments
    public static LLQueue empty_queue(){

        return(new LLQueue());

    }

    // LLQueue equals method
    public boolean equals( Object obj ){

        if(obj instanceof LLQueue){

            LLQueue other = (LLQueue)obj;

            return Objects.equals(this.llqueueHead, other.llqueueHead) && Objects.equals(this.llqueueTail, other.llqueueTail);

        } else {
            return false;
        }

    }

    // Reverse a list
    static Pair revList(Pair l){
        Pair reversed = null;
        while(l != null){
            reversed = new Pair(l.head(), reversed);
            l = l.tail();
        }
        return reversed;
    }

    // Refill helper method
    public void refillHead(){
        if(this.llqueueHead == null){
            this.llqueueHead = revList(this.llqueueTail);
            this.llqueueTail = null;
        }
    }

    // Adds a string to the end of queue
    @Override
    public void enqueue(String elt){
        this.llqueueTail = new Pair(elt, this.llqueueTail);
    }

    // enqueue helper method that recursively appends new elt
//    private Pair addToEnd(String l, Pair r){
//        if(l == null){
//            return new Pair(l, null);
//        }
//        return new Pair(r.head(), addToEnd(l, r.tail()));
//    }

    // Removes & returns the top element (FIFO)
    public String dequeue(){
        refillHead();
        if(this.llqueueHead == null){
            throw new NoSuchElementException();
        }

        String topValue = this.llqueueHead.head();
        this.llqueueHead = this.llqueueHead.tail();

        return topValue;

    }

    // Returns top element w/o removal
    public String peek(){
        refillHead();
        if(this.llqueueHead == null){
            throw new NoSuchElementException();
        }

        return this.llqueueHead.head();
    }

    // Returns the # of elts in stack
    public int size(){
        int count = 0;
        for ( Pair current = this.llqueueHead; current != null; current = current.tail()) {
            count++;
        }
        for(Pair current = this.llqueueTail; current != null; current = current.tail()){
            count++;
        }
        return count;
    }

    // size helper method
//    public int counter(Pair r){
//        return switch(r){
//            case null -> 0;
//            default -> 1 + counter(r.tail());
//        };
//    }

    // Returns if a stack has no elts
    public boolean is_empty(){
        return this.llqueueHead == null && this.llqueueTail == null;
    }

}
import java.util.NoSuchElementException;
import java.util.Objects;

class LLQueue {

    Pair llqueuePair;

    public LLQueue ( Pair r ){
        this.llqueuePair = r;
    }

    public LLQueue(){
        this.llqueuePair = null;
    }

    // LLQueue equals method
    public boolean equals( Object obj ){

//        if (other == null){
//            return false;
//        }
//        if(this == other){
//            return true;
//        }
//
//        if(this.llqueuePair == null || other.llqueuePair == null){
//            return this.llqueuePair == other.llqueuePair;
//        }
//        return this.llqueuePair.equals(other.llqueuePair);

        if(obj instanceof LLQueue){

            LLQueue other = (LLQueue)obj;

            return Objects.equals(this.llqueuePair, other.llqueuePair);

        } else {
            return false;
        }

    }

    // Returns an empty queue w/o arguments
    public static LLQueue empty_queue(){
        return(new LLQueue());
    }

    // Adds a string to the end of queue
    public void enqueue(String elt){
        this.llqueuePair = addToEnd(this.llqueuePair, elt);
    }

    // enqueue helper method that recursively appends new elt
    private Pair addToEnd(Pair r, String l){
        if(r == null){
            return new Pair(l, null);
        }
        return new Pair(r.head(), addToEnd(r.tail(), l));
    }

    // Removes & returns the top element (FIFO)
    public String dequeue(){
        if(this.llqueuePair == null){
            throw new NoSuchElementException();
        }

        String topValue = this.llqueuePair.head();
        this.llqueuePair = this.llqueuePair.tail();

        return topValue;

    }

    // Returns top element w/o removal
    public String peek(){
        if(this.llqueuePair == null){
            throw new NoSuchElementException();
        }

        return this.llqueuePair.head();
    }

    // Returns the # of elts in stack
    public int size(){
        return counter(this.llqueuePair);
    }
    // size helper method
    public int counter(Pair r){
        return switch(r){
            case null -> 0;
            default -> 1 + counter(r.tail());
        };
    }

    // Returns if a stack has no elts
    public boolean is_empty(){
        return this.equals(new LLQueue());
    }

}
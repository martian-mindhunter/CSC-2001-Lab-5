import java.util.NoSuchElementException;

class LLQueue {

    Pair llqueuePair;

    public LLQueue ( Pair r ){
        this.llqueuePair = r;
    }

    public LLQueue(){
        this.llqueuePair = null;
    }

    // LLQueue equals method
    public boolean equals( LLQueue other ){

        if (other == null){
            return false;
        }
        if(this == other){
            return true;
        }

        if(this.llqueuePair == null || other.llqueuePair == null){
            return this.llqueuePair == other.llqueuePair;
        }
        return this.llqueuePair.equals(other.llqueuePair);

    }

    // Returns an empty queue w/o arguments
    public static LLQueue empty_queue(){
        return(new LLQueue());
    }
    // Adds a String to the top of the stack
    public void push(String elt){
        this.llstackPair = new Pair(elt, this.llstackPair);
    }

    // Removes & returns the top element (LIFO)
    public String pop(){
        if(this.llstackPair == null){
            throw new NoSuchElementException();
        }

        String topValue = this.llstackPair.head();
        this.llstackPair = this.llstackPair.tail();

        return topValue;

    }

    // Returns top element w/o removal
    public String peek(){
        if(this.llstackPair == null){
            throw new NoSuchElementException();
        }

        return this.llstackPair.head();
    }

    // Returns the # of elts in stack
    public int size(){
        return counter(this.llstackPair);
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
        return this.equals(new LLStack());
    }

}
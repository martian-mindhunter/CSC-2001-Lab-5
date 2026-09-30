import java.util.NoSuchElementException;

class LLStack {

    Pair llstackPair;

    // LLStack base constructor
    public LLStack ( Pair r ){
        this.llstackPair = r;
    }

    public LLStack (){
        this.llstackPair = null;
    }

    // LLStack equals method
    public boolean equals( LLStack other ){

        if (other == null){
            return false;
        }
        if(this == other){
            return true;
        }

        if(this.llstackPair == null || other.llstackPair == null){
            return this.llstackPair == other.llstackPair;
        }
        return this.llstackPair.equals(other.llstackPair);

    }

    // Returns an empty stack w/o arguments
    public static LLStack empty_stack(){
        return new LLStack();
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
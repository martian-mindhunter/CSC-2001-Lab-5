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
    public LLStack empty_stack(){
        return new LLStack(null);
    }

    //
}
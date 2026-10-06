import java.util.Arrays;
import java.util.NoSuchElementException;

class AStack {

    String[] astackList;
    int live;

    public AStack (String[] stringList){
        this.astackList = new String[stringList.length];
        for(int i = 0; i < astackList.length; i++){
            this.astackList[i] = stringList[i];
        }

        this.live = 0;
        for(String elt : stringList){
            if(elt != null){
                this.live++;
            }
        }
    }

    public AStack (){
        this.astackList = new String[]{};
        this.live = 0;
    }

    // AStack equals method
    public boolean equals( AStack other ){
//
//        if (other == null){
//            return false;
//        }
//        if(this == other){
//            return true;
//        }
//
//        if(this.astackList == null || other.astackList == null){
//            return this.astackList == other.astackList;
//        }
//
//        if(this.astackList.length != other.astackList.length){
//            return false;
//        } else {
//            for( int i = 0; i < this.astackList.length; i++ ){
//                if(!(this.astackList[i].equals(other.astackList[i]))){
//                    return false;
//                }
//            }
//        }
//        return true;

        if(this.astackList.length >= other.astackList.length){
            for(int i = 0; i < other.astackList.length; i++){
                if(this.astackList[i] != other.astackList[i]){
                    return false;
                }
            }
            for(int i = other.astackList.length; i < this.astackList.length; i++){
                if(this.astackList[i] != null){
                    return false;
                }
            }
        } else {
            for(int i = 0; i < this.astackList.length; i++){
                if(other.astackList[i].equals(this.astackList[i])){
                    return false;
                }
            }
            for(int i = this.astackList.length; i < other.astackList.length; i++){
                if(other.astackList[i] != null){
                    return false;
                }
            }
        }
        return true;
    }

    // Adds elt to the beginning of stack
    public static AStack empty_stack(){
        return new AStack();
    }

    // Doubling method to allow for inserting/adding
    public void doubleLength() {
        if(this.astackList != null){
            if (this.live == this.astackList.length) {
                int newLength;
                if (this.astackList.length == 0) {
                    newLength = 1;
                } else {
                    newLength = this.astackList.length * 2;
                }
                String[] doubledArray = new String[newLength];

                for (int i = 0; i < this.live; i++) {
                    doubledArray[i] = this.astackList[i];
                }
                this.astackList = doubledArray;
            }
        }
    }

    // Adds elt to the top of the stack
    public void push(String elt){
        String[] hold = this.astackList;
        this.doubleLength();
        for(int i = 1; i < this.live+1; i++){
            this.astackList[i] = hold[i-1];
        }
        if(this.astackList != null){
            this.astackList[0] = elt;
        } else {
            this.astackList = new String[]{elt};
        }
        this.live++;

//        int newLength;
//        if(this.astackList == null){
//
//            String[] longerArray = new String[1];
//
//            this.astackList = longerArray;
//            this.astackList[0] = elt;
//
//        } else {
//
//            newLength = this.astackList.length + 1;
//            String[] longerArray = new String[newLength];
//
//            for(int i = 0; i < this.astackList.length; i++){
//                longerArray[i+1] = this.astackList[i];
//            }
//            this.astackList = longerArray;
//            this.astackList[0] = elt;
//
//        }
    }

    // Removes & returns top element of stack, or returns error
    public String pop(){
        if(this.astackList == null || this.astackList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.astackList[0];
        int newLength = this.astackList.length-1;
        String[] shorterArray = new String[newLength];
        for( int i = 1; i < this.astackList.length; i++ ){
            shorterArray[i-1] = this.astackList[i];
        }
        this.astackList = shorterArray;
        this.live--;
        return hold;
    }

    // Returns top elt w/o changing stack
    public String peek(){
        if(this.astackList == null || this.astackList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.astackList[0];
        return hold;
    }

    // Returns amt of elts in stack
    public int size(){
        if(this.astackList == null){
            throw new NoSuchElementException();
        }
        int stackSize = this.astackList.length;
        return stackSize;
    }

    // Returns if stack is empty
    public boolean is_empty(){
        if(this.astackList == null || this.astackList.length == 0){
            return true;
        } else {
            return false;
        }
    }

}

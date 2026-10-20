import java.util.Arrays;
import java.util.NoSuchElementException;

class AStack {

    String[] astackList;
    int live;

    public AStack (String[] stringList, int liveElts){
        this.astackList = new String[stringList.length];
        for(int i = 0; i < astackList.length; i++){
            this.astackList[i] = stringList[i];
        }

//        this.live = 0;
//        for(String elt : stringList){
//            if(elt != null){
//                this.live++;
//            }
//        }
        this.live = liveElts;
    }

    public AStack (){
        this.astackList = new String[]{};
        this.live = 0;
    }

    // AStack equals method
    public boolean equals( Object obj ){

        if(obj instanceof AStack ){
            AStack other = (AStack)obj;
            return (this.live == other.live) && (Arrays.equals(this.astackList, other.astackList));
        } else {
            return false;
        }
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
        this.doubleLength();
//        for(int i = 1; i < this.live+1; i++){
//            this.astackList[i] = hold[i-1];
//        }
//        if(this.astackList != null){
//            this.astackList[0] = elt;
//        } else {
//            this.astackList = new String[]{elt};
//        }
//        for(int i = 0; i < this.live; i++){
//            this.astackList[i] = hold[i];
//        }
//        if(this.astackList != null){
//            this.astackList[this.live] = elt;
//        } else {
//            this.astackList = new String[]{elt};
//        }
//        this.live++;
        this.astackList[this.live] = elt;
        this.live++;

        // !!! performance killer -- fix to not be O(n) when pushing when
        //     the stack is not doubled !!!

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
        if(this.astackList == null || this.live == 0){
            throw new NoSuchElementException();
        }
//        String hold = this.astackList[this.live-1];
//        int newLength = this.astackList.length-1;
//        String[] shorterArray = new String[newLength];
//        for( int i = 0; i < this.astackList.length-1; i++ ){
//            shorterArray[i] = this.astackList[i];
//        }
//        this.astackList = shorterArray;
//        this.live--;
//        return hold;
        String hold = this.astackList[live-1];
        this.astackList[live-1] = null;
        this.live--;
        return hold;
    }

    // Returns top elt w/o changing stack
    public String peek(){
        if(this.astackList == null || this.astackList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.astackList[this.live-1];
        return hold;
    }

    // Returns amt of elts in stack
    public int size(){
        if(this.astackList == null){
            throw new NoSuchElementException();
        }
//        int stackSize = this.astackList.length;
//        return stackSize;
        return this.live;
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

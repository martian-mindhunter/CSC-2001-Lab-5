import java.util.NoSuchElementException;

public class AQueue {

    String[] aqueueList;
    int live;

    public AQueue(String[] stringList){
        this.aqueueList = new String[stringList.length];
        for( int i = 0; i < aqueueList.length; i++ ){
            this.aqueueList[i] = stringList[i];
        }
        this.live = 0;
        for(String elt : stringList){
            if(elt != null){
                this.live++;
            }
        }
    }

    public AQueue(){
        this.aqueueList = new String[]{};
        this.live = 0;
    }

    // AStack equals method
    public boolean equals( AQueue other ){

//        if (other == null){
//            return false;
//        }
//        if(this == other){
//            return true;
//        }
//
//        if(this.aqueueList == null || other.aqueueList == null){
//            return this.aqueueList == other.aqueueList;
//        }
//
//        if(this.aqueueList.length != other.aqueueList.length){
//            return false;
//        } else {
//            for( int i = 0; i < this.aqueueList.length; i++ ){
//                if(!(this.aqueueList[i].equals(other.aqueueList[i]))){
//                    return false;
//                }
//            }
//        }
//        return true;
        if(this.aqueueList.length >= other.aqueueList.length){
            for(int i = 0; i < other.aqueueList.length; i++){
                if(this.aqueueList[i] != other.aqueueList[i]){
                    return false;
                }
            }
            for(int i = other.aqueueList.length; i < this.aqueueList.length; i++){
                if(this.aqueueList[i] != null){
                    return false;
                }
            }
        } else {
            for(int i = 0; i < this.aqueueList.length; i++){
                if(other.aqueueList[i].equals(this.aqueueList[i])){
                    return false;
                }
            }
            for(int i = this.aqueueList.length; i < other.aqueueList.length; i++){
                if(other.aqueueList[i] != null){
                    return false;
                }
            }
        }
        return true;

    }

    // Adds elt to the beginning of stack
    public static AQueue empty_queue(){
        return new AQueue();
    }

    // Doubling method to allow for inserting/adding
    public void doubleLength() {
        if(this.aqueueList != null){
            if (this.live == this.aqueueList.length) {
                int newLength;
                if (this.aqueueList.length == 0) {
                    newLength = 1;
                } else {
                    newLength = this.aqueueList.length * 2;
                }
                String[] doubledArray = new String[newLength];

                for (int i = 0; i < this.live; i++) {
                    doubledArray[i] = this.aqueueList[i];
                }
                this.aqueueList = doubledArray;
            }
        }
    }

    // Adds elt to the end of the queue
    public void enqueue(String elt){
        String[] hold = this.aqueueList;
        this.doubleLength();
        for(int i = 0; i < this.live; i++){
            this.aqueueList[i] = hold[i];
        }
        if(this.aqueueList != null){
            this.aqueueList[live] = elt;
        } else {
            this.aqueueList = new String[]{elt};
        }
        this.live++;
//        int newLength;
//        if(this.aqueueList == null){
//
//            String[] longerArray = new String[1];
//
//            this.aqueueList = longerArray;
//            this.aqueueList[0] = elt;
//
//        } else {
//
//            newLength = this.aqueueList.length + 1;
//            String[] longerArray = new String[newLength];
//
//            for(int i = 0; i < this.aqueueList.length; i++){
//                longerArray[i] = this.aqueueList[i];
//            }
//            longerArray[longerArray.length-1] = elt;
//            this.aqueueList = longerArray;
//
//        }
    }

    // Removes & returns top element of stack, or returns error
    public String dequeue(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.aqueueList[0];
        int newLength = this.aqueueList.length-1;
        String[] shorterArray = new String[newLength];
        for( int i = 1; i < this.aqueueList.length; i++ ){
            shorterArray[i-1] = this.aqueueList[i];
        }
        this.aqueueList = shorterArray;
        this.live--;
        return hold;
    }

    // Returns top elt w/o changing stack
    public String peek(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.aqueueList[0];
        return hold;
    }

    // Returns amt of elts in stack
    public int size(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
        int stackSize = this.aqueueList.length;
        return stackSize;
    }

    // Returns if stack is empty
    public boolean is_empty(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            return true;
        } else {
            return false;
        }
    }

}

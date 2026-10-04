import java.util.NoSuchElementException;

public class AQueue {


    String[] aqueueList;

    public AQueue(String[] stringList){
        this.aqueueList = stringList;
    }

    public AQueue(){
        this.aqueueList = null;
    }

    // AStack equals method
    public boolean equals( AQueue other ){

        if (other == null){
            return false;
        }
        if(this == other){
            return true;
        }

        if(this.aqueueList == null || other.aqueueList == null){
            return this.aqueueList == other.aqueueList;
        }

        if(this.aqueueList.length != other.aqueueList.length){
            return false;
        } else {
            for( int i = 0; i < this.aqueueList.length; i++ ){
                if(!(this.aqueueList[i].equals(other.aqueueList[i]))){
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

    // Adds elt to the end of the queue
    public void enqueue(String elt){
        int newLength;
        if(this.aqueueList == null){

            String[] longerArray = new String[1];

            this.aqueueList = longerArray;
            this.aqueueList[0] = elt;

        } else {

            newLength = this.aqueueList.length + 1;
            String[] longerArray = new String[newLength];

            for(int i = 0; i < this.aqueueList.length; i++){
                longerArray[i] = this.aqueueList[i];
            }
            longerArray[longerArray.length-1] = elt;
            this.aqueueList = longerArray;

        }
    }

    // Removes & returns top element of stack, or returns error
    public String dequeue(){
        if(this.aqueueList == null){
            throw new NoSuchElementException();
        }
        String hold = this.aqueueList[0];
        int newLength = this.aqueueList.length-1;
        String[] shorterArray = new String[newLength];
        for( int i = 1; i < this.aqueueList.length; i++ ){
            shorterArray[i-1] = this.aqueueList[i];
        }
        this.aqueueList = shorterArray;
        return hold;
    }

    // Returns top elt w/o changing stack
    public String peek(){
        if(this.aqueueList == null){
            throw new NoSuchElementException();
        }
        String hold = this.aqueueList[0];
        return hold;
    }

    // Returns amt of elts in stack
    public int size(){
        if(this.aqueueList == null){
            throw new NoSuchElementException();
        }
        int stackSize = this.aqueueList.length;
        return stackSize;
    }

    // Returns if stack is empty
    public boolean is_empty(){
        if(this.aqueueList == null){
            return true;
        } else {
            return false;
        }
    }

}

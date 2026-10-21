import java.util.Arrays;
import java.util.NoSuchElementException;

public class AQueue implements MyQueue{

    String[] aqueueList;
    int live;
    int frontIndex;
    int capacity;

//    public AQueue(String[] stringList, int liveElts){
//        this.aqueueList = new String[stringList.length];
//        for( int i = 0; i < aqueueList.length; i++ ){
//            this.aqueueList[i] = stringList[i];
//        }
////        this.live = 0;
////        for(String elt : stringList){
////            if(elt != null){
////                this.live++;
////            }
////        }
//        this.live = liveElts;
//    }

    public AQueue(String[] stringList, int live, int frontIndex, int capacity){
        this.aqueueList = new String[capacity];
        for(int i = 0; i < stringList.length; i++){
            this.aqueueList[i] = stringList[i];
        }
        this.live = live;
        this.capacity = capacity;
        this.frontIndex = frontIndex;
    }

    public AQueue(){
        this.aqueueList = new String[]{};
        this.live = 0;
    }

    // AStack equals method
    public boolean equals( Object obj ){

        if(obj instanceof AQueue ){
            AQueue other = (AQueue)obj;
            return (this.live == other.live)
                    && this.frontIndex == other.frontIndex
                    && this.capacity == other.capacity
                    && (Arrays.equals(this.aqueueList, other.aqueueList));
        } else {
            return false;
        }

    }

    // Adds elt to the beginning of stack
    public static AQueue empty_queue(int capacity){
        return new AQueue(new String[capacity], 0, 0, capacity);
    }

    // Doubling method to allow for inserting/adding
//    public void doubleLength() {
//        if(this.aqueueList != null){
//            if (this.live == this.aqueueList.length) {
//                int newLength;
//                if (this.aqueueList.length == 0) {
//                    newLength = 1;
//                } else {
//                    newLength = this.aqueueList.length * 2;
//                }
//                String[] doubledArray = new String[newLength];
//
//                for (int i = 0; i < this.live; i++) {
//                    doubledArray[i] = this.aqueueList[i];
//                }
//                this.aqueueList = doubledArray;
//            }
//        }
//    }

    // Adds elt to the end of the queue
    public void enqueue(String elt){

//        this.doubleLength();
//        this.aqueueList[this.live] = elt;
//        this.live++;

        if(this.live == this.capacity){
            throw new IllegalStateException("Queue is full");
        }
        int tailIndex = (this.frontIndex + this.live) % this.capacity;
        this.aqueueList[tailIndex] = elt;
        this.live++;

    }

    // Removes & returns top element of stack, or returns error
    public String dequeue(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
//        String hold = this.aqueueList[0];
//        int newLength = this.aqueueList.length-1;
//        String[] shorterArray = new String[newLength];
//        for( int i = 1; i < this.aqueueList.length; i++ ){
//            shorterArray[i-1] = this.aqueueList[i];
//        }
//        this.aqueueList = shorterArray;
//        this.live--;
//        return hold;
        String hold = this.aqueueList[this.frontIndex];
        this.aqueueList[this.frontIndex] = null;
        this.frontIndex = (this.frontIndex + 1) % capacity;
        this.live--;
        return hold;
    }

    // Returns top elt w/o changing stack
    public String peek(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
        String hold = this.aqueueList[frontIndex];
        return hold;
    }

    // Returns amt of elts in stack
    public int size(){
        if(this.aqueueList == null || this.aqueueList.length == 0){
            throw new NoSuchElementException();
        }
        return this.live;
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

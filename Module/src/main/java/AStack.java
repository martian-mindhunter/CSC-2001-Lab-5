import java.util.Arrays;
import java.util.NoSuchElementException;

class AStack {

    String[] astackList;

    public AStack (String[] stringList){
        this.astackList = stringList;
    }

    public AStack (){
        this.astackList = null;
    }

    // AStack equals method
    public boolean equals( AStack other ){

        if (other == null){
            return false;
        }
        if(this == other){
            return true;
        }

        if(this.astackList == null || other.astackList == null){
            return this.astackList == other.astackList;
        }

        if(this.astackList.length != other.astackList.length){
            return false;
        } else {
            for( int i = 0; i < this.astackList.length; i++ ){
                if(!(this.astackList[i].equals(other.astackList[i]))){
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

    // Adds elt to the top of the stack
    public void push(String elt){
//        String[] hold = this.astackList;
////        this.doubleLength();
//        for(int i = 1; i < this.astackList.length; i++){
//            this.astackList[i] = hold[i-1];
//        }
        int newLength;
        if(this.astackList == null){

            String[] longerArray = new String[1];

            this.astackList = longerArray;
            this.astackList[0] = elt;

        } else {

            newLength = this.astackList.length + 1;
            String[] longerArray = new String[newLength];

            for(int i = 0; i < this.astackList.length; i++){
                longerArray[i+1] = this.astackList[i];
            }
            this.astackList = longerArray;
            this.astackList[0] = elt;

        }
    }

}

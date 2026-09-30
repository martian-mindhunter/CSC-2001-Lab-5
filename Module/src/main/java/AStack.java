import java.util.Arrays;
import java.util.NoSuchElementException;

class AStack {

    String[] astackList;

    public AStack (String[] stringList){
        this.astackList = stringList;
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


}

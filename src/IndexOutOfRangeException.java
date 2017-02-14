public class IndexOutOfRangeException extends Exception
{
    public IndexOutOfRangeException(){
        super("The specified index is outside of the valid range");
    }

    public IndexOutOfRangeException(String message){
        super(message);
    }
}

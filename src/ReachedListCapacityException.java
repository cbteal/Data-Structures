

public class ReachedListCapacityException extends Exception
{
    public ReachedListCapacityException(){
        super("The list has reached Capacity");
    }

    public ReachedListCapacityException(String message){
        super(message);
    }
}
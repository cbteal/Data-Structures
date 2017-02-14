
/**
 * The Stack class is a data structure based on the abstract data
 * type list. The way that it functions is first in first out, similar
 * to a stack of paper. 
 * The Stack class is infinite in capacity and 
 * will automatically resize itself to account for more data. It's
 * similar to an array list, however the contents can't be accessed
 * randomly. Data can only be pushed and pulled from the 'top' of the
 * list.
 * 
 * @author Connor Teal
 * @version 1.0
 */
public class Stack
{
    private Object[] list;
    private int numElements;
    
    //Class Invariant: Can't have a negative number of elements

    /**
     * No Argument Constructor
     * 
     * @param None
     * @return Object an Instance of the Stack Object
     */
    public Stack(){
        this.list = new Object[20];
        this.numElements = 0;
    }

     /**
     * Copy Constructor
     * 
     * @param that Stack Object to be copied
     * @return Object Copy of the input stack object
     */
    public Stack(Stack that){
        this.list = that.list.clone();
        this.numElements = that.numElements;
    }

     /**
     * Capacity Declared Constructor
     * 
     * @param capacity declares the initial capacity of the list
     * @return Object an Instance of the Stack Object
     */
    public Stack(int capacity){
        try{
            if(capacity <= 0){
                throw new Exception("Can't have negative capacity. Closing!");
            }
            this.list = new Object[capacity];
            this.numElements = 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * push will add an element to the top of the stack
     * 
     * @param object object to be pushed into the stack
     * @return Nothing
     * @exception ReachedListCapacityException when capacity is reached
     */
    public void push(Object object){
        boolean done = false;
        while(!done){
            try{
                this.isFull();
                this.list[numElements++] = object;
                done = true;
            }catch(ReachedListCapacityException e){
                this.list = this.doubleCap(this.list);
            }
        }
    }

    /**
     * pop will remove the element on the top of the stack
     * 
     * @param None
     * @return Object returns the object from the top of the list
     */
    public Object pop(){
        return new Stack(this).list[--numElements];
    }

    /**
     * size returns the number of elements in the stack
     * 
     * @param None
     * @return integer the number of elements in the stack
     */
    public int size(){
        return this.numElements;
    }

    /**
     * toString will return the items in the stack in top down
     * order; they're separated by commas.
     * 
     * @param None
     * @return String the contents of the list in top down order
     */
    @Override
    public String toString(){
        String retVal = "";
        for(int i = numElements; i > 0; i--){
            retVal += this.list[i-1] + ",";
        }

        return retVal;
    }

    /**
     * isEmpty will check to see if there are any items in the stack
     * 
     * @param None
     * @return Nothing
     */
    public boolean isEmpty(){
        if(numElements == 0){
            return true;
        }
        return false;
    }

    /**
     * doubleCap is a private helper method that doubles the capacity
     * of a list.
     * 
     * @param Array the object list
     * @return Array object list with twice the capacity
     */
    private Object[] doubleCap(Object[] list){
        Object[] retVal = new Object[list.length * 2];
        for(int i = 0; i < list.length; i++){
            retVal[i] = list[i];
        }
        return retVal;
    }

    /**
     * isFull is a helper method that determines if the capacity of
     * a list has been fully utilized.
     * 
     * @param None
     * @return Boolean true if full
     */
    private boolean isFull() throws ReachedListCapacityException{
        if(this.numElements == this.list.length){
            throw new ReachedListCapacityException();
        }
        return false;
    } 

    /**
     * equals will check to see if two lists are equal. In this case
     * equal means same size and same values at the same indexes.
     * 
     * @param Object the stack to compare to
     * @return Boolean true if equal
     */
    public boolean equals(Object that){
        Stack temp = (Stack) that;
        if(this.size() != temp.size()){
            return false;
        }
        for(int i = 0; i < numElements; i++){
            if(this.list[i] != temp.list[i]){
                return false;
            }
        }
        return true;
    }
    
    /**
     * peek will return the value of the first Element in the list
     * 
     * @param None
     * @return Object at the top of the stack
     */
    public Object peek(){
        Object retVal = null;
        //If the list is empty close program. Otherwise set retVal equal
        //to the first element
        try{
            if(isEmpty()){
                throw new Exception();
            }
            retVal = new Stack(this).list[0];
        }catch(Exception e)
        {
            System.exit(0);
        }

        return retVal;
    }
}

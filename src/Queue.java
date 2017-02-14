
/**
 * The Queue class is meant to represent a Data Structure. It's a
 * variation or implementation of the Abstract Data Type list. The
 * way in which the list is accessed is through the 'head' (front)
 * to dequeue (remove) or through the 'tail' to enqueue (add). This
 * means that the first data in is the first to come out (FIFO).
 * The Queue is dynamic in size, and has infinite capacity. It will
 * adjust it's size to accomodate for added data.
 * 
 * @author Connor Teal
 * @version 1.0
 */
public class Queue
{
    private Object[] list; 
    private int numElements;

    //Class Invariant: Can't have negative size

    /**
     * No Argument Constructor
     * 
     * @param None
     * @return Nothing
     */
    public Queue(){
        this.list = new Object[20];
        this.numElements = 0;
    }

    /**
     * Copy Constructor
     * 
     * @param Queue object to be copied
     * @return Queue a copy of the queue
     */
    public Queue(Queue that){
        this.numElements = that.numElements;
        this.list = that.list.clone();
    }

    /**
     * Constructor to specify starting capacity
     * 
     * @param capacity sets the starting capacity of the Queue
     * @return Queue with capacity
     * @exception when given negative capacity
     */
    public Queue(int capacity){
        try{
            if(capacity <= 0){
                throw new Exception("Capacity must be greater than or equal to 1.");
            }
            this.list = new Object[capacity];
            this.numElements = 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Enqueue adds an object to the tail (back) of the list.
     * 
     * @param Object item to add to the Queue
     * @return Nothing
     */
    public void enqueue(Object object){
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
     * Dequeue removes an item from the head (front) of the list.
     * 
     * @param None
     * @return Object the object from the front of the list
     */
    public Object dequeue(){
        Object retVal = null;

        //Assign first element (first in) to return value
        try{
            if(this.numElements == 0){
                throw new Exception("Can't Dequeue -- List is empty");
            }
            retVal = new Queue(this).list[0];
            this.shiftLeft(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return retVal;
    }

    /**
     * shiftLeft shifts the items left from a given starting index
     * 
     * @param int index is the starting point of the shift
     * @return Nothing
     */
    private void shiftLeft(int index){

        try{
            isIndexInRange(index);
            //For the numberOfElements shift items to the left
            //Assign new n value to current n+1 value
            for(int i = index; i < numElements - 1; i++){
                this.list[i] = this.list[i + 1];
            }

            //Decrement to account for new number of Elements
            //Assign old tail to null
            this.list[--numElements] = null;
        }
        catch(IndexOutOfRangeException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * toString will return the items in the queue in first to last in
     * order; they're separated by commas.
     * 
     * @param None
     * @return String the values of the Queue in first to last order
     */
    @Override
    public String toString(){
        String retVal = "";

        for(int i = 0; i < numElements; i++){
            retVal += this.list[i] + ",";
        }

        return retVal;
    }

    /**
     * isEmpty will check to see if there are any items in the queue
     * 
     * @param None
     * @return Boolean true if empty
     */
    public boolean isEmpty(){
        if(numElements == 0){
            return true;
        }
        return false;
    }

    /**
     * peek will return the value of the first Element in the list
     * 
     * @param None
     * @return Object
     */
    public Object peek(){
        Object retVal = null;
        //If the list is empty close program. Otherwise set retVal equal
        //to the first element
        try{
            if(isEmpty()){
                throw new Exception();
            }
            retVal = new Queue(this).list[0];
        }catch(Exception e)
        {
            System.exit(0);
        }

        return retVal;
    }

    /**
     * size returns the number of objects in a Queue
     * 
     * @param none
     * @return int size number of elements in the Queue
     */
    public int size(){
        return this.numElements;
    }

    /**
     * doubleCap is a private helper method that doubles the capacity
     * of a list.
     * 
     * @param Array list of 
     * @return Array list of double capacity
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
     * @return Boolean isFull returns true if full
     * @throws ReachedListCapacityException if capacity reached
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
     * Takes Object
     * Returns Boolean (True if Equal)
     */
    public boolean equals(Object that){
        Queue temp = (Queue) that;
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
     * isIndexInRange checks to see if the target index is within the
     * range of declared elements in the list
     * 
     * @param index takes an integer value for a target index
     * @return true if in range
     * @throws IndexOutOfRangeException on index out of range
     */
    private boolean isIndexInRange(int index) throws IndexOutOfRangeException{
        if(index > numElements || index < 0){
            throw new IndexOutOfRangeException();
        }
        return true;
    }
}

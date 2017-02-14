/*
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * 
 * 
 */

public class ArrayBasedDataStructuresDriver {

    public static void main(String[] args) {
        // stackTests();
        //queueTests();
        arrayListTests();
    }

    @SuppressWarnings("unused")
    private static void arrayListTests() {
    //todo: make more tests here
    ArrayList a = new ArrayList();
    ArrayList b = new ArrayList(1);
    ArrayList c = new ArrayList();

    //These will cause the program to crash
    //ArrayList d = new ArrayList(0);
    //ArrayList e = new ArrayList(-5);

    System.out.println("ArrayList Tests \n\n");
    //Test capacity adjustment
    assert c.size() == 0: "Starting Size Not 0";
    for(int i = 0; i < 15; i++){
    c.add(new Integer(i));
    }
    assert c.size() == 15: "Final Size Not Correct";

    System.out.println(c.toString());

    for(int i = 15; i > 0; i--){
    c.remove(i);
    }
    assert c.size() == 0;
    assert c.isEmpty() : "isEmpty is broken";

    //Test Equallity
    a.add('B');
    a.add('a');
    a.add('t');

    b.add('B');
    b.insert('a', 1);
    b.insert('t', 2);

    assert(a.equals(b)) : "Equals is broken";
    assert(b.equals(a)) : "Equals is broken";

    while(a.isEmpty() == false) {
    System.out.println(a.remove(0));
    }

    //Testing size and is empty
    assert a.size() == 0 : "a isn't empty";
    assert a.isEmpty() : "a isn't empty";

    //Testing get method
    assert (char) b.get(0) == 'B' : "get isn't working";
    assert (char) b.get(1) == 'a' : "get isn't working";
    assert (char) b.get(2) == 't' : "get isn't working";

    assert b.size() == 3 : "get isn't working";

    //Testing Clear
    b.clear();
    assert b.size() == 0 : "b isn't empty";
    assert b.isEmpty() : "b isn't empty";

    }
     
    @SuppressWarnings("unused")
    private static void queueTests() {
    //todo: make more tests here
    Queue a = new Queue();
    Queue b = new Queue(1);
    Queue c = new Queue(2);

    assert a.size() == 0 : "Size should be zero";
    assert c.size() == 0 : "Size should be zero";

    //Uncomment To Test Exceptions
    //Queue d = new Queue(0);

    Queue e = new Queue(1);
    e.dequeue();

    assert b.size() == 0 : "Size should be zero";
    System.out.println("Before Adding: " + b.toString());
    for(int i = 0; i < 40; i++){
    b.enqueue(i);
    }
    System.out.println("After Adding: " + b.toString());
    System.out.println("\n");
    assert b.size() == 40 : "Size should be 40";

    c.enqueue('B');
    c.enqueue('a');

    a.enqueue('B');
    a.enqueue('a');
    a.enqueue('t');

    assert c.equals(a) == false : "c shouldn't equal a";

    c.enqueue('t');

    assert c.equals(a) : "c should equal a";
    assert a.equals(c) : "a should equal c";

    System.out.println(a.toString());
    System.out.println(a.peek());

    assert (char) a.peek() == 'B' : "Peek should show B";

    while(a.isEmpty() == false) {
    System.out.println(a.dequeue());
    }

    }
    
    @SuppressWarnings("unused")
    private static void stackTests() {
        //todo: make more tests here
        Stack a = new Stack();
        Stack b = new Stack(1);
        Stack c = new Stack();
        
        //Will throw an exception
        //Stack d = new Stack(0)
        
        assert a.isEmpty() : "a should be empty";
        assert b.isEmpty() : "b should be empty";
        assert c.isEmpty() : "c should be empty";
        assert a.size() == 0 : "Size should be zero";
        assert b.size() == 0 : "Size should be zero";
        assert c.size() == 0 : "Size should be zero";

        b.push('B');
        b.push('a');

        b.push('t');
        
        assert b.equals(a) == false : "b shouldn't equal a";
        assert b.size() == 3 : "b size should be 3";
        assert (char) b.peek() == 'B' : "peek should equal B";
        
        a.push('B');
        assert a.size() == 1 : "a size should be 1";
        a.push('a');
        a.push('t');
        
        assert a.size() == 3 : "a size should be 3";
        assert a.equals(b) : "a should equal b";
        assert b.equals(a) : "b should equal a";
        
        a.pop();
        assert a.size() == 2 : "a should be size 2";
        a.pop();
        a.pop();
        assert a.isEmpty() : "a should be empty";

        System.out.println(b.toString());
        while(b.isEmpty() == false) {
            System.out.println(b.pop());
        }
    }
}


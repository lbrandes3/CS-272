import java.util.HashMap;
import java.util.Map;

public class DoublyLinkedListDummy {
    private DIntNode dummyHead = new DIntNode();
    private DIntNode dummyTail = new DIntNode();
    private int length;

    // constructor
    // O(1) time, constant
    public DoublyLinkedListDummy() {
        dummyHead.setNext(dummyTail);
        dummyTail.setPrev(dummyHead);
        length = 0;
    }

    // get head
    // returns head node
    // O(1) time, constant
    public DIntNode getHead() {
        if (dummyHead.getNext() == dummyTail) { return null; }
        return dummyHead.getNext();
    }

    // get tail
    // returns tail node
    // O(1) time, constant
    public DIntNode getTail() {
        if (dummyHead.getNext() == dummyTail) { return null; }
        return dummyTail.getPrev();
    }

    // sets head
    // parameter: node to make head
    // O(1) time, constant
    public void setHead(DIntNode node) {
        node.setNext(dummyHead.getNext());
        node.setPrev(dummyHead);
        dummyHead.setNext(node);
        node.getNext().setPrev(node);
        length++;
    }

    // sets tail
    // parameter: node to make tail
    // O(1) time, constant
    public void setTail(DIntNode node) {
        node.setNext(dummyTail);
        node.setPrev(dummyTail.getPrev());
        dummyTail.setPrev(node);
        node.getPrev().setNext(node);
        length++;
    }

    // string representation of the List
    // returns string representation of the List
    // O(n) time, where n is the number of elements. Each element gets added to s twice then the string is built
    public String toString() {
        if (dummyHead.getNext() == dummyTail) { return ""; }

        // init var
        StringBuilder s = new StringBuilder("(Forward)  ");
        DIntNode temp = dummyHead.getNext();

        // adds first node
        s.append(temp.getData());
        temp = temp.getNext();

        // adds every other node
        while (temp != dummyTail) {
            s.append("<->");
            s.append(temp.getData());
            temp = temp.getNext();
        }
        // start line 2
        s.append("\n(Backward) ");
        temp = temp.getPrev();

        // add last node
        s.append(temp.getData());
        temp = temp.getPrev();

        while (temp != dummyHead) {
            s.append("<->");
            s.append(temp.getData());
            temp = temp.getPrev();
        }

        return s.toString();
    }

    // adds a value to the end of the list
    // param: element to make the last node
    // O(1) time, all operations are constant time
    public void addEnd(int element) {
        DIntNode temp = new DIntNode(element);
        temp.setPrev(dummyTail.getPrev());
        temp.setNext(dummyTail);
        dummyTail.getPrev().setNext(temp);
        dummyTail.setPrev(temp);
        length++;
    }

    // removes the first value in the array
    // O(1) time, all operations are constant time
    public void removeFromHead() {
        dummyHead.setNext(dummyHead.getNext().getNext());
        dummyHead.getNext().setPrev(dummyHead);
        length--;
    }

    // counts the occurrences of e in the list
    // parameter: val to check for
    // return: number of occurrences
    // O(n) time, where n is the number of elements. Every value must be checked
    public int countOccurrence(int e) {
        if (dummyHead.getNext() == dummyTail) { return 0; }

        DIntNode temp = dummyHead.getNext();
        int numOcc = 0;

        while (temp != dummyTail) {
            if (temp.getData() == e) {
                numOcc++;
            }
            temp = temp.getNext();
        }
        return numOcc;
    }

    // removes all nodes with data e from the list
    // param: value to remove
    // return: whether a value was removed
    // O(n) time, where n is the number of elements. Every value must be checked
    public boolean removeAll(int e) {
        if (dummyHead.getNext() == dummyTail) { return false; }

        boolean b = false;
        DIntNode temp = dummyHead.getNext();

        while (temp != dummyTail) {
            if (temp.getData() == e) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                b = true;
                length--;
            }
            temp = temp.getNext();
        }
        return b;
    }

    // finds part of the list
    // param: where to start and end
    // return: sublist
    // preconditions:   beginIdx >= 0
    //                  endIdx > len
    //                  beginIdx > endIdx
    // O(n) time, where n = endIdx. Every value up to endIdx must be checked
    public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
        if (beginIdx < 0)       { throw new NullPointerException("start index is too small"); }
        if (endIdx > length)    { throw new NullPointerException("end index is too large"); }
        if (beginIdx > endIdx)  { throw new NullPointerException("start index is larger than end index"); }
        if (beginIdx == endIdx) { return new DoublyLinkedListDummy(); }

        DIntNode temp = dummyHead.getNext();
        DoublyLinkedListDummy ret = new DoublyLinkedListDummy();
        int i;

        for (i = 0; i < beginIdx; i++) {
            temp = temp.getNext();
        }
        for (; i < endIdx; i++) {
            ret.addEnd(temp.getData());
            temp = temp.getNext();
        }
        return ret;
    }

    // prints the number of times each value occurs in the list
    // O(kn) time, where k is the number of unique values and n is the number of nodes.
    // Using a Hashmap, you need to check every value in the list and then print once for each unique data value.

    public void printStatistics() {
        if (dummyHead.getNext() == dummyTail) { return; }

        HashMap<Integer, Integer> values = new HashMap<>();
        DIntNode temp = dummyHead.getNext();
        
        while (temp != dummyTail) {
            if (values.containsKey(temp.getData())) {
                values.put(temp.getData(), values.get(temp.getData()) + 1);
            }
            values.put(temp.getData(), 1);
            temp = temp.getNext();
        }
        System.out.println("number occurrence");
        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            System.out.println(entry.getKey() + "\t\t  " + entry.getValue());
        }
    }

    // main
    public static void main(String[] args) {
        DoublyLinkedListDummy d1 = new DoublyLinkedListDummy();
        d1.addEnd(5);
        d1.addEnd(7);
        d1.addEnd(3);
        d1.addEnd(2);
        d1.addEnd(1);
        d1.addEnd(25);
        d1.addEnd(75);
        System.out.println(d1);

        DIntNode temp = new DIntNode(63);
        d1.setHead(temp);
        DIntNode temp1 = new DIntNode(4);
        d1.setTail(temp1);
        System.out.println(d1);

        System.out.println(d1.getHead());
        System.out.println(d1.getTail());

        d1.removeFromHead();
        System.out.println(d1);

        System.out.println(d1.countOccurrence(3));
        System.out.println(d1.countOccurrence(9));

        d1.removeAll(1);
        System.out.println(d1);

        System.out.println(d1.subList(3, 7));
        d1.printStatistics();
    }
}

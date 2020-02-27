// Luke Brandes
// singly linked list containing ints

import java.util.ArrayList;
import java.util.List;

public class IntNode {
    private int data;
    private IntNode next;

    // default constructor
    public IntNode() {
        next = null;
        data = 0;
    }

    // constructor with variables
    public IntNode(int data, IntNode link) {
        this.data = data;
        this.next = link;
    }

    public int getData() { return data; }

    public IntNode getNext() { return next; }

    public void setData(int data) { this.data = data; }

    public void setNext(IntNode next) { this.next = next; }

    // returns this.data -> next.data -> etc
    public String toString() {
        if (next != null) {
            return data + "->" + next;
        } else {
            return data + "";
        }
    }

    // adds a node with given data after this node, its next node is the node of this node
    public void addNodeAfterThis(int newData) {
        next = new IntNode(newData, next);
    }

    // replaces this node's next with next's next
    public void removeNodeAfterThis() {
        next = next.getNext();
    }

    // recursively determines length
    public int length() {
        if (next != null) {
            return 1 + next.length();
        } else {
            return 1;
        }
    }

    // recursively determines whether list contains n
    public boolean contains(int n) {
        if (next == null) {
            return data == n;
        }
        if (data == n) {
            return true;
        }
        return next.contains(n);
    }

    // recursively adds to the last node
    public void addToEnd(int newData) {
        if (next == null) {
            next = new IntNode(newData, null);
        } else {
            next.addToEnd(newData);
        }
    }

    // recursively counts the number of odds
    public int numOdds() {
        if (next == null) {
            return data % 2;
        }
        return data % 2 + next.numOdds();
    }

    // recursively sums the next num values
    public int sumLast(int num) {
        if (num == 1 || next == null) { return data; }
        num--;
        return data + next.sumLast(num);
    }

    // recursively copies odd values
    public IntNode copyOdd() {
        if (next == null) {
            if (data % 2 == 1) {
                return new IntNode(data, null);
            }
            return null;
        }
        if (data % 2 == 1) {
            return new IntNode(data, next.copyOdd());
        }
        return next.copyOdd();
    }

    // recursively removes all values with data e
    public IntNode removeAll(int e) {
        if (next == null) {
            if (data == e) {
                return null;
            } else {
                return this;
            }
        }
        if (data == e) {
            return next.removeAll(e);
        } else {
            next = next.removeAll(e);
            return this;
        }
    }

    // recursively reverses the list
    public IntNode reverse() {
        if (next == null) {
            return this;
        }
        next = next.reverse();
        next.addToEnd(data);
        return next;
    }

    // recursively finds whether cyclic
    public boolean isCyclic(List<IntNode> heads) {
        if (next == null) { return false; }
        if (heads.contains(next)) { return true; }
        heads.add(this);
        return next.isCyclic(heads);
    }

    // returns length of given node
    public static int listLength(IntNode head) {
        if (head != null) { return head.length(); }
        return 0;
    }

    // returns whether given node contains data
    public static boolean search(IntNode head, int data) {
        if (head != null) { return head.contains(data); }
        return false;
    }

    // calls numOdds to find numOdd
    public static int listOddNumber(IntNode head) {
        if (head == null) { return 0; }
        return head.numOdds();
    }

    // calls sum last with num
    public static int sumLast(IntNode head, int num) {
        if (head == null) { return 0; }
        return head.sumLast(num);
    }

    // copies the odd values into a list
    public static IntNode copyOdd(IntNode head) {
        if (head == null) { return null; }
        return head.copyOdd();
    }

    // calls removeAll to remove all e values
    public static IntNode removeAll(IntNode head, int e) {
        if (head == null) { return null; }
        return head.removeAll(e);
    }

    // calls reverse to reverse the array
    public static IntNode reverse(IntNode head) {
        if (head == null) { return null; }
        return head.reverse();
    }

    // calls isCyclic
    public static boolean hasCycle(IntNode head) {
        if (head == null) { return false; }
        return head.isCyclic(new ArrayList<IntNode>());
    }
}

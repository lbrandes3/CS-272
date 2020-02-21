// Luke Brandes
// singly linked list containing ints

// TODO comment and implement IntNodeAdvancedTest

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

    public void addToEnd(int newData) {
        if (next == null) {
            next = new IntNode(newData, null);
        } else {
            next.addToEnd(newData);
        }
    }

    public int numOdds() {
        if (next == null) {
            return data % 2;
        }
        return data % 2 + next.numOdds();
    }

    public int sumLast(int num) {
        if (num == 0 || next == null) { return data; }
        return data + next.sumLast(num--);
    }

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

    public IntNode reverse() {
        if (next == null) {
            return this;
        }
        next = next.reverse();
        next.addToEnd(data);
        return next;
    }

    public boolean isCyclic(IntNode head) {
        if (next == null) { return false; }
        if (next == head) { return true; }
        return isCyclic(head);
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

    public static int listOddNumber(IntNode head) {
        if (head == null) { return 0; }
        return head.numOdds();
    }

    public static int sumLast(IntNode head, int num) {
        if (head == null) { return 0; }
        return head.sumLast(num);
    }

    public static IntNode copyOdd(IntNode head) {
        if (head == null) { return null; }
        return head.copyOdd();
    }

    public static IntNode removeAll(IntNode head, int e) {
        if (head == null) { return null; }
        return head.removeAll(e);
    }

    public static IntNode reverse(IntNode head) {
        if (head == null) { return null; }
        return head.reverse();
    }

    public static boolean hasCycle(IntNode head) {
        if (head == null) { return false; }
        return head.isCyclic(head);
    }
}

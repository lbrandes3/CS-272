// Luke Brandes
// IntNode tester

public class IntNodeTest {
    public static void main(String[] args) {
        // test toString and default constructor
        IntNode in1 = new IntNode();
        System.out.println(in1);
        System.out.println();

        // tests data constructor and setter
        IntNode in2 = new IntNode(1, in1);
        in1.setData(4);
        System.out.println(in2);
        System.out.println();

        // tests addNodeAfterThis
        in2.addNodeAfterThis(4);
        System.out.println(in2);
        System.out.println();

        // tests removeNodeAfterThis
        in2.removeNodeAfterThis();
        System.out.println(in2);
        System.out.println();

        // tests length
        System.out.println(in2.length());
        System.out.println();

        // tests contains
        System.out.println(in2.contains(6));
        System.out.println(in2.contains(1));
        System.out.println(in2.contains(4));
    }
}

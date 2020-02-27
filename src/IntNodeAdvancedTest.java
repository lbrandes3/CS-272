import java.util.ArrayList;

public class IntNodeAdvancedTest {
    public static void main(String[] args) {
        // tests constructors
        System.out.println("constructors");
        IntNode fir = new IntNode();
        IntNode sec = new IntNode(1, fir);
        fir.setData(2);
        System.out.println(sec);

        // tests addNodeAfterThis
        System.out.println("add node after this");
        sec.addNodeAfterThis(5);
        System.out.println(sec);

        // tests removeNodeAfterThis
        System.out.println("remove node after this");
        sec.removeNodeAfterThis();
        System.out.println(sec);

        // tests length
        System.out.println("length");
        System.out.println(sec.length());

        // tests contains
        System.out.println("contains 2");
        System.out.println(sec.contains(2));

        // tests addToEnd
        System.out.println("add to end");
        sec.addToEnd(5);
        System.out.println(sec);

        // tests numOdds
        System.out.println("num odds");
        System.out.println(sec.numOdds());

        // tests sumLast
        System.out.println("sum given");
        System.out.println(sec.sumLast(1));
        System.out.println("sum all");
        System.out.println(sec.sumLast(5));

        // tests copyOdd
        System.out.println("copy odd");
        IntNode oddCopy = sec.copyOdd();
        System.out.println(oddCopy);

        // tests removeAll
        System.out.println("remove all 1s");
        System.out.println(sec.removeAll(1));

        // tests reverse
        System.out.println("reverse");
        System.out.println(sec.reverse());

        // tests isCyclic
        System.out.println("is not cyclic");
        System.out.println(sec.isCyclic(new ArrayList<>()));
        System.out.println("is cyclic");
        IntNode cycle = new IntNode(5, null);
        cycle.addToEnd(5);
        cycle.getNext().setNext(cycle);
        System.out.println(cycle.isCyclic(new ArrayList<>()));
    }
}

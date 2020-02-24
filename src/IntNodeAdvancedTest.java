import java.util.ArrayList;

public class IntNodeAdvancedTest {
    public static void main(String[] args) {
        System.out.println("constructors");
        IntNode fir = new IntNode();
        IntNode sec = new IntNode(1, fir);
        fir.setData(2);
        System.out.println(sec);

        System.out.println("add node after this");
        sec.addNodeAfterThis(5);
        System.out.println(sec);

        System.out.println("remove node after this");
        sec.removeNodeAfterThis();
        System.out.println(sec);

        System.out.println("length");
        System.out.println(sec.length());

        System.out.println("contains 2");
        System.out.println(sec.contains(2));

        System.out.println("add to end");
        sec.addToEnd(5);
        System.out.println(sec);

        System.out.println("num odds");
        System.out.println(sec.numOdds());

        System.out.println("sum given");
        System.out.println(sec.sumLast(1));

        System.out.println("sum all");
        System.out.println(sec.sumLast(5));

        System.out.println("copy odd");
        IntNode oddCopy = sec.copyOdd();
        System.out.println(oddCopy);

        System.out.println("remove all 1s");
        System.out.println(sec.removeAll(1));

        System.out.println("reverse");
        System.out.println(sec.reverse());

        System.out.println("is not cyclic");
        System.out.println(sec.isCyclic(new ArrayList<>()));

        System.out.println("is cyclic");
        IntNode cycle = new IntNode(5, null);
        cycle.addToEnd(5);
        cycle.getNext().setNext(cycle);
        System.out.println(cycle.isCyclic(new ArrayList<>()));

    }
}

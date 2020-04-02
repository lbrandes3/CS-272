public class StackTest {
    public static void main(String[] args) {
        LinkStack<String> a = new LinkStack<>();
        ArraylistStack<String> b = new ArraylistStack<>();

        testIsEmpty(a, b);
        testTop(a, b);
        testPop(a, b);
        testSize(a, b);
        System.out.println();

        testPush(a, b, "first val");
        testIsEmpty(a, b);
        testTop(a, b);
        testSize(a, b);
        System.out.println();

        testPop(a, b);
        testSize(a, b);
        System.out.println();

        testPush(a, b, "sec val");
        testPush(a, b, "third val");
        testPush(a, b, "fourth val");
        testSize(a, b);
        System.out.println();

        testPop(a, b);
        testSize(a, b);
    }

    // tests both stacks for whether they're empty and prints the result
    public static void testIsEmpty(LinkStack a, ArraylistStack b) {
        System.out.print("LinkStack is ");
        if (a.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
        System.out.print("ArrayListStack is ");
        if (b.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");
        }
    }

    // tests both stacks top method
    public static void testTop(LinkStack a, ArraylistStack b) {
        System.out.println("LinkStack top is " + a.top());
        System.out.println("ArrayListStack top is " + b.top());
    }

    // tests both stacks pop method
    public static void testPop(LinkStack a, ArraylistStack b) {
        System.out.println("LinkStack pop is " + a.pop());
        System.out.println("ArrayListStack pop is " + b.pop());
    }

    // tests both stacks push method
    public static void testPush(LinkStack a, ArraylistStack b, String s) {
        a.push(s);
        b.push(s);
    }

    // tests both stacks size method
    public static void testSize(LinkStack a, ArraylistStack b) {
        System.out.println("LinkStack size is " + a.size());
        System.out.println("ArrayListStack size is " + b.size());
    }
}

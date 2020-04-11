// Luke Brandes
// Lab 10

public class RecursiveQuestion {
    // creates the fractal pattern
    public static void asterisks(int indent, int longest) {
        // default case
        if (longest == 1) {
            for (int i = 0; i < indent * 2; i++) {
                System.out.print(" ");
            }
            System.out.println("* ");
            return;
        }
        // calls the top half
        asterisks(indent, longest / 2);
        // prints the long line
        for (int i = 0; i < indent * 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < longest; i++) {
            System.out.print("* ");
        }
        System.out.println();
        // prints the bottom half
        asterisks(indent + longest / 2, longest / 2);
    }

    // fibonacci sequence
    public static int fibBinaryRecursive(int k) {
        // default cases
        if (k == 1) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        // calls recursive cases
        return fibBinaryRecursive(k - 1) + fibBinaryRecursive(k - 2);
    }

    // shows the call level
    public static String showCallLevel(int left, int cur) {
        // default case
        if (left == 0) { return ""; }

        // uses a StringBuilder to build the string showing call level
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < cur; i++) {
            ret.append("  ");
        }
        ret.append("This was written by call number ");
        ret.append(cur);
        ret.append("x.\n");
        ret.append(showCallLevel(left - 1, cur + 1));
        for (int i = 1; i < cur; i++) {
            ret.append("  ");
        }
        ret.append("This was written by call number ");
        ret.append(cur);
        ret.append("y.\n");
        return ret.toString();
    }

    // solves binary
    public static String binaryPrintHelper(int n) {
        if (n == 1) { return "1"; }
        if (n == 2) { return "10"; }
        return binaryPrintHelper(n / 2) + "" + n % 2;
    }

    // uses a helper to solve for binary to deal with base case 0 and to print from left to right
    public static void binaryPrint(int n) {
        if(n == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(binaryPrintHelper(n));
    }

    // solves tower of hanoi
    public static void towers(int n, char from, char to, char extra) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
            return;
        }
        towers(n - 1, from, extra, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        towers(n - 1, extra, to, from);
    }

    // main, includes only a test for towers as instructions do not call for test cases
    public static void main(String[] args) {
        towers(4, 'A', 'C', 'B');
    }
}


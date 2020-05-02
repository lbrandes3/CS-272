import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {
    public List<Integer> ints = new ArrayList<>();

    public void add(int e) {
        int curLoc = ints.size();
        ints.add(e);
        int parent = ints.get(parentLoc(curLoc));
        while (e < parent) {
            ints.set(parentLoc(curLoc), e);
            ints.set(curLoc, parent);
            curLoc = parentLoc(curLoc);
            parent = ints.get(parentLoc(curLoc));
        }
    }

    public int remove() {
        if (ints.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There are no values in the Heap");
        }
        int tempInt = ints.get(0);
        ints.remove(0);
        MinHeap tempHeap = new MinHeap();
        ints.forEach(tempHeap::add);
        ints = tempHeap.ints;
        return tempInt;
    }

    public int top() {
        if (ints.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("There are no values in the Heap");
        }
        return ints.get(0);
    }

    private int parentLoc(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Your value must be at least 0");
        }
        return (i - 1) / 2;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        ints.forEach((i) -> s.append(i + " "));
        return s.toString();
    }

    public static int binarySearch(int[] a, int e) {
        if (a.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        try {
            if (a[a.length / 2] == e) {
                return a.length / 2;
            }
            if (e > a[a.length / 2]) {
                return a.length / 2 + binarySearch(Arrays.copyOfRange(a, a.length / 2, a.length), e);
            }
            if (e < a[a.length / 2]) {
                return binarySearch(Arrays.copyOfRange(a, 0, a.length / 2), e);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        List<Integer> l = Arrays.asList(3, 5, 9, 6, 10, 8, 4, 7, 2);
        l.forEach(heap::add);
        System.out.println(heap);

        for (int i = 1; i < 15; i++) {
            // System.out.println(heap.parentLoc(i));
        }

        heap.add(1);
        System.out.println(heap.top());
        heap.add(2);
        System.out.println(heap.top());
        heap.add(0);
        System.out.println(heap.top());
        System.out.println();

        for (int i = 0; i < 20; i++) {
            heap.add(i);
        }

        System.out.println(heap);
        System.out.println();
        System.out.println(heap.remove());
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);

        MinHeap heap2 = new MinHeap();

        for (int i = 20; i > 0; i--) {
            heap2.add(i);
        }

        System.out.println(heap2);
        System.out.println(heap2.remove());
        System.out.println(heap2);
    }
}

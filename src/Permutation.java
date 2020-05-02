// Luke Brandes
// Lab 10

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void permutations(List<Integer> prefix, List<Integer> arr) {
        // default case
        if (arr.size() == 0) {
            prefix.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }

        // calls permutation with each permutation of the arr list
        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            prefix.add(temp);
            arr.remove(i);
            permutations(prefix, arr);
            prefix.remove(prefix.size() - 1);
            arr.add(i, temp);
        }
    }

    // tests permutations with lists of size 1-5 and 10
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        permutations(new ArrayList<>(), ints);
        System.out.println();

        ints.add(2);
        permutations(new ArrayList<>(), ints);
        System.out.println();

        ints.add(3);
        permutations(new ArrayList<>(), ints);
        System.out.println();

        ints.add(4);
        permutations(new ArrayList<>(), ints);
        System.out.println();

        ints.add(5);
        permutations(new ArrayList<>(), ints);
        System.out.println();

        for (int i = 6; i <= 10; i++) {
            ints.add(i);
        }
        permutations(new ArrayList<>(), ints);
    }
}

import java.util.Arrays;

public class Search {
    public static int binarySearch(int[] a, int e) {
        // The array out of bounds exception is used as a way to communicate up the recursion that the value DNE
        // This could also be solved by a much lengthier solution involving move advanced checking in each if statement
        try {
            if (a.length == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (a.length == 1 && a[0] != e) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (a[a.length / 2] == e) {
                return a.length / 2;
            }
            if (e > a[a.length / 2]) {
                int temp = binarySearch(Arrays.copyOfRange(a, a.length / 2, a.length), e);
                if (temp == -1) {
                    return -1;
                }
                return a.length / 2 + temp;
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
        int[] arr = {};
        System.out.println(binarySearch(arr, -5));

        int[] arr1 = {-1};
        System.out.println(binarySearch(arr1, -2));

        int[] arr2 = {-1, 0};
        System.out.println(binarySearch(arr2, -1));
        System.out.println(binarySearch(arr2, 0));
        System.out.println(binarySearch(arr2, 1));

        int[] arr3 = {-1, 0, 1};
        System.out.println(binarySearch(arr3, -1));
        System.out.println(binarySearch(arr3, 0));
        System.out.println(binarySearch(arr3, 1));
        System.out.println(binarySearch(arr3, 3));
    }
}

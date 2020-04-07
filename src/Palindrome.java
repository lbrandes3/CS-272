import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String testString = "You can cage a swallow can't you but you can't swallow a cage can you";
        System.out.println(isPalindrome(testString));
    }

    public static boolean isPalindrome(String testString) {
        testString = testString.toLowerCase();
        Scanner sc = new Scanner(testString);
        LinkedQueue<String> queue = new LinkedQueue<>();
        LinkStack<String> stack = new LinkStack<>();
        while (sc.hasNext()) {
            String temp = sc.next();
            queue.enqueue(temp);
            stack.push(temp);
        }
        while(!stack.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }
        return true;
    }
}

public class NQueen {
    public void solve(int n) {
        if (n == 1) {
            System.out.println("Q");
            return;
        } else if (n == 2 || n == 3) {
            System.out.println("NQueen is unsolvable for 2 and 3");
            return;
        }
        LinkStack<Integer> s = new LinkStack();
        while (s.size() < n) {

        }
    }

    public boolean hasConflict(int n, LinkStack<Integer> s) {
        boolean[] col = new boolean[n];
        boolean[] down = new boolean[2 * n - 1];
        boolean[] up = new boolean[2 * n - 1];
        for (int row = 0; ; row++) {
            if (s.isEmpty()) { return false; }
            int qpos = s.pop();

            if (col[qpos]) {
                return true;
            }
            col[qpos] = true;

            if (down[qpos - row + n - 1]) {
                return true;
            }
            down[qpos - row + n - 1] = true;

            if (up[(n - row) - row + n - 1]) {
                return true;
            }
            up[(n - row) - row + n - 1] = true;
        }
    }
}

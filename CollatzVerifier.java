import java.util.HashMap;
import java.util.Map;

public class CollatzVerifier {

    // Collatz function with memoization
    public static int collatz(long n, Map<Long, Integer> memo) {
        long original = n;
        int steps = 0;

        while (n != 1) {
            if (memo.containsKey(n)) {
                steps += memo.get(n);
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }

        memo.put(original, steps);
        return steps;
    }

    // Verify Collatz conjecture up to a given limit
    public static void verifyCollatzUpto(int limit) {
        Map<Long, Integer> memo = new HashMap<>();
        memo.put(1L, 0); // base case

        for (int i = 1; i < limit; i++) {
            collatz(i, memo);
        }

        System.out.println("Verified: All numbers from 1 to " + limit + " eventually reach 1 using memoization.");
    }

    public static void main(String[] args) {
        verifyCollatzUpto(1_000_000); // Test up to 1 million
    }
}

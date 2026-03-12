public class FactorialRecursionBasic {

    // Recursive factorial
    static long factorial(int n) {
        if (n < 0)  throw new IllegalArgumentException("Negative input: " + n);
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Iterative factorial (for comparison)
    static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    // Fibonacci (recursive — educational, not efficient)
    static long fib(int n) {
        if (n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    // Fibonacci with memoization
    static long[] memo = new long[100];
    static long fibMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = fibMemo(n-1) + fibMemo(n-2);
    }

    // Sum of digits recursively
    static int digitSum(int n) {
        if (n < 10) return n;
        return n % 10 + digitSum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Factorial ===");
        for (int i = 0; i <= 15; i++)
            System.out.printf("%2d! = %,d%n", i, factorial(i));

        System.out.println("\n=== Fibonacci (first 20) ===");
        for (int i = 0; i < 20; i++) System.out.printf("F(%2d) = %d%n", i, fibMemo(i));

        System.out.println("\n=== Digit Sum (recursive) ===");
        int[] nums = {0, 5, 123, 9999, 999999};
        for (int n : nums) System.out.printf("digitSum(%6d) = %d%n", n, digitSum(n));

        System.out.println("\n=== Recursive vs Iterative (same result?) ===");
        for (int i = 0; i <= 5; i++)
            System.out.printf("%d! recursive=%d iterative=%d match=%b%n",
                i, factorial(i), factorialIterative(i), factorial(i)==factorialIterative(i));
    }
}

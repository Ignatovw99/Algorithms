public class RecursiveFactorial {

    public static long calculate(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calculate(n - 1);
    }
}

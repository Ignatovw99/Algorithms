import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacci {

    //Memoization optimization technique is used
    private Map<Integer, Long> cache;

    public RecursiveFibonacci() {
        cache = new HashMap<>();
    }

    public long calculate(int n) {
        if (n <= 1) {
            return 1;
        } else {
            Long result = cache.get(n);
            if (result != null) {
                return result;
            }
            result = calculate(n - 1) + calculate(n - 2);
            cache.put(n, result);
            return result;
        }
    }
}

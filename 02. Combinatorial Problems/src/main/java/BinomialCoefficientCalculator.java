// ( n )
// ( k )
//  k
// C
//  n
public class BinomialCoefficientCalculator {

    public static long calculateBinomialDistribution(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return calculateBinomialDistribution(n - 1, k - 1) + calculateBinomialDistribution(n - 1, k);
    }
}

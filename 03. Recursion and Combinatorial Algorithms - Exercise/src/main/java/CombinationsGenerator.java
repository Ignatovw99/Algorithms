public class CombinationsGenerator {

    private int n;

    private int k;

    private int[] combinations;

    public CombinationsGenerator(int n, int k) {
        this.n = n;
        this.k = k;
        combinations = new int[k];
    }

    public void generateWithRepetition() {
        combinationsWithRepetition(0, 1);
    }

    public void generateWithoutRepetition() {
        combinationsWithoutRepetition(0, 1);
    }

    private void combinationsWithoutRepetition(int index, int start) {
        if (index >= k) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                combinationsWithoutRepetition(index + 1, i + 1);
            }
        }
    }

    private void combinationsWithRepetition(int index, int start) {
        if (index >= combinations.length) {
            print();
        } else {
            for (int i = start; i <= n; i++) {
                combinations[index] = i;
                combinationsWithRepetition(index + 1, i);
            }
        }
    }

    private void print() {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
}

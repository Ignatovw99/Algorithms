public class RecursiveNestedLoops {

    private int[] permutations;

    private int n;

    public RecursiveNestedLoops(int n) {
        permutations = new int[n];
        this.n = n;
    }

    public void generatePermutations() {
        permute(0);
    }

    private void permute(int index) {
        if (index >= permutations.length) {
            print();
        } else {
            for (int i = 1; i <= n; i++) {
                permutations[index] = i;
                permute(index + 1);
            }
        }
    }

    private void print() {
        for (int i = 0; i < permutations.length; i++) {
            System.out.print(permutations[i] + " ");
        }
        System.out.println();
    }
}

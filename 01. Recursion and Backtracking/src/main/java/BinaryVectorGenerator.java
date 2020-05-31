public class BinaryVectorGenerator {

    public static void generate(int n) {
        int[] vector = new int[n];
        fillVector(vector, 0);
    }

    public static void fillVector(int[] vector, int index) {
        if (index >= vector.length) {
            print(vector);
        } else {
            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                fillVector(vector, index + 1);
            }
        }
    }

    private static void print(int[] vector) {
        for (int bit : vector) {
            System.out.print(bit);
        }
        System.out.println();
    }
}

public class Combination {

    private String[] elements;

    private int k;

    private String[] combinations;

    public Combination(String[] elements, int k) {
        this.elements = elements;
        this.k = k;
        combinations = new String[k];
    }

    public void combinationsWithoutRepetition(int index, int start) {
        if (index >= combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combinationsWithoutRepetition(index + 1, i + 1);
            }
        }
    }

    public void combinationsWithRepetition(int index, int start) {
        if (index >= combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {
                combinations[index] = elements[i];
                combinationsWithRepetition(index + 1, i);
            }
        }
    }

    private void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}

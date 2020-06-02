public class Variation {

    private String[] elements;

    private int k;

    private String[] variations;

    private boolean[] used;

    public Variation(String[] elements, int k) {
        this.elements = elements;
        this.k = k;
        variations = new String[k];
        used = new boolean[elements.length];
    }

    public void variationsWithoutRepetition(int index) {
        if (index >= variations.length) {
            print(variations);
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    variations[index] = elements[i];
                    variationsWithoutRepetition(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    public void variationsWithRepetition(int index) {
        if (index >= variations.length) {
            print(variations);
        } else {
            for (int i = 0; i < elements.length; i++) {
                variations[index] = elements[i];
                variationsWithRepetition(index + 1);
            }
        }
    }

    private void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}

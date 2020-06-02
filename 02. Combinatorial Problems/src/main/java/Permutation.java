import java.util.Arrays;
import java.util.HashSet;

public class Permutation {

    private String[] elements;

    private String[] permutes;

    private boolean[] used;

    public Permutation(String[] elements) {
        this.elements = elements;
        permutes = new String[elements.length];
        used = new boolean[elements.length];
    }

    public void permuteWithoutRepetition(int index) {
        if (index >= elements.length) {
             print(permutes);
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permutes[index] = elements[i];
                    permuteWithoutRepetition(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    public void permuteWithRepetition(int index) {
        if (index >= elements.length) {
            print(elements);
        } else {
            permuteWithRepetition(index + 1);
            HashSet<String> swappedElements = new HashSet<>();
            swappedElements.add(elements[index]);
            for (int i = index + 1; i < elements.length; i++) {
                if (!swappedElements.contains(elements[i])) {
                    swap(elements, index, i);
                    permuteWithRepetition(index + 1);
                    swap(elements, index, i);
                    swappedElements.add(elements[i]);
                }
            }
        }
    }

    public void permuteWithRepetitionOptimized() {
        Arrays.sort(elements);
        permuteWithRepetitionOptimized(elements, 0, elements.length - 1);
    }

    private void permuteWithRepetitionOptimized(String[] arr, int start, int end) {
        print(arr);
        for (int left = end - 1; left >= start; left--) {
            for (int right = left + 1; right <= end; right++) {
                if (!arr[left].equals(arr[right])) {
                    swap(arr, left, right);
                    permuteWithRepetitionOptimized(arr, left + 1, end);
                }
                String firstElement = arr[left];
                for (int i = left; i <= end - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[end] = firstElement;
            }
        }
    }

    public void permuteWithoutRepetitionOptimized(int index) {
        if (index >= elements.length) {
            print(elements);
        } else {
            permuteWithoutRepetitionOptimized(index + 1);
            for (int i = index + 1; i < elements.length; i++) {
                swap(elements, index, i);
                permuteWithoutRepetitionOptimized(index + 1);
                swap(elements, index, i); // <-- This is unswap when backtracking
            }
        }
    }

    private void swap(String[] arr, int firstIndex, int secondIndex) {
        String temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}

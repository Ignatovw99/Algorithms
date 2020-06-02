public class RecursiveArrayReversion {

    private String[] array;

    private String[] result;

    public RecursiveArrayReversion(String[] array) {
        this.array = array;
        result = new String[array.length];
    }

    public String[] reverseArray() {
        reverse(0);
        return result;
    }

    private void reverse(int index) {
        if (index >= array.length) {
            return;
        }
        reverse(index + 1);
        result[array.length - 1 - index] = array[index];
    }
}

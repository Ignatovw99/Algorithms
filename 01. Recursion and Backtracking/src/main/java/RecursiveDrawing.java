public class RecursiveDrawing {

    private static void drawLine(int n, char character) {
        for (int i = 0; i < n; i++) {
            System.out.print(character);
        }
        System.out.println();
    }

    public static void draw(int n) {
        //Pre-action
        if (n == 0) {
            return;
        }
        drawLine(n, '*');

        //Recursion call
        draw(n - 1);

        //Post-action - backtracking
        drawLine(n, '#');
    }
}

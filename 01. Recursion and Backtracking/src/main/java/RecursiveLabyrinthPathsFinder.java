import java.util.ArrayList;
import java.util.List;

public class RecursiveLabyrinthPathsFinder {

    private static List<Character> path = new ArrayList<>();

    public static void find(char[][] labyrinth) {
        findPath(labyrinth, 0, 0, ' ');
    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        //Base cases
        if (!isInBounds(labyrinth, row, col)) {
            return;
        }

        path.add(direction);

        if (isExit(labyrinth, row, col)) {
            //Solution found + another base case
            printPath();

        } else if (!isVisited(labyrinth, row, col) && isFree(labyrinth, row, col)) {
            //Pre-actions
            mark(labyrinth, row, col);
            //Recursion call
            findPath(labyrinth, row + 1, col, 'D');
            findPath(labyrinth, row, col + 1, 'R');
            findPath(labyrinth, row - 1, col, 'U');
            findPath(labyrinth, row, col - 1, 'L');
            //Post-actions + Backtracking
            unmark(labyrinth, row, col);
        }

        path.remove(path.size() - 1);
    }

    private static boolean isFree(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] != '*';
    }

    private static boolean isVisited(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'V';
    }

    private static void mark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = 'V';
    }

    private static void unmark(char[][] labyrinth, int row, int col) {
        labyrinth[row][col] = '-';
    }

    private static boolean isExit(char[][] labyrinth, int row, int col) {
        return labyrinth[row][col] == 'e';
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row >= 0 && row < labyrinth.length
                && col >= 0 && col < labyrinth[row].length;
    }

    private static void printPath() {
        for (Character direction : path) {
            if (direction == ' ') {
                continue;
            }
            System.out.print(direction);
        }
        System.out.println();
    }
}

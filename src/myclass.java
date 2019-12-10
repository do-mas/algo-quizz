import java.util.*;

// Java program to find minimum steps to reach to
// specific Cell in minimum moves by Knight
class myclass {

    // Class for storing a Cell's data
    static class Cell {
        int x, y;
        int dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    // Utility method returns true if (x, y) lies
// inside Board
    static boolean isInsideBoard(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    // Method returns minimum step
// to reach target position
    static int minStepToReachTarget(int knightPos[], int targetPosition[],
                                    int N) {
        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Vector<Cell> knightStates = new Vector<>();

        // push starting position of knight with 0 distance
        knightStates.add(new Cell(knightPos[0], knightPos[1], 0));

        Cell currPosition;
        int x, y;

        boolean board[][] = new boolean[N + 1][N + 1];

        // make all Cell unvisited
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                board[i][j] = false;
        }


        // visit starting state
        board[knightPos[0]][knightPos[1]] = true;

        // loop untill we have one element in queue
        while (true) {

            currPosition = takeOutTheFirstPosition(knightStates);

            System.out.println("current->" + currPosition.x + ":" + currPosition.y);

            if (isTheDestination(targetPosition, currPosition)) return currPosition.dis;

            for (int i = 0; i < 8; i++) {

                x = currPosition.x + dx[i];
                y = currPosition.y + dy[i];

                System.out.println("possible-position->" + x + ":" + y);

                if (isInsideBoard(x, y, N) && wasSelectedForVisit(board[x][y])) {
                    if ((x == 10) && (y == 5)) {
                        int is = 0;
                    }
                    System.out.println("selecting for visit->" + x + ":" + y + "dis" + (currPosition.dis + 1));
                    selectForVisit(x, y, board);
                    knightStates.add(new Cell(x, y, currPosition.dis + 1));

                }
            }
        }
//        return Integer.MAX_VALUE;
    }

    private static void selectForVisit(int x, int y, boolean[][] board) {
        board[x][y] = true;
    }

    private static boolean wasSelectedForVisit(boolean b) {
        return !b;
    }

    private static boolean isTheDestination(int[] targetPos, Cell t) {
        if (t.x == targetPos[0] && t.y == targetPos[1]) {
            System.out.println(" -- found -- ->" + t.x + ":" + t.y);
            return true;
        }
        return false;
    }

    private static Cell takeOutTheFirstPosition(Vector<Cell> knightStates) {
        Cell t;
        t = knightStates.firstElement();
        knightStates.remove(0);
        return t;
    }

    // Driver code
//    public static void main(String[] args)
//    {
//        int N = 30;
//        int knightPos[] = {1, 1};
//        int targetPos[] = {30, 30};
//        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
//    }
}

// This code contributed by Rajput-Ji
class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
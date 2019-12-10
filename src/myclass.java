import java.util.*;

// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight
class myclass
{

    // Class for storing a cell's data
    static class cell
    {
        int x, y;
        int dis;
        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    // Utility method returns true if (x, y) lies
// inside Board
    static boolean isInsideBoard(int x, int y, int N)
    {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    // Method returns minimum step
// to reach target position
    static int minStepToReachTarget(int knightPos[], int targetPos[],
                                    int N)
    {
        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Vector<cell> knightStates = new Vector<>();

        // push starting position of knight with 0 distance
        knightStates.add(new cell(knightPos[0], knightPos[1], 0));

        cell t ;
        int x, y;

        boolean visit[][] = new boolean[N + 1][N + 1];

        // make all cell unvisited
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visit[i][j] = false;

        // visit starting state
        visit[knightPos[0]][knightPos[1]] = true;

        // loop untill we have one element in queue
        while (true) {
            t = knightStates.firstElement();
            knightStates.remove(0);
//            knightStates.clear();

            System.out.println("current->"+ t.x +":"+ t.y);
            // if current cell is equal to target cell,
            // return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1]){
                System.out.println(" -- found -- ->" + t.x + ":" + t.y);
            return t.dis;
        }


            // loop throught available spots
            for (int i = 0; i < 8; i++)
            {
                x = t.x + dx[i];
                y = t.y + dy[i];

                System.out.println("next->"+ x +":"+ y);

                if (isInsideBoard(x, y, N) && !visit[x][y])
                {
                    if ((x == 10) && (y==5)){
                        int is = 0;
                    }
                    System.out.println("visit->"+ x +":"+ y + "dis" + (t.dis + 1));
                    visit[x][y] = true;
                    knightStates.add(new cell(x, y, t.dis + 1));
                }
            }
        }
//        return Integer.MAX_VALUE;
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

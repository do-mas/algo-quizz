import java.util.*;

// Java program to find minimum steps to reach to
// specific CellWithDistance in minimum moves by Knight
class StepsCalculator {

    // Class for storing a CellWithDistance's data


    // Utility method returns true if (x, y) lies
// inside Board
    private static boolean isInsideBoard(int x, int y) {
        if (x >= 0 && y >= 0) {
            return true;
        }
        return false;
    }

    // Method returns minimum step
// to reach target position
    static int minStepToReachTarget(int knightPos[],
                                    int targetPosition[]) {


        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        int targetX = targetPosition[0];
        int targetY = targetPosition[1];
        // queue for storing states of knight in board
        Vector<CellWithDistance> queueToVisit = new Vector<>();

        // push starting position of knight with 0 distance
        queueToVisit.add(new CellWithDistance(knightPos[0], knightPos[1], 0));

        CellWithDistance currPos;
        int x, y;

        Set<CellWithDistance> takenPossitions = new HashSet<>();

        // loop untill we have one element in queue
        int visits = 0;
        while (!queueToVisit.isEmpty()) {
            visits = visits + 1;

            currPos = takeOutTheFirstPosition(queueToVisit);

//            System.out.println("visiting ->" + currPos.x + ":" + currPos.y);

            if (isTheDestination(targetPosition, currPos)) {
//                System.out.println("total taken positions ->" + takenPossitions.size());
//                System.out.println("total visits ->" + takenPossitions.size());
                return currPos.dis;
            }

            for (int i = 0; i < 8; i++) {
                x = currPos.x + dx[i];
                y = currPos.y + dy[i];

//                System.out.println("possible-position ->" + x + ":" + y);

                if (isInsideBoard(x, y)) {

                    if (targetX + 6  < x || targetY + 6 < y){
                        continue;
                    }

                    CellWithDistance cell = new CellWithDistance(x, y, currPos.dis + 1);

                    if (isTheDestination(targetPosition, cell)) {
                        System.out.println("total taken positions ->" + takenPossitions.size());
                        System.out.println("total visits ->" + takenPossitions.size());
                        return cell.dis;
                    }


                        if (takenPossitions.add(cell)) {
                            queueToVisit.add(cell);
                        }
//                        System.out.println("selecting for visit->" + x + ":" + y + "dis" + (currPos.dis + 1));

                }
            }
        }
        return 0;
    }

    private static boolean isTheDestination(int[] targetPos, CellWithDistance t) {
        if (t.x == targetPos[0] && t.y == targetPos[1]) {
            System.out.println(" -- found -- ->" + t.x + ":" + t.y);
            return true;
        }
        return false;
    }

    private static CellWithDistance takeOutTheFirstPosition(Vector<CellWithDistance> knightStates) {
        CellWithDistance t;
        t = knightStates.firstElement();
        knightStates.remove(0);
        return t;
    }

}

class CellWithDistance {
    int x, y;
    int dis;

    public CellWithDistance(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellWithDistance that = (CellWithDistance) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
package chess;

import java.util.*;

class KnightStepCalculator {

    // knight possible moves
    private static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static int minStepToReachTarget(int[] knightPos, int[] targetPosition) {

        int targetX = targetPosition[0];
        int targetY = targetPosition[1];

        Set<Position> queuedPositions = new HashSet<>();
        Queue<Position> queueToVisit = new LinkedList<>();

        Position initialPosition = new Position(knightPos[0], knightPos[1], 0);
        queueToVisit.add(initialPosition);

        int visits = 0;
        while (!queueToVisit.isEmpty()) {
            visits = visits + 1;

            Position currPos = queueToVisit.poll();

            for (int i = 0; i < 8; i++) {

                int x = currPos.x + dx[i];
                int y = currPos.y + dy[i];

                if ((x < 0) && (y < 0)) {
                    continue;
                }
                if (targetX + 6 < x || targetY + 6 < y) {
                    continue;
                }

                Position newPosition = new Position(x, y, currPos.dis + 1);
                if (isTheDestination(targetPosition, newPosition)) {
                    System.out.println("total taken positions ->" + queuedPositions.size());
                    System.out.println("total visits ->" + visits);
                    return newPosition.dis;
                }

                if (queuedPositions.add(newPosition)) {
                    queueToVisit.add(newPosition);
                }

            }
        }
        return -1;
    }

    private static boolean isTheDestination(int[] targetPos, Position t) {
        if (t.x == targetPos[0] && t.y == targetPos[1]) {
            System.out.println(" -- found -- ->" + t.x + ":" + t.y);
            return true;
        }
        return false;
    }

}

class Position {
    int x, y;
    int dis;

    Position(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
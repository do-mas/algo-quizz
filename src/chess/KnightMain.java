package chess;

public class KnightMain {
    public static void main(String[] args) {

        int rez = KnightStepCalculator.minStepToReachTarget(new int[]{0,0}, new int[] {30 ,400});
        System.out.println(rez);

    }
}


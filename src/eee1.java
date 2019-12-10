import java.util.Arrays;

public class eee1 {

    public static void main(String[] args) {

        int[] i;
        i = new int[]{2, 1, 3, 1, 2, 2, 3};

        int rez = solution1(3, 5, i);
        System.out.println(rez);
    }


    public static int solution1(int K, int M, int[] A) {

        // i - i + K -> increase item, check if there is a leader


        int[] ii = Arrays.stream(A).distinct().toArray();

        int min = myclass.minStepToReachTarget(new int[]{0,0}, new int[] {10 ,5}, 67);


        return min;


    }


}


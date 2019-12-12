//A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
//
//        Count the minimal number of jumps that the small frog must perform to reach its target.
//
//        Write a function:
//
//class Solution { public int solution(int X, int Y, int D); }
//
//that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
//
//        For example, given:
//
//        X = 10
//        Y = 85
//        D = 30
//        the function should return 3, because the frog will be positioned as follows:
//
//        after the first jump, at position 10 + 30 = 40
//        after the second jump, at position 10 + 30 + 30 = 70
//        after the third jump, at position 10 + 30 + 30 + 30 = 100
//        Write an efficient algorithm for the following assumptions:
//
//        X, Y and D are integers within the range [1..1,000,000,000];
//        X ≤ Y.
//        Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

import java.util.Arrays;

public class PermMisingElem {

    public static void main(String[] args) {

        int[] ar = new int[]{1, 2, 3, 4 , 5, };
        int rez1 = exec1(ar);
        System.out.println(rez1);

    }

    static int exec1(int[] x) {

        if (x.length == 0)
            return 1;

        Arrays.sort(x);

        int previuos = x[0];

        if (previuos != 1)
            return 1;

        for (int i = 1; i < x.length; i++) {
            if ((previuos + 1) !=  x[i]){
                return previuos + 1;
            }
            previuos =  x[i];
        }

        return previuos + 1;
    }


//    static int exec(int x, int y, int d) {
//
//        int count = 0;
//        while(x < y) {
//            count++;
//            x = x + d;
//        }
//        return  count;
//
//    }

}

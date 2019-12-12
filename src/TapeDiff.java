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

public class TapeDiff {

    public static void main(String[] args) {

        int[] ar = new int[]{3, 1, 2, 4, 3};
        int rez1 = exec1(ar);
        System.out.println("rez =>" + rez1);

    }

    static int exec1(int[] x) {


        int minDiff = Integer.MAX_VALUE;
        int minDiffIndx = 0;
        for (int i=0; i<x.length; i++){
            int[] arr1 = Arrays.copyOfRange(x, 0, i);
            int[] arr2 = Arrays.copyOfRange(x, i, x.length);
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            int diff = Math.abs(sum1 - sum2);
//            System.out.println("diff =>" + diff);
            if (diff < minDiff) {
                minDiff = diff;
//                System.out.println("min diff =>" + minDiff);
                minDiffIndx = i;
//                System.out.println("index =>" + minDiffIndx);
            }
        }

        return minDiff;

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

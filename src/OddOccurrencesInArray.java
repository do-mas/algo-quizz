//A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
//
//        For example, in array A such that:
//
//        A[0] = 9  A[1] = 3  A[2] = 9
//        A[3] = 3  A[4] = 9  A[5] = 7
//        A[6] = 9
//        the elements at indexes 0 and 2 have value 9,
//        the elements at indexes 1 and 3 have value 3,
//        the elements at indexes 4 and 6 have value 9,
//        the element at index 5 has value 7 and is unpaired.
//        Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
//
//        For example, given array A such that:
//
//        A[0] = 9  A[1] = 3  A[2] = 9
//        A[3] = 3  A[4] = 9  A[5] = 7
//        A[6] = 9
//        the function should return 7, as explained in the example above.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an odd integer within the range [1..1,000,000];
//        each element of array A is an integer within the range [1..1,000,000,000];
//        all but one of the values in A occur an even number of times.


import java.util.Arrays;

public class OddOccurrencesInArray {

    public static void main(String[] args) {

        int[] i = {2, 2, 8, 4, 3, 3, 4};
        int rez = test2(i);
        System.out.println(rez);
    }

    static int test2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            int n = nums[i];
            int m = nums[i + 1];
            if (n != m) {
                return n;
            }
            i=i+1;
        }


        return -1;
    }

//    static int test(int[] nums) {
//
//        int[] indexesToSkip = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            if (indexesToSkip[i] == i && i != 0) {
//                continue;
//            }
//
//            int index = getPairInde1x(nums, i, indexesToSkip);
//
//            if (index == -1) {
//                return nums[i];
//            }
////            if (index == nums.length) {
////                break;
////            }
//        }
//
//        return -1;
//
//    }
//
//    static int getPairInde1x(int[] arr, int idx, int[] paired) {
//        int numberUnderIndex = arr[idx];
//        for (int i = idx + 1; i < arr.length; i++) {
//            int currNumber = arr[i];
//            if (numberUnderIndex == currNumber) {
//                arr[i] = -1;
//                arr[idx] = -1;
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    static int getPairIndex(int[] arr, int idx, int[] paired) {
//        int numberUnderIndex = arr[idx];
//
//        for (int i = idx + 1; i < arr.length; i++) {
//            int currNumber = arr[i];
//            if (numberUnderIndex == currNumber) {
//                paired[i] = i;
//                return i;
//            }
//        }
//        return -1;
//    }
}

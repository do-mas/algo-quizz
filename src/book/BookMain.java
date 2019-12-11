package book;

import java.util.*;

//find longest sequence of the same No, when K is No of numbers that could be replaced with the sequencing Number.
public class BookMain {

    public static void main(String[] args) {

        int[] i = {1, 2, 3};
//        i = new int[]{1, 2, 3, 3, 3};
//        i = new int[]{1, 2, 3, 1, 1, 1, 1};
        i = new int[]{1, 1, 3, 4, 3, 3, 4};
        i = new int[]{4, 5, 5, 4, 2, 2, 4};
        int rez = calculateMaxSequence(i, 0);
        System.out.println(rez);
    }

    static int calculateMaxSequence(int[] books, int K) {

        // all distinct, all the same
//        long distinctNoCount = Arrays.stream(books).parallel().distinct().count();
//        if (distinctNoCount == books.length) {
//            int sequenceCount = K + 1;
//            if (sequenceCount < books.length) {
//                return sequenceCount;
//            } else {
//                return books.length;
//            }
//        }
//        if (distinctNoCount == 1) {
//            return books.length;
//        }

        // K the size or array
        if (K == books.length) {
            return books.length;
        }

//        int[] indexesToSkip = new int[]{};
        int[] indexesToSkip = new int[books.length];

        int maxRez = 0;

        for (int i = 0; i < books.length; ) {
            if (indexesToSkip[i] == i && i != 0) {
                i = i + 1;
                continue;
            }

            int max = getMax(books, K, i, indexesToSkip);

            if (max > maxRez) {
                maxRez = max;
            }
            if (max == books.length) {
                break;
            }

//            int h = getTheSameNumberCount(books, i);
            i = i + 1;

        }

        return maxRez;

    }

    static int getTheSameNumberCount(int[] book, int inx) {

        int skip = 1;

        int val = book[inx];
        for (int i = inx + 1; i < book.length; i++) {
            if (book[i] == val) {
                skip = skip + 1;
            } else {
                break;
            }
        }
        return skip;


    }

    static int getMax(int[] numArray, int K, int itemIndx, int[] indexesToSkip) {
//        int KK = K;
        int numberUnderIndex = numArray[itemIndx];
        int max = 0;

        // count max to right
        for (int i = itemIndx; i < numArray.length; i++) {
            int currNumber = numArray[i];

            if (numberUnderIndex == currNumber) {
                max = max + 1;
                indexesToSkip[i] = i;
            } else {
                if (K > 0) {
                    max = max + 1;
                    K = K - 1;
                } else {
                    break;
                }
            }

//            numberUnderIndex = currNumber;

        }

        if (K == 0) {
            return max;
        }


        // add to max from left if there is anything
        int firsItemForReverse;
        if (itemIndx > 0) {
            firsItemForReverse = itemIndx - 1;
        } else {
            return max;
        }


        for (int j = firsItemForReverse; j >= 0; j--) {
            int current = numArray[j];
            if (numberUnderIndex == current) {
                // should not suppose to happen, as should be skipped in algorithm
                break;
            } else {
                if (K > 0) {
                    max = max + 1;
                    K = K - 1;
                } else {
                    return max;
//                    break;
                }
            }
        }
        return max;
    }

}

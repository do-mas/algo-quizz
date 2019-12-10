import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class eee {

    public static void main(String[] args) {

        int[] i;
        i = new int[] {1, 2, 3};

        int rez = solution1(i, 2);
        System.out.println(rez);
    }


    public static int solution1(int[] books, int K) {

//        int ma = Arrays.stream(books).max().getAsInt();
//        int mi = Arrays.stream(books).min().getAsInt();
//        if (mi == ma) {
//            return books.length;
//        }

        long iii = Arrays.stream(books).distinct().count();
        if (iii == books.length){
            int rr = K + 1;
            if (rr < books.length){
                return rr;
            } else {
                return books.length;
            }
        }
        if (iii == 1) {
            return books.length;
        }




        if (K == books.length) {
            return books.length;
        }

        int[] skipped = new int[books.length];

        int maxRez = 0;
        for (int i = 0; i < books.length;) {
            int[] wok = books;
            if (skipped[i] == i && i != 0) {
                i = i + 1;
                continue;
            }
            int max = getMax(wok, K, i, skipped);
//            System.out.println("get max" + i + "max" + max);
            if (max > maxRez){
                maxRez = max;
            }
            int h = skip(wok, i);
            i = i + h;
        }

        return maxRez;

    }

    static int skip(int[] book, int inx) {

        int skip = 1;

        int val = book[inx];
        for (int i = inx + 1; i < book.length; i++) {
           if (book[i] == val) {
               skip = skip + 1;
           }
           else {
               break;
           }
        }
        return skip;




    }

    static int getMax(int[] workingArr, int K, int ind, int[] counted) {
        int KK = K;
        int previuos = 0;
        int max = 0;
        for (int i= ind; i < workingArr.length; i++) {
            int book = workingArr[i];
            if (previuos == 0) {
                previuos = book;
            }

            if (previuos == book) {
                max = max + 1;
                counted[i] = i;
//                counted.add(new Integer(i));
                previuos = book;
            } else {
                if (KK > 0) {
                    max = max + 1;
                    KK = KK - 1;
                } else {
                    break;
                }
            }
        }

        int pre = 0;
        if (ind > 0) {
            ind = ind - 1;
        } else {
            return max;
        }
        for (int j = ind; j >= 0; j--) {
            int book = workingArr[j];
            if (pre == 0) {
                pre = workingArr[j+1];
            }

            if (previuos == book) {
                  break;
            } else {
                if (KK > 0) {
                    max = max + 1;

                    KK = KK - 1;
                } else {
                    break;
                }
            }
        }
        return max;
    }

}

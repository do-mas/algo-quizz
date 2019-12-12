import java.util.*;

public class BinaryGap {

    public static void main(String[] args) {

        int[] arr = {0, -1, -2, -3, -4, -5, -6};
        int K = 3333;


        int rez = exec(K);

        System.out.println(rez);
    }

    static int exec(int k) {

        String x = Integer.toBinaryString(k);

        int count = 0;
        List<Integer> max = new ArrayList<>();

        char[] arr = x.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == '0') {
                count++;
            }
            if (arr[i] != '0') {
                max.add(new Integer(count));
                count=0;
            }
        }
        Integer xx = (Integer) max.stream().sorted().toArray()[max.size()-1];
        return xx;
    }

}

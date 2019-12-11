import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int K = 4;

        int[] rez = arr;
        for (int i = K; i > 0; i--) {
            rez = move(rez);
        }


        Arrays.stream(rez).forEach(x -> System.out.println(x));
//        System.out.println(rez.length);
    }

    static int[] move(int[] nums) {

        int[] new1 = new int[nums.length];
        new1[0] = nums[nums.length - 1];

//        for (int i = K; i > 0; i--) {

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != -1) {
                if ((j + 1) < new1.length) {
                    new1[j + 1] = nums[j];
                }
            }
        }


//        }

        return new1;
    }

}

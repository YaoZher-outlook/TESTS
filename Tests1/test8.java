package Tests;

public class test8 {
    public static void main(String[] args) {
        int[] arr = {19,20,42,34,11,2,435,2,13};
        System.out.println(max(arr));
    }
    public static int max(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
 
}

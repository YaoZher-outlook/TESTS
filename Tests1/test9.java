package Tests;

public class test9 {
    public static void main(String[] args) {
        int[] arr = {19,20,42,34,11,2,435,2,13};
        System.out.println(exit(arr, 23));
    }
    public static boolean exit(int[] arr,int tar) {
        boolean exit = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == tar) {
                exit = true;
            }
        }
        return exit;
    }
}
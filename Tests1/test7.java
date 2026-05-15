package Tests;

public class test7 {
    public static void main(String[] args) {
        int[] arr = {11,33,23,43,54};
        printArr(arr);
    }
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                }else{System.out.print(arr[i] + ",");
                }
        }
        System.out.println("]");
    }
}
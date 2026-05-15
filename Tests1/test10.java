package Tests;

public class test10 {
    public static void main(String[] args) {
        int[] arr1 = {19,20,42,34,11,2,435,2,13};
        int[] copyArr = copyOfRange(arr1, 2,4);
        for (int u = 0; u < copyArr.length; u++) {
           System.out.print(copyArr[u] + " "); 
        } 
    }
    public static int[] copyOfRange(int[] arr, int from, int to) {
        int index = 0;
        int[] arr2 = new int[to - from];
        for (int i = from; i < to; i++) {
            arr2[index] = arr[i];
            index++;
        }
        return arr2;
    }
}

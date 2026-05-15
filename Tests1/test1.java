package Tests;

public class test1 {
    public static void main (String[] args){
        int[] arr1 = {33,23,131,53,5,6,23};
        int max = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] > max) {
                max = arr1[i];
            }
        }
    System.out.println(max);
    
    }
}

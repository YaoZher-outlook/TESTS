package Tests;

public class test16 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 2, 3},{4, 5, 6}};
        int[][] arr2 = {{1, 2, 3},{4, 5, 6}};
        int[][] arr3 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println(arr1[0]);
        System.out.println(arr2[0][0]);
        for (int i = 0; i < arr3.length; i++) {
            for (int js = 0; js < arr3[i].length; js++) {
                System.out.println(arr3[i][js]);
            }
        }
    }
}

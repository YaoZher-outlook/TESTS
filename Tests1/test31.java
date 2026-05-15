package Tests;
public class test31 {
    public static void main(String[] args) {
        long[] fibonacci = new long[21];
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i <= 20; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        int[] rounds = {1, 9, 1, 9, 8, 10};
        for (int i : rounds) {
            long A = fibonacci[2*i - 1];
            long B = fibonacci[2*i];
            System.out.println(A + "," + B);
        }
    }
}


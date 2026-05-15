package Tests;

public class test5 {
    public static void main(String[] args) {
        int sumSum = getSum(10, 20, 30) + getSum(100, 200, 300);
        System.out.println(sumSum);
    }
    public static int getSum(int num1, int num2, int num3) {
        int result = num1 + num2 + num3;
        return result;
    }
}

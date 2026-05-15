package Tests;

public class test6 {
    public static void main(String[] args) {
        double square1 = square(10, 20);
        double square2 = square(5, 40);
        if (square1 > square2) {
            System.out.println("第一个大");
        }else if (square1 < square2) {
            System.out.println("第二个大");
        }else{
            System.out.println("一样大");
        }
    }
    
    public static double square(double length,double width) {
        double square = length * width;
        return square;
    }
}

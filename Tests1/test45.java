package Tests;
public class test45 {
    public static void main(String[] args) {
        int count = 0;
        for (long i = 1; i < 2025; i++) {
            if((i * i * i) % 10 == 3) {
                count++;
            }
        }

        System.out.println(count); 
    }
}

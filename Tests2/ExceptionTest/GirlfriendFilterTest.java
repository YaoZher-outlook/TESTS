package Tests2.ExceptionTest;

import java.util.Scanner;

public class GirlfriendFilterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Girlfriends gf = new Girlfriends();
        while(true){
            System.out.println("Girlfriend's Name: ");
            String name = scanner.nextLine();
            try{
                gf.setName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while(true){
            System.out.println("Girlfriend's Age: ");
            String age = scanner.nextLine();
            try{
                gf.setAge(Integer.parseInt(age));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Girlfriend Info: " + gf);
    }
}
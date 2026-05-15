package Tests;

import java.util.Scanner;

public class HanoiTower {
    public static void Hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println(from + "-->" + to);
            return;
        }
        Hanoi(n - 1, from, aux, to);
        System.out.println(from + "-->" + to);
        Hanoi(n - 1, aux, to, from);    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();
        Hanoi(n, 'A', 'C', 'B');
    
        scanner.close();
    }
}

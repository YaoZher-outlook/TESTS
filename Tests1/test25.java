package Tests;

import java.util.ArrayList;

public class test25 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }

        ArrayList<Character> list2 = new ArrayList<>();

        list2.add('A');
        list2.add('B');
        list2.add('C');
        list2.add('D');

        System.out.println(list2);

        for (int i = 0; i < list2.size(); i++) {
            if (i == list2.size() - 1) {
                System.out.println(list2.get(i));
            } else {
                System.out.print(list2.get(i) + ", ");
            }
        }
    }


}

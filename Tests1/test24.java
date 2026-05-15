package Tests;

import java.util.ArrayList;

public class test24 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        list.add("Hello");
        list.add("World");

        System.out.println(list);
    
        list.remove(0);
        list.add(0, "Hi");
        
        System.out.println(list);
    
        String str = list.remove(0);
        
        System.out.println(str);
        System.out.println(list);

        list.clear();
        System.out.println(list);
    }
}

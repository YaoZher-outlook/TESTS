package Tests2;

import java.util.Collections;
import java.util.ArrayList;

public class CollectionTest1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1,3,4,2,35,2,43,422,5,3,32,324,53,475,253,5,0,24,2);

        Collections.shuffle(arr);
        System.out.println(arr);

//        Collections.sort(arr);

//        System.out.println(arr);

        System.out.println(Collections.max(arr));

        Collections.reverse(arr);
        System.out.println(arr);
    }
}
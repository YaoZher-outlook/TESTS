package Tests;

public class test23 {
    public static void main(String[] args) {
        String strA = "abcde";
        String strB = "abcde";

        System.out.println(check(strA, strB));
    }

    public static boolean check(String strA, String strB){
        for (int i = 0; i < strA.length(); i++) {
            strA = rotate(strA);
            if (strA.equals(strB)) {
                return true;
            }
        }
        return false;
    }

    public static String rotate(String str) {
        char first = str.charAt(0);
        str.substring(1);
        String end = str.substring(1);
        String rotated = end + first; 
        return rotated;
    }
}

import java.util.*;

public class test47 {
  public static void main(String[] args) {
    String st =
        "";
    ArrayList<Character> al = new ArrayList<Character>();
    for (int i = 0; i < st.length(); i++) {
      al.add(st.charAt(i));
    }

    HashMap<Character, Integer> hm = new HashMap<>();

    for (Character o : al) {
      if (hm.containsKey(o)) hm.put(o, hm.get(o) + 1);
      else hm.put(o, 1);
    }

    Set<Map.Entry<Character, Integer>> rs = hm.entrySet();
    for (Map.Entry<Character, Integer> entry : rs) {
      System.out.println(entry.getKey() + "(" + entry.getValue() + ")");
    }
  }
}

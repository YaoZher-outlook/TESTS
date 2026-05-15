import java.util.*;

public class test48 {
  public static void main(String[] args) {
    ArrayList<String> votes = new ArrayList<>();
    String[] places = new String[] {"a", "b", "c", "d", "e"};
    Random r = new Random();
    for (int i = 0; i < 100; i++) {
      int index = r.nextInt(places.length);
      votes.add(places[index]);
    }

    HashMap<String, Integer> result = new HashMap<>();
    for (String vote : votes)
      if (result.containsKey(vote)) {
        int count = result.get(vote);
        count++;
        result.put(vote, count);
      } else result.put(vote, 1);

    System.out.println(result);

    Set<Map.Entry<String, Integer>> entries = result.entrySet();
    int max = 0;
    for (Map.Entry<String, Integer> entry : entries) {
      max = max < entry.getValue() ? entry.getValue() : max;
    }
    System.out.println(max);

    for (Map.Entry<String, Integer> entry : entries) {
      if (entry.getValue() == max) System.out.println(entry.getKey());
    }
  }
}

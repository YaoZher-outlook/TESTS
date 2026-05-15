import java.util.*;

public class Main {
  public static void main(String[] args) {
    TreeMap<Student, String> tm = new TreeMap<>();

    Student s1 = new Student("zhangsan", 23);
    Student s2 = new Student("lisi", 24);
    Student s3 = new Student("wangwu", 25);
    Student s4 = new Student("cz", 18);
    Student s5 = new Student("azb", 18);

    tm.put(s1, "云南");
    tm.put(s2, "福建");
    tm.put(s3, "山东");
    tm.put(s4, "四川");
    tm.put(s5, "上海");

    System.out.println(tm);
  }
}

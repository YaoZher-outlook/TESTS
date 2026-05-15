import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        TreeSet<Student> ts = new TreeSet<Student>((o1, o2) -> o1.getAge() - o2.getAge());

        ts.add(s1);
        ts.add(s3);
        ts.add(s2);
    
        System.out.println(ts);
    }
}

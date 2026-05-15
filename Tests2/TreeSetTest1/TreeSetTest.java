import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        
        Student s1 = new Student("Zhangsan", 23);
        Student s2 = new Student("Wangwu", 25);
        Student s3 = new Student("Lisi", 24);

        TreeSet<Student> ts = new TreeSet<Student>();

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        System.out.println(ts);
    }
}
package Tests4_IO.io6_ObjectStream2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 22);
        Student student3 = new Student("Charlie", 23);

        java.io.ObjectOutputStream oos =
        new java.io.ObjectOutputStream(
            new FileOutputStream(
                "E:\\JCHP\\JAVA\\Tests4_IO\\io6_ObjectStream2\\save.txt"
            )
        );

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        oos.writeObject(students);

        oos.close();
    }
}


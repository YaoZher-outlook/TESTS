package Tests4_IO.io6_ObjectStream2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        java.io.ObjectInputStream ois =
        new java.io.ObjectInputStream(
            new FileInputStream("E:\\JCHP\\JAVA\\Tests4_IO\\io6_ObjectStream2\\save.txt")
        );

        ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
        for (Student student : students) {
            System.out.println(student.toString());
        }
        ois.close();

    }
}

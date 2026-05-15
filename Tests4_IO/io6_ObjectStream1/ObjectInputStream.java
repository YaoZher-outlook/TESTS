package Tests4_IO.io6_ObjectStream1;

import java.io.FileInputStream;
import java.io.IOException;

public class ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        java.io.ObjectInputStream ois =
        new java.io.ObjectInputStream(
            new FileInputStream("E:\\JCHP\\JAVA\\Tests4_IO\\io6_ObjectStream\\save.txt")
        );

        Student student = (Student) ois.readObject();
        ois.close();

        System.out.println(student.toString());     
                                    //Student{name='Alice', age=20, address='null'}
                                    // address is transient, so it's null after deserialization
    }
}

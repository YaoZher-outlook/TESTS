package Tests4_IO.io6_ObjectStream1;

import java.io.FileOutputStream;
import java.io.IOException;

public class ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        
        Student student = new Student("Alice", 20, "123 Main St");

        java.io.ObjectOutputStream oos =
        new java.io.ObjectOutputStream(
            new FileOutputStream(
                "E:\\JCHP\\JAVA\\Tests4_IO\\io6_ObjectStream\\save.txt"
            )
        );

        oos.writeObject(student);
        oos.close();
    }
}


import java.lang.reflect.Field;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Alice", 20, "S12345");
        Teacher teacher1 = new Teacher("Mr. Smith", 50000, "Mathematics");

        saveObjectToFile(student1);
        saveObjectToFile(teacher1);
    
    }
    public static void saveObjectToFile(Object obj) throws Exception {
        Class class1 = obj.getClass();
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(obj);
            BufferedWriter writer = new BufferedWriter(new FileWriter("lib\\Info.txt", true));
            writer.write(name + "=" + value.toString());
            writer.newLine();
            writer.close();
        }
    }
}

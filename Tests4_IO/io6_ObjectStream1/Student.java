package Tests4_IO.io6_ObjectStream1;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String address;                       // transient: not serialized

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

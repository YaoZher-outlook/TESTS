package Tests2.ExceptionTest;

public class Girlfriends {
    public String name;
    public int age;
    
    public Girlfriends() {

    }

    public Girlfriends(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        int length = name.length();
        if(length < 3 || length > 15) {
            throw new IllegalArgumentException("Name must be between 3 and 15 characters.");
        }else if(!name.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Name must contain only letters.");
        }else {
            this.name = name;
        }
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age < 18 || age > 30) {
            throw new IllegalArgumentException("Age must be between 18 and 30.");
        }
        this.age = age;
    }
    public String toString() {
        return "Girlfriends [name=" + name + ", age=" + age + "]";
    }
}

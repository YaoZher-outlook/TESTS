public class Student {
    private String name;
    private int age;
    private String studentID;

    public Student() {
        this.name = "Default Name";
        this.age = 18;
        this.studentID = "000000";
    }

    public Student(String name, int age, String studentID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    public void study() {
        System.out.println(name + " is studying.");
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentID() {
        return studentID;
    }
}

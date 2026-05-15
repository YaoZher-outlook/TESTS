public class Teacher {
    private String name;
    private int salary;
    private String subject;

    public Teacher() {
        this.name = "Default Name";
        this.salary = 50000;
        this.subject = "Unknown";
    }

    public Teacher(String name, int salary, String subject) {
        this.name = name;
        this.salary = salary;
        this.subject = subject;
    }

    public void teach() {
        System.out.println(name + " is teaching " + subject + ".");
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }
}

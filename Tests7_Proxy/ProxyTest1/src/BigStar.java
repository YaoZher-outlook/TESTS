public class BigStar implements Star {
    public String name;

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String name) {
        System.out.println(name + " is singing");
        return "Thanks";
    }

    @Override
    public void dance() {
        System.out.println(name + " is dancing");
    }
}

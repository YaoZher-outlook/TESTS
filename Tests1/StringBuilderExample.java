package Tests;
public class StringBuilderExample {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        
        System.out.println(sb.toString());
        System.out.println(sb.length());
        
        sb.reverse();
        
        System.out.println(sb.toString());
        
        StringBuilder sb2 = new StringBuilder();
        String result = sb2.append("Java")
                          .append(" ")
                          .append("Programming")
                          .reverse()
                          .toString();
        System.out.println(result);

    }
}
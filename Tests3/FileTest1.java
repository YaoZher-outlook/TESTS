package Tests3;

import java.io.File;
import java.util.Arrays;

public class FileTest1 {
    public static void main(String[] args) {
        String filePath1 = "E:\\TestFiles";
        File file1 = new File(filePath1);
        File[] arrFiles = file1.listFiles();
        
        Arrays.stream(arrFiles).forEach(file -> {
            if (file.isFile() && file.getName().endsWith(".txt")){
                System.out.println(file.getName());
            }
        });
    }
}

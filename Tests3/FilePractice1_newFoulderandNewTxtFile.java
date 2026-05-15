package Tests3;

import java.io.File;
import java.io.IOException;

public class FilePractice1_newFoulderandNewTxtFile {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\TestFiles\\eee");
        file.mkdir();
        String child = "a.txt";
        File src = new File(file, child);
        boolean result = src.createNewFile();
        if(result){
            System.out.println("File created successfully.");
        }else{
            System.out.println("File creation failed.");
            if(src.exists()){
                System.out.println("File already exists.");
            }
        }
    }
}

package Tests3;

import java.io.File;

public class FilePractice3_showAllTxtFile {
    public static void main(String[] args) {
        File file = new File("D:\\");
        showAllTxtFile(file);
    }

    public static void showAllTxtFile(File file) {
        File[] files = file.listFiles();
        if(files != null){
            for (File f : files) {
            if (f.isFile() && f.getName().endsWith("mp3")) {
                System.out.println(f);
            }else if(f.isDirectory()){
                showAllTxtFile(f);
            }
        }
    }
    }
}
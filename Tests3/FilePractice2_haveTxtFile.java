package Tests3;

import java.io.File;

public class FilePractice2_haveTxtFile {
    public static void main(String[] args) {
        File file = new File("E:\\TestFiles\\eee");
        System.out.println(haveTxtFile(file));
    }

    public static boolean haveTxtFile(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isFile() && f.getName().endsWith(".txt")){
                return true;
            }
        }
        return false;
    }
}

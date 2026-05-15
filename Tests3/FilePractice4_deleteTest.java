package Tests3;

import java.io.File;

public class FilePractice4_deleteTest {
    public static void main(String[] args) {
        File file = new File("E:\\TestFiles\\deleteTest");
        delete(file);
    }

    public static void delete(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isFile()){
                f.delete();
            }else if(f.isDirectory()){
                delete(f);
            }
        }
        file.delete();
    }
}

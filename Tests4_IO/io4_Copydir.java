package Tests4_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class io4_Copydir {
    public static void main(String[] args) throws Exception {
        File sourceDir = new File("E:\\TestFiles\\aaa");
        File destDir = new File("E:\\TestFiles\\bbb\\aaa"); 
        copyDir(sourceDir, destDir);  
    }

    private static void copyDir(File source, File dest) throws Exception {
        dest.mkdirs();
        for(File file : source.listFiles()) {
            if(file.isFile()){
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] buffer = new byte[1024];
                int len;
                while((len = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fis.close();
                fos.close();
            }else{
                copyDir(file, new File(dest, file.getName()));
            }
        }
    }
}

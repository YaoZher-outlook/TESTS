package Tests3;

import java.io.File;  

public class FilePractice5_countFilesLen {
    public static void main(String[] args) {
        File directory = new File("E:\\Videos");
        long LenBytes = countDirectorysLen(directory);
        long LenKBs = LenBytes / 1024;
        long LenMBs = LenKBs / 1024;
        System.out.println(LenMBs);
    }

    public static long countDirectorysLen(File directory) {
        long LenBytes = 0;
        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isFile()){LenBytes = LenBytes + file.length();}
            else{LenBytes = LenBytes + countDirectorysLen(file);}
        }
        return LenBytes;
    }
}

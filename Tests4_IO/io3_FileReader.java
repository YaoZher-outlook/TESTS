package Tests4_IO;

import java.io.FileReader;

public class io3_FileReader {
    public static void main(String[] args) throws Exception {
        /*FileReader fr = new FileReader("E:\\TestFiles\\111.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        fr.close();*/
    
        FileReader fr = new FileReader("E:\\TestFiles\\111.txt");
        char[] ch = new char[2];
        int len;
        while((len = fr.read(ch)) != -1){
            System.out.println(new String(ch, 0, len));
        }
        fr.close();
    }
}

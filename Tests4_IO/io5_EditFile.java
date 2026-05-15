package Tests4_IO;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class io5_EditFile {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\TestFiles\\222.txt");
        FileReader fr = new FileReader(file);
        //ArrayList<Character> list = new ArrayList<>();
        //int b = 0;
        //while ((b = fr.read()) != -1) {
        //    list.add((char)b);
        //}
        //StringBuilder sb = new StringBuilder();
        //for (Character c : list) {  
        //    sb.append(c);
        //}
        //String str = sb.toString();
        //String[] arrStr = str.split("-");
        //Arrays.sort(arrStr);
        //FileWriter fw = new FileWriter(file);
        //for (int i = 0; i < arrStr.length; i++) {
        //    fw.write(arrStr[i]);
        //    if (i != arrStr.length - 1) {
        //        fw.write("-");
        //    }
        //}

        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            sb.append((char)ch);
        }
        fr.close();

        FileWriter fw = new FileWriter(file);
        Integer[] arr = Arrays.stream(sb.toString().split("-"))
              .map(Integer::parseInt)
              .sorted()
              .toArray(Integer[]::new);
        for (int i = 0; i < arr.length; i++) {
            fw.write(arr[i].toString());
            if (i != arr.length - 1) {
                fw.write("-");
            }
        }
        fw.close();
    }
}


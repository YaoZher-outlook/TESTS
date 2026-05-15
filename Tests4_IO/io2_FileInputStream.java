package Tests4_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class io2_FileInputStream {
    public static void main(String[] args) throws IOException{
        //FileInputStream fis = new FileInputStream("E:\\TestFiles\\111.txt");
        //
        //int b;
        //while ((b = fis.read()) != -1) {
        //    System.out.print((char)b);
        //}
        //fis.close();
    
        FileInputStream fis = new FileInputStream("E:\\Videos\\csgo素材\\大厦-匪runboost.mp4");
        FileOutputStream fos = new FileOutputStream("E:\\TestFiles\\222.mp4");
    
        int b;
        long start = System.currentTimeMillis(); // 开始时间
        while((b = fis.read()) != -1) {
            fos.write(b);
        }
        long end = System.currentTimeMillis(); // 结束时间

        fis.close();
        fos.close();

        long elapsed = end - start;
        long millis = elapsed % 1000;
        long totalSeconds = elapsed / 1000;
        long seconds = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long minutes = totalMinutes % 60;
        long hours = totalMinutes / 60;

        System.out.printf("%02d小时%02d分钟%02d秒%03d毫秒%n", hours, minutes, seconds, millis);
    }
}

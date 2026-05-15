package Tests4_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class io2_FileInputStream1 {
    public static void main(String[] args) throws IOException{
        
        FileInputStream fis = new FileInputStream("E:\\Videos\\csgo素材\\大厦-匪runboost.mp4");
        FileOutputStream fos = new FileOutputStream("E:\\TestFiles\\222.mp4");
    
        int len;
        byte[] buffer = new byte[1024 * 1024 * 16]; // 16MB缓冲区
        long start = System.currentTimeMillis(); // 开始时间
        while((len = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
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

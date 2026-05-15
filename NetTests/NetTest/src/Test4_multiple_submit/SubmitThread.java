package Test4_multiple_submit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.UUID;

public class SubmitThread implements Runnable {
    Socket socket;
    String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
    
    public SubmitThread(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("lib\\Target\\" + uuid + ".jpg"));

            int len;
            byte[] bytes = new byte[1024];
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("Succeed!");
            bw.newLine();
            bw.flush();

            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

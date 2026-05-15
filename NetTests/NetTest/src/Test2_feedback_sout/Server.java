package Test2_feedback_sout;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStream os = s.getOutputStream();


        int b;
        while((b = isr.read()) != -1){
            System.out.print((char)b);
        }

        String message = "收到消息了！";
        os.write(message.getBytes());

        s.close();
        ss.close();
    }
}

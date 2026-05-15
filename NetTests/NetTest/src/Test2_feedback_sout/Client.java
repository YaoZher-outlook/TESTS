package Test2_feedback_sout;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        
        while(true){
            String message = sc.nextLine();
            os.write(message.getBytes());
            if("886".equals(message)){
                break;
            }
        }
        socket.shutdownOutput();

        int b;
        while((b = isr.read()) != -1){
            System.out.print((char)b);
        }
        
        sc.close();
        socket.close();
    }
}

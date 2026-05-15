package Test1_mutiple_send;

import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 10003);
        
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        
        while(true){
            System.out.println("Enter message: ");
            String message = sc.nextLine();
            if("886".equals(message)){
                break;
            }
            os.write(message.getBytes());
        }
        sc.close();
        socket.close();
    }
}

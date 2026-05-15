package Test4_multiple_submit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("lib\\Resource\\3A2D6676205CE0244BD2B67980732C79.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        
        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        socket.shutdownOutput();
        bis.close();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.print(br.readLine());
        
        socket.close();
    }
}

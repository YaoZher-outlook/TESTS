package Test3_file_transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();

        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

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
        socket.close();
        serverSocket.close();
    }
}

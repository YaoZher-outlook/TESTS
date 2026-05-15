package Tests4_IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class io1_Bytestream {
    public static void main(String[] args) throws IOException{
        FileOutputStream fos = new FileOutputStream("E:\\TestFiles\\111.txt",true);
        //第二个参数：true开启续写，默认关闭

        //fos.write(98);//b
        
        //byte[] b = {97, 98, 99, 100}; 
        //fos.write(b);                     //abcd
        
        //byte[] b = {97, 98, 99, 100};
        //fos.write(b, 1, 2);               //bc
        
        //String str = "Awsl";
        //byte[] b = str.getBytes();
        //fos.write(b);                     //Awsl

        //String str1 = "Awsl";
        //String str2 = "Xswl";
        //byte[] b1 = str1.getBytes();
        //byte[] b2 = str2.getBytes();
        //fos.write(b1);
        //fos.write(b2);                    //AwslXswl

        //String str1 = "Awsl";
        //String wrap = "\r\n";             //"\r\n"//回车换行
        //String str2 = "Xswl";
        //byte[] b1 = str1.getBytes();
        //byte[] r = wrap.getBytes();
        //byte[] b2 = str2.getBytes();
        //fos.write(b1);
        //fos.write(r);                     //Awsl
        //fos.write(b2);                    //Xswl
        
        String str = "csnmdm";
        String wrap = System.lineSeparator(); //与系统相关的换行符
        byte[] b = str.getBytes();
        byte[] r = wrap.getBytes();
        fos.write(b);                   //csnmdm
        fos.write(r);
        fos.write(b);                    //csnmdm
        fos.close();
    }
}

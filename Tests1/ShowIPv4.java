package Tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShowIPv4 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("ipconfig");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), "GBK"));
            
            String line;
            System.out.println("IPv4地址:");
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("IPv4")) {
                    // 提取IPv4地址部分
                    String[] parts = line.split(":");
                    if (parts.length > 1) {
                        String ip = parts[1].trim();
                        System.out.println(ip);
                    }
                }
            }
            
            reader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
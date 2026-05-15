package Tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyIPv4 {
    
    public static void main(String[] args) {
        try {
            // 执行ipconfig命令
            Process process = Runtime.getRuntime().exec("ipconfig");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), "GBK")); // 使用GBK编码避免中文乱码
            
            String line;
            List<String> ipv4Addresses = new ArrayList<>();
            
            // 读取命令输出
            while ((line = reader.readLine()) != null) {
                // 查找IPv4地址行
                if (line.trim().startsWith("IPv4")) {
                    String ipAddress = extractIPv4Address(line);
                    if (ipAddress != null) {
                        ipv4Addresses.add(ipAddress);
                    }
                }
            }

            process.waitFor();
            
            // 输出找到的IPv4地址
            if (!ipv4Addresses.isEmpty()) {
                System.out.println("找到的IPv4地址:");
                for (String ip : ipv4Addresses) {
                    System.out.println(ip);
                }
                
                // 将IPv4地址复制到剪贴板
                if (copyToClipboard(ipv4Addresses.get(1))) {
                    System.out.println("已复制第二个IPv4地址到剪贴板: " + ipv4Addresses.get(1));
                }
            } else {
                System.out.println("未找到IPv4地址");
            }
            
            reader.close();
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 从字符串中提取IPv4地址
     */
    private static String extractIPv4Address(String line) {
        // 使用正则表达式匹配IPv4地址
        Pattern pattern = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
        Matcher matcher = pattern.matcher(line);
        
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
    
    /**
     * 将文本复制到系统剪贴板
     */
    private static boolean copyToClipboard(String text) {
        try {
            // 创建ProcessBuilder来执行系统命令
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;
            
            if (os.contains("win")) {
                // Windows系统
                pb = new ProcessBuilder("cmd", "/c", "echo", text, "|", "clip");
            } else if (os.contains("mac")) {
                // Mac系统
                pb = new ProcessBuilder("pbcopy");
            } else {
                // Linux系统
                pb = new ProcessBuilder("xclip", "-selection", "clipboard");
            }
            
            Process process = pb.start();
            if (!os.contains("win")) {
                // 对于非Windows系统，需要将文本写入进程的输入流
                process.getOutputStream().write(text.getBytes());
                process.getOutputStream().close();
            }
            
            int exitCode = process.waitFor();
            return exitCode == 0;
            
        } catch (IOException | InterruptedException e) {
            System.err.println("复制到剪贴板失败: " + e.getMessage());
            return false;
        }
    }
}
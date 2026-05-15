package Tests;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class GetIPv4Address {
    public static void main(String[] args) {
        try {
            // 获取IPv4地址
            String ipAddress = getLocalIPv4Address();
            
            if (ipAddress != null) {
                System.out.println("本机IPv4地址: " + ipAddress);
                
                // 复制到剪贴板
                copyToClipboard(ipAddress);
                System.out.println("已自动复制到剪贴板");
            } else {
                System.out.println("未能获取到IPv4地址");
            }
        } catch (Exception e) {
            System.err.println("发生错误: " + e.getMessage());
        }
    }
    
    // 获取本地IPv4地址
    private static String getLocalIPv4Address() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // 跳过回环接口和未启用的接口
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }
                
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.getAddress().length == 4 && !addr.isLoopbackAddress()) {
                        return addr.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static void copyToClipboard(String text) {
        try {
            StringSelection selection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, null);
        } catch (Exception e) {
            System.err.println("复制到剪贴板失败: " + e.getMessage());
        }
    }
}
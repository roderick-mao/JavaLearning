package javase.day1124.Selector;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class SelClient {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("192.168.21.12",8899);
        SocketChannel sc = null;
        try {
            boolean isConnected = false;
            do {
            //创建客户端
            sc = SocketChannel.open();
            //不停地尝试连
                System.out.println("尝试链接服务器"+address.getHostString());
                    try {
                        isConnected = sc.connect(address);
                    } catch (ConnectException e) {
                        System.out.println("无法连接服务器，稍后重试");
                    }
                    if (!sc.isConnected()){
                        sc.close();
                        Thread.sleep(2000);
                    }
            }while (!isConnected);
            System.out.println("连接成功！");
            Scanner scanner = new Scanner(System.in);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            System.out.println("请输入：");
            while (scanner.hasNext()){
                byteBuffer.put(scanner.nextLine().getBytes());
                byteBuffer.flip();
                sc.write(byteBuffer);
                System.out.println("请输入：");
                byteBuffer.flip();
                byteBuffer.limit(byteBuffer.capacity());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

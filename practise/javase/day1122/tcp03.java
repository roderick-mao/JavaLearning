package javase.day1122;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class tcp03 {
    Socket s;


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("========Server=========");
        // 创建客户端套接字
        ServerSocket ss = new ServerSocket(12323);
        /*ThreadGroup tg1 = new ThreadGroup("t1");*/

        Thread t1 = new Thread(()->{
            try (Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            ){
                System.out.println(Thread.currentThread().getName()+"已获取客户端连接");

                String str = null;

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

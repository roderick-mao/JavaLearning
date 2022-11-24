package javase.day1122;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class WriteThread implements Runnable{

    private volatile Socket socket;

    public WriteThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
        ) {
            while (true) {
                System.out.println("请说：");
                String str = sc.nextLine();
                pw.println(str);
                pw.flush();

                if (str.equals("exit")) {
                    break;
                }
            }
        }catch (SocketException ex){
            ex.printStackTrace();
            System.out.println("连接出错");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

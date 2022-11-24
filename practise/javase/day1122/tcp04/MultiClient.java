package javase.day1122.tcp04;

import javase.day1122.ReadThread;
import javase.day1122.WriteThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {

        ThreadPool pool = new ThreadPool(2,3);
        try
        {
            ServerSocket ss = new ServerSocket(12312);
            while (true) {
                Socket s = ss.accept();
                pool.execute(() -> {
                    new Thread(new ReadThread(s)).start();
                    new Thread(new WriteThread(s)).start();
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.21.12", 12312);
            /*new Thread(new ReadThread(socket)).start();
            Thread.sleep(10000);*/
            new Thread(new WriteThread(socket)).start();

        } catch (IOException /*| InterruptedException*/ e) {
            e.printStackTrace();
        }
    }
}

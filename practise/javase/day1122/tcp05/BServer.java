package javase.day1122.tcp05;

import javase.day1122.tcp04.ThreadPool;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 浏览器充当客户端
 * 服务器响应HTML内容
 * HTTP/1.1 200 OK
 * Content-Type: text/html; charset=utf-8
 * 欢迎<ip>上线
 */
public class BServer {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2,2);
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(32188);
            while (true){
                Socket socket = ss.accept();
                pool.execute(()->{
                    try {
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        ps.println("HTTP/1.1 200 OK");
                        ps.println("Content-Type: text/html; charset=utf-8");
                        //响应一个换行符
                        ps.println();
                        ps.println("<html><h1 style='color:red'>欢迎"+socket.getRemoteSocketAddress()+"上线</h1></html>");
                        ps.flush();
                        ps.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("线程出错");
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server出错");
        }finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package javase.day1122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ReadThread implements Runnable{

    private volatile Socket socket;

    public ReadThread(Socket socket){this.socket = socket;}

    @Override
    public void run() {
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String str = null;
            while ((str = br.readLine()) != null) {
                if (str.equals("exit")) {
                    System.out.println(socket.getRemoteSocketAddress() + "已下线");
                    break;
                } else {
                    System.out.println(socket.getRemoteSocketAddress() + "说：" + str);
                }
            }
        }catch(SocketException se){
            se.printStackTrace();
            System.out.println("链接异常");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

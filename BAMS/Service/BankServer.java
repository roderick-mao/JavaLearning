package Service;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 银行网络服务器
 */

public class BankServer implements Runnable{
    private int port;
    private ServerSocket ss;
    private static BankServer bankServer;
    private BankServer(int port){
        try {
            ss = new ServerSocket(port);
            this.port=port;
        }catch (IllegalArgumentException ex){
            System.out.printf("非法端口号！");
        }
        catch (IOException e) {
            System.out.println("服务器套接字启动失败！");
        }

    }

    public static BankServer getInstance(int port){
        if (bankServer==null){
            bankServer = new BankServer(port);
            return bankServer;
        }else if (port != bankServer.getPort()){
            bankServer.changePort(port);
            return bankServer;
        }
        return bankServer;
    }

    public int getPort() {
        return port;
    }

    private void changePort(int port){
        try {
            ss.close();
            ss = new ServerSocket(port);
        } catch (IllegalArgumentException ex) {
            System.out.printf("非法端口号！");
        }
        catch (IOException e) {
            System.out.println("端口关闭异常！");
        }
    }



    @Override
    public void run() {
        BankServer bankServer1 = BankServer.getInstance(22233);

    }
}

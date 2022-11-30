package Service;

import BankException.ATMException;
import BankException.LoginException;
import com.sun.security.ntlm.Server;
import entity.Account;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 银行网络服务器
 */

public class BankServer implements Runnable{

    private Bank bank;
    private int port;
    private ServerSocket ss;
    private static BankServer bankServer;
    private BankServer(int port){
        try {
            ss = new ServerSocket(port);
            this.port=port;
            bank = Bank.getInstance();
        }catch (IllegalArgumentException ex){
            System.out.printf("非法端口号！");
        }
        catch (IOException e) {
            System.out.println("服务器套接字启动失败！");
        } catch (ClassNotFoundException e) {
            System.out.println("初始化本地数据存储失败！");
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


    class listenAndReply implements Runnable{
        @Override
        public void run() {
            while (true) {
                try (Socket s = ss.accept();
                     BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                     ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ) {
                    try {
                        String request = br.readLine();
                        String[] strings = request.split("#");
                        switch (strings[0]){
                            case "DEPOSIT":
                                Account account1 = bank.deposit(new Long(strings[1]),new Double(strings[2]));
                                oos.writeObject(account1);
                                break;
                            case "WITHDRAW":
                                Account account2 = bank.withdraw(new Long(strings[1]),strings[3],new Double(strings[2]));
                                break;
                        }
                    } catch (IOException | ATMException e) {
                        oos.writeObject(e);
                    }
                } catch (IOException e) {
                    //未正常获得连接
                }
            }
        }
    }

    @Override
    public void run() {
        BankServer bankServer1 = BankServer.getInstance(22233);

    }
}

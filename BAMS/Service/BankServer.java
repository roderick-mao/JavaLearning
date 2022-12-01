package Service;

import BankException.ATMException;
import entity.Account;
import entity.AccountType;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 银行网络服务器
 */

public class BankServer extends JFrame {

    private Bank bank;
    private int port;
    private ServerSocket ss;
    private static volatile BankServer bankServer;

    InitPanel initPanel;

    private BankServer(int port) {
        try {
            ss = new ServerSocket(port);
            this.port = port;
            bank = Bank.getInstance();
            Container container = this.getContentPane();
            container.setLayout(new CardLayout());
            initPanel = new InitPanel(this);
            container.add(initPanel);
        } catch (IllegalArgumentException ex) {
            System.out.printf("非法端口号！");
        } catch (IOException e) {
            System.out.println("服务器套接字启动失败！");
        } catch (ClassNotFoundException e) {
            System.out.println("初始化本地数据存储失败！");
        }

    }

    public static BankServer getInstance(int port) {
        if (bankServer == null) {
            synchronized (BankServer.class) {
                if (bankServer == null) {
                    bankServer = new BankServer(port);
                } else if (port != bankServer.getPort()) {
                    bankServer.changePort(port);
                }
            }
        }
        return bankServer;
    }

    public int getPort() {
        return port;
    }

    private void changePort(int port) {
        try {
            ss.close();
            ss = new ServerSocket(port);
        } catch (IllegalArgumentException ex) {
            System.out.printf("非法端口号！");
        } catch (IOException e) {
            System.out.println("端口关闭异常！");
        }
    }

    public Socket accept() throws IOException {
        return ss.accept();
    }

    Runnable listenAndReply = new Runnable() {
        @Override
        public void run() {
            while (true) {
                Socket s = null;
                BufferedReader br = null;
                ObjectOutputStream oos = null;
                try {
                    synchronized (this) {
                        s = accept();
                        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        oos = new ObjectOutputStream(s.getOutputStream());
                    }
                    do {
                        try {
                            String request = br.readLine();
                            String[] strings = request.split("#");
                            switch (strings[0]) {
                                case "DEPOSIT":
                                    Account account1 = bank.deposit(new Long(strings[1]), new Double(strings[2]));
                                    oos.writeObject(account1);
                                    break;
                                case "WITHDRAW":
                                    Account account2 = bank.withdraw(new Long(strings[1]), strings[3], new Double(strings[2]));
                                    oos.writeObject(account2);
                                    break;
                                case "LOGIN":
                                    Account account3 = bank.Login(new Long(strings[1]), strings[3]);
                                    oos.writeObject(account3);
                                    break;
                                case "TRANSFER":
                                    bank.transfer(new Long(strings[1]), strings[3], new Long(strings[4]), new Double(strings[2]));
                                    Account account4 = bank.Login(new Long(strings[1]), strings[3]);
                                    oos.writeObject(account4);
                                    break;
                                case "UPDATE_CEILING":
                                    Account account5 = bank.updateCeiling(new Long(strings[1]), strings[3], new Double(strings[2]));
                                    oos.writeObject(account5);
                                    break;
                                case "REQUEST_LOAN":
                                    Account account6 = bank.requestLoan(new Long(strings[1]), new Double(strings[2]));
                                    oos.writeObject(account6);
                                    break;
                                case "PAY_LOAN":
                                    Account account7 = bank.payLoan(new Long(strings[1]), new Double(strings[2]));
                                    oos.writeObject(account7);
                                    break;
                                case "REGISTER":
                                    Account newAccount = bank.register(strings[2],strings[2],strings[1],
                                            strings[3],strings[4], AccountType.valueOf(strings[5]));
                                    oos.writeObject(newAccount);
                                    break;
                                default:
                                    oos.writeObject(new ATMException("请求类型错误！"));
                                    break;
                            }
                        } catch (IOException | ATMException e) {
                            oos.writeObject(e);
                        }
                    } while (s.isConnected());
                    System.out.println(s.getRemoteSocketAddress() + "连接断开！");
                } catch (IOException e) {
                    System.out.println("连接异常！");
                    try {
                        s.close();
                        br.close();
                        oos.close();
                    } catch (IOException ex) {
                        System.out.println("关闭异常");
                    }
                }
            }
        }
    };




    public static void main(String[] args) {
        bankServer.setVisible(true);
    }
}


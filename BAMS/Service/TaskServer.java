package Service;

import BankException.ATMException;
import entity.Account;
import entity.AccountType;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class TaskServer {
    private Bank bank;
    private int port;
    private ServerSocket ss;
    private volatile static TaskServer taskServer;

    public int getPort() {
        return port;
    }

    private TaskServer(int port) {
        try {
            ss = new ServerSocket(port);
            this.port = port;
            bank = Bank.getInstance();

        } catch (IllegalArgumentException ex) {
            System.out.printf("非法端口号！");
        } catch (IOException e) {
            System.out.println("服务器套接字启动失败！");
        } catch (ClassNotFoundException e) {
            System.out.println("初始化本地数据存储失败！");
        }
    }

    private void changePort(int port) {
        try {
            ss.close();
            ss = new ServerSocket(port);
            this.port = port;
        } catch (IllegalArgumentException ex) {
            System.out.printf("非法端口号！");
        } catch (IOException e) {
            System.out.println("端口关闭异常！");
        }
    }

        public static TaskServer getInstance(int port) {
            if (taskServer == null) {
                synchronized (TaskServer.class) {
                    if (taskServer == null) {
                        taskServer = new TaskServer(port);
                    } else if (port != taskServer.getPort()) {
                        taskServer.changePort(port);
                    }
                }
            }
            return taskServer;
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
                        s = ss.accept();
                        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        oos = new ObjectOutputStream(s.getOutputStream());
                        System.out.println(s.getRemoteSocketAddress()+"已连接");
                    }
                    do {
                        try {
                            String request = br.readLine();
                            String[] strings = request.split("#");
                            switch (strings[0]) {
                                case "DEPOSIT":
                                    Account account1 = bank.deposit(new Long(strings[1]), new Double(strings[2]));
                                    Account account1Copy = (Account) account1.clone();
                                    oos.writeObject(account1Copy);
                                    oos.flush();
                                    break;
                                case "WITHDRAW":
                                    Account account2 = bank.withdraw(new Long(strings[1]), strings[3], new Double(strings[2]));
                                    Account account2Copy = (Account) account2.clone();
                                    oos.writeObject(account2Copy);
                                    oos.flush();
                                    break;
                                case "LOGIN":
                                    Account account3 = bank.Login(new Long(strings[1]), strings[3]);
                                    Account account3Copy = (Account) account3.clone();
                                    oos.writeObject(account3Copy);
                                    oos.flush();
                                    break;
                                case "TRANSFER":
                                    bank.transfer(new Long(strings[1]), strings[3], new Long(strings[4]), new Double(strings[2]));
                                    Account account4 = bank.Login(new Long(strings[1]), strings[3]);
                                    Account account4Copy = (Account) account4.clone();
                                    oos.writeObject(account4Copy);
                                    oos.flush();
                                    break;
                                case "UPDATE_CEILING":
                                    Account account5 = bank.updateCeiling(new Long(strings[1]), strings[3], new Double(strings[2]));
                                    Account account5Copy = (Account) account5.clone();
                                    oos.writeObject(account5Copy);
                                    oos.flush();
                                    break;
                                case "REQUEST_LOAN":
                                    Account account6 = bank.requestLoan(new Long(strings[1]), new Double(strings[2]));
                                    Account account6Copy = (Account) account6.clone();
                                    oos.writeObject(account6Copy);
                                    oos.flush();
                                    break;
                                case "PAY_LOAN":
                                    Account account7 = bank.payLoan(new Long(strings[1]), new Double(strings[2]));
                                    Account account7Copy = (Account) account7.clone();
                                    oos.writeObject(account7Copy);
                                    oos.flush();
                                    break;
                                case "REGISTER":
                                    Account newAccount = bank.register(strings[2],strings[2],strings[1],
                                            strings[3],strings[4], AccountType.valueOf(strings[5]));
                                    Account newCopy = (Account) newAccount.clone();
                                    oos.writeObject(newCopy);
                                    oos.flush();
                                    break;
                                default:
                                    oos.writeObject(new ATMException("请求类型错误！"));
                                    oos.flush();
                            }
                        } catch (IOException | ATMException e) {
                            oos.writeObject(e);
                            oos.flush();
                        }
                    } while (!s.isClosed());
                    System.out.println(s.getRemoteSocketAddress() + "连接断开！");
                } catch (IOException e) {
                    System.out.println("连接异常！");
                }finally{
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

}

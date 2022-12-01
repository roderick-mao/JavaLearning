package NetClient;

import BankException.ATMException;
import Service.Bank;
import entity.Account;
import entity.AccountType;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ATMClient extends JFrame {
     BusinessPanel businessPanel;
     LoginPanel loginPanel;
     MainPanel mainPanel;
     RegisterPanel registerPanel;

     Socket socket;

    public ATMClient(){
        //初始化窗体
        this.setTitle("ATM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,450);
        this.setLocationRelativeTo(getOwner());

        //初始化资源
        do {
            Socket s = null;
            try {
                s = new Socket(InetAddress.getLocalHost(), 32188);
                socket = s;
            } catch (UnknownHostException e) {
                System.out.println("未获取到本地IP");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "无法连接服务器");
                try {
                    s.close();
                } catch (IOException ex) {
                    System.out.println("套接字关闭异常！");
                }
            }
        }while (!socket.isConnected());

        System.out.println("服务器已连接");

        //实例化panel界面

        mainPanel = new MainPanel(this);
        loginPanel = new LoginPanel(this);
        businessPanel = new BusinessPanel(this);
        registerPanel = new RegisterPanel(this);

        //获取窗体容器
        Container container = this.getContentPane();
        //设置窗体容器的布局方式 -- 卡片式布局
        container.setLayout(new CardLayout());
        //将panel添加为卡片
        container.add(mainPanel,"mainPanel");
        container.add(loginPanel,"loginPanel");
        container.add(businessPanel,"businessPanel");
        container.add(registerPanel,"registerPanel");
    }

    public boolean request(RequestType type,Account account,Double money,String passwd,Long to)
            throws ATMException, IOException, ClassNotFoundException {

        Object o;
        try (
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ) {
            bw.write("#" + type.name() + "#" + account.getId() + "#" + money + "#" + passwd +"#"+to.toString());
            o = ois.readObject();
        }catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("实例返回异常！");
        } catch (IOException e) {
            throw new IOException("指令传输异常！");
        }

        if (o instanceof ATMException){
            throw (ATMException) o;

        }else if (o instanceof Account){
            account = (Account) o;
        }
        return true;
    }

    public Account requestRegister(String passwd, String name, String personID, String email, AccountType type) throws ClassNotFoundException, IOException, ATMException {
        Object o;
        try (
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ) {
            bw.write("#REGISTER#"+ name + "#" + passwd +"#"+personID+"#"+name+"#"+type.name());
            o = ois.readObject();
        }catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("实例返回异常！");
        } catch (IOException e) {
            throw new IOException("指令传输异常！");
        }
        if (o instanceof ATMException){
            throw (ATMException) o;
        }else if (o instanceof Account){
            return (Account) o;
        }
        return (Account) o;
    }

    public static void main(String[] args) {
        new ATMClient().setVisible(true);
    }
}

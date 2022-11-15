package ATMClient;

import Service.Bank;
import entity.Account;
import jdk.tools.jmod.Main;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ATMClient extends JFrame {
     BusinessPanel businessPanel;
     LoginPanel loginPanel;
     MainPanel mainPanel;
     RegisterPanel registerPanel;

     Bank bank;
     Account account;

    public ATMClient(){
        //初始化窗体
        this.setTitle("ATM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,650);
        this.setLocationRelativeTo(getOwner());

        //初始化资源
        bank = Bank.getInstance();

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

    public static void main(String[] args) {
        new ATMClient().setVisible(true);
    }
}

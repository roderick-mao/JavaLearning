package javase.day1108;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    //界面数据
    LoginPanel loginPanel;
    MainPanel mainPanel;
    RegisterPanel registerPanel;

    //公共数据
    User user;

    public MyFrame(){
        this.setTitle("界面");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Container container = this.getContentPane();

        container.setLayout(new CardLayout());
        registerPanel  = new RegisterPanel(this);
        loginPanel = new LoginPanel(this);
        mainPanel = new MainPanel(this);

        container.add(loginPanel,"loginPanel");
        container.add(registerPanel,"registerPanel");
        container.add(mainPanel,"mainPanel");
    }

    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}

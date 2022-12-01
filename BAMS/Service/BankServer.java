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


    InitPanel initPanel;

    TaskServer taskServer;

    public BankServer() {

        this.setTitle("ATM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,450);
        this.setLocationRelativeTo(getOwner());

        Container container = this.getContentPane();
        container.setLayout(new CardLayout());
        initPanel = new InitPanel(this);
        container.add(initPanel);
    }


    public static void main(String[] args) {
        new BankServer().setVisible(true);
    }
}


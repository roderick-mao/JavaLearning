/*
 * Created by JFormDesigner on Tue Nov 08 12:07:23 CST 2022
 */

package javase.day1108;

import javase.day01.lp3.Car;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class RegisterPanel extends JPanel {

    private MyFrame my;
    private UserService userService = new UserService();
    public RegisterPanel(MyFrame my) {
        this.my = my;
        initComponents();
    }

    private void backBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"loginPanel");
    }

    private void registerBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());
        String gender = "";

        if(maleBtn.isSelected()){
            gender = maleBtn.getText();
        }else if(femaleBtn.isSelected()){
            gender = femaleBtn.getText();
        }

        if(username!=null && !username.equals("") && password!=null
                && !password.equals("") && !gender.equals("")){
            User user = new User(username, password, gender);
            boolean flag = userService.register(user);
            if (flag){
                JOptionPane.showMessageDialog(null,"注册成功！");
                my.user = user;
                my.loginPanel.initLogin();

                CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
                cardLayout.show(this.getParent(),"loginPanel");


            }

        }else {
            JOptionPane.showMessageDialog(null,"请填写完整资料！");
            passwordField.setText("");
        }

    }

    public void clearRegister(){
        /*passwordField.setText("");
        nameField.setText("");
        maleBtn.*/
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        registerLabel = new JLabel();
        nameLabel = new JLabel();
        passwdLabel = new JLabel();
        nameField = new JTextField();
        backBtn = new JButton();
        registerBtn = new JButton();
        maleBtn = new JRadioButton();
        femaleBtn = new JRadioButton();
        passwordField = new JPasswordField();

        //======== this ========
        setLayout(null);

        //---- registerLabel ----
        registerLabel.setText("\u6ce8  \u518c  \u754c  \u9762");
        registerLabel.setFont(registerLabel.getFont().deriveFont(registerLabel.getFont().getSize() + 4f));
        registerLabel.setBackground(new Color(0x666666));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);
        registerLabel.setBounds(130, 25, 125, 25);

        //---- nameLabel ----
        nameLabel.setText("\u8d26\u53f7\uff1a");
        add(nameLabel);
        nameLabel.setBounds(95, 75, 50, 25);

        //---- passwdLabel ----
        passwdLabel.setText("\u5bc6\u7801\uff1a");
        add(passwdLabel);
        passwdLabel.setBounds(95, 130, 50, 25);

        //---- nameField ----
        nameField.setBackground(new Color(0xcccccc));
        add(nameField);
        nameField.setBounds(170, 75, 130, 30);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backBtnMouseClicked(e);
            }
        });
        add(backBtn);
        backBtn.setBounds(225, 220, 78, 30);

        //---- registerBtn ----
        registerBtn.setText("\u6ce8\u518c");
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerBtnMouseClicked(e);
            }
        });
        add(registerBtn);
        registerBtn.setBounds(90, 220, 78, 30);

        //---- maleBtn ----
        maleBtn.setText("\u7537");
        add(maleBtn);
        maleBtn.setBounds(new Rectangle(new Point(100, 180), maleBtn.getPreferredSize()));

        //---- femaleBtn ----
        femaleBtn.setText("\u5973");
        add(femaleBtn);
        femaleBtn.setBounds(new Rectangle(new Point(215, 180), femaleBtn.getPreferredSize()));

        //---- passwordField ----
        passwordField.setBackground(new Color(0xcccccc));
        passwordField.setForeground(Color.black);
        add(passwordField);
        passwordField.setBounds(170, 125, 135, 35);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(maleBtn);
        buttonGroup1.add(femaleBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel registerLabel;
    private JLabel nameLabel;
    private JLabel passwdLabel;
    private JTextField nameField;
    private JButton backBtn;
    private JButton registerBtn;
    private JRadioButton maleBtn;
    private JRadioButton femaleBtn;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

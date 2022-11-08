/*
 * Created by JFormDesigner on Tue Nov 08 11:41:24 CST 2022
 */

package javase.day1108;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class LoginPanel extends JPanel {

    private MyFrame my;
    private UserService userService = new UserService();

    public LoginPanel(MyFrame my) {
        this.my = my;
        initComponents();
    }

    private void loginBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        String username = nameTextField.getText();
        String userpasswd = passwdTextField.getText();
        if (userpasswd!=null && username!=null &&
                !username.equals("") && !userpasswd.equals("")){
            User user = userService.login(username, userpasswd);
            my.user = user;
            my.mainPanel.initMain();
            JOptionPane.showMessageDialog(null,"登录成功！");

            CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
            cardLayout.show(this.getParent(),"mainPanel");

            clearLogin();
        }else {
            JOptionPane.showMessageDialog(null,"请输入账号密码！");
        }
    }

    public void initLogin(){
        nameTextField.setText(my.user.getName());
    }
    public void clearLogin(){
        nameTextField.setText("");
        passwdTextField.setText("");
    }

    private void registerBtnMouseClicked(MouseEvent e) {
        // TODO add your code here

        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"registerPanel");
        clearLogin();
    }

    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        loginLabel = new JLabel();
        loginBtn = new JButton();
        registerBtn = new JButton();
        nameTextField = new JTextField();
        passwdTextField = new JTextField();
        nameLabel = new JLabel();
        passwdLable = new JLabel();

        //======== this ========
        setLayout(null);

        //---- loginLabel ----
        loginLabel.setText("\u767b \u5f55 \u754c \u9762");
        loginLabel.setFont(loginLabel.getFont().deriveFont(loginLabel.getFont().getSize() + 4f));
        loginLabel.setBackground(new Color(0x666666));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);
        loginLabel.setBounds(140, 45, 125, 25);

        //---- loginBtn ----
        loginBtn.setText("\u767b\u5f55");
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginBtnMouseClicked(e);
            }
        });
        add(loginBtn);
        loginBtn.setBounds(new Rectangle(new Point(90, 235), loginBtn.getPreferredSize()));

        //---- registerBtn ----
        registerBtn.setText("\u6ce8\u518c");
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                registerBtnMouseClicked(e);
            }
        });
        add(registerBtn);
        registerBtn.setBounds(new Rectangle(new Point(245, 235), registerBtn.getPreferredSize()));

        //---- nameTextField ----
        nameTextField.setBackground(new Color(0xcccccc));
        nameTextField.setForeground(Color.black);
        add(nameTextField);
        nameTextField.setBounds(180, 95, 130, nameTextField.getPreferredSize().height);

        //---- passwdTextField ----
        passwdTextField.setBackground(new Color(0xcccccc));
        passwdTextField.setForeground(Color.black);
        add(passwdTextField);
        passwdTextField.setBounds(180, 145, 130, 30);

        //---- nameLabel ----
        nameLabel.setText("\u59d3\u540d\uff1a");
        add(nameLabel);
        nameLabel.setBounds(105, 95, 50, 25);

        //---- passwdLable ----
        passwdLable.setText("\u5bc6\u7801\uff1a");
        add(passwdLable);
        passwdLable.setBounds(105, 150, 50, 25);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel loginLabel;
    private JButton loginBtn;
    private JButton registerBtn;
    private JTextField nameTextField;
    private JTextField passwdTextField;
    private JLabel nameLabel;
    private JLabel passwdLable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

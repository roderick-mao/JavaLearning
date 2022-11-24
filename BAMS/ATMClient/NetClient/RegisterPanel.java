/*
 * Created by JFormDesigner on Tue Nov 15 09:47:56 CST 2022
 */

package ATMClient.NetClient;

import ATMClient.ATMClient;
import BankException.ATMException;
import BankException.LoginException;
import BankException.RegisterException;
import entity.Account;
import entity.AccountType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * @author Brainrain
 */
public class RegisterPanel extends JPanel {

    private ATMClient.NetClient.ATMClient.NetClient.ATMClient atm;

    public RegisterPanel(ATMClient.NetClient.ATMClient.NetClient.ATMClient atm) {
        this.atm = atm;
        initComponents();
    }

    private void commitBtnMouseClicked(MouseEvent e) {
        // TODO add your code here

        /*if (!passwordField1.getPassword().equals(passwordField2.getPassword())){
            JOptionPane.showMessageDialog(null,"两次输入密码不一致！");
            return;
        }*/
        String name = nameText.getText();
        String passwd1 = String.valueOf(passwordField1.getPassword());
        String passwd2 = String.valueOf(passwordField2.getPassword());
        String personID = personIDText.getText();
        String email = emailText.getText();
        int type = accountType.getSelectedIndex();

        try {
            Account a = atm.bank.register(passwd1,passwd2,name,personID,email,AccountType.values()[type]);
            JOptionPane.showConfirmDialog(this.getParent(),"这是您的卡号为："+ a.getId());

            atm.loginPanel.initLogin(a);
            CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
            cardLayout.show(this.getParent(),"loginPanel");
            clear();
        } catch (LoginException | ATMException | RegisterException | NullPointerException | IOException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
        }
    }

    private void clear(){
        nameText.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
        personIDText.setText("");
        adressText.setText("");
        emailText.setText("");
        accountType.setSelectedIndex(0);
    }

    private void backBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"mainPanel");
        clear();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        accountType = new JComboBox<>();
        nameText = new JTextField();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        personIDText = new JTextField();
        adressText = new JTextField();
        emailText = new JTextField();
        commitBtn = new JButton();
        backBtn = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7\u7c7b\u578b\uff1a");
        add(label1);
        label1.setBounds(75, 35, 65, 25);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        add(label2);
        label2.setBounds(75, 70, 65, 25);

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");
        add(label3);
        label3.setBounds(75, 105, 65, 25);

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        add(label4);
        label4.setBounds(75, 140, 65, 25);

        //---- label5 ----
        label5.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
        add(label5);
        label5.setBounds(75, 180, 65, 25);

        //---- label6 ----
        label6.setText("\u8be6\u7ec6\u5730\u5740\uff1a");
        add(label6);
        label6.setBounds(75, 215, 65, 25);

        //---- label7 ----
        label7.setText("E-Mail:");
        add(label7);
        label7.setBounds(75, 250, 65, 25);

        //---- accountType ----
        accountType.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u666e\u901a\u8d26\u6237",
            "\u4fe1\u7528\u5361\u8d26\u6237",
            "\u53ef\u8d37\u6b3e\u8d26\u6237",
            "\u53ef\u8d37\u6b3e\u4fe1\u7528\u5361\u8d26\u6237"
        }));
        accountType.setSelectedIndex(3);
        add(accountType);
        accountType.setBounds(185, 30, 105, accountType.getPreferredSize().height);
        add(nameText);
        nameText.setBounds(185, 65, 110, nameText.getPreferredSize().height);
        add(passwordField1);
        passwordField1.setBounds(185, 105, 110, passwordField1.getPreferredSize().height);
        add(passwordField2);
        passwordField2.setBounds(185, 140, 110, 30);
        add(personIDText);
        personIDText.setBounds(185, 175, 110, 30);
        add(adressText);
        adressText.setBounds(185, 215, 110, 30);
        add(emailText);
        emailText.setBounds(185, 250, 110, 30);

        //---- commitBtn ----
        commitBtn.setText("\u63d0\u4ea4");
        commitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                commitBtnMouseClicked(e);
            }
        });
        add(commitBtn);
        commitBtn.setBounds(new Rectangle(new Point(65, 290), commitBtn.getPreferredSize()));

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backBtnMouseClicked(e);
            }
        });
        add(backBtn);
        backBtn.setBounds(new Rectangle(new Point(210, 290), backBtn.getPreferredSize()));

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JComboBox<String> accountType;
    private JTextField nameText;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField personIDText;
    private JTextField adressText;
    private JTextField emailText;
    private JButton commitBtn;
    private JButton backBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

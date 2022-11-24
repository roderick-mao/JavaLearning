/*
 * Created by JFormDesigner on Tue Nov 15 10:02:46 CST 2022
 */

package ATMClient.NetClient;

import BankException.LoginException;
import entity.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Brainrain
 */
public class LoginPanel extends JPanel {

    private ATMClient atm;
    public LoginPanel(ATMClient atm) {
        this.atm = atm;
        initComponents();
    }

    private void comfirmBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            Long id;
            if (!accountText.getText().equals("")) {
                id = new Long(accountText.getText());
            } else {
                throw new LoginException("账号不能为空！");
            }
            String passwd = String.valueOf(passwordField.getPassword());
            Account account = atm.bank.Login(id, passwd);
            atm.businessPanel.initBusiness(account);
            JOptionPane.showMessageDialog(null, "登录成功！");
            CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
            cardLayout.show(this.getParent(), "businessPanel");
            loginClear();
        } catch (LoginException ex) {
            JOptionPane.showMessageDialog(null,ex.toString());
        }



    }

    public void loginClear(){
        accountText.setText("");
        passwordField.setText("");
    }

    private void cancelBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"mainPanel");
        loginClear();
    }

    public void initLogin(Account e){
        accountText.setText(String.valueOf(e.getId()));
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        comfirmBtn = new JButton();
        cancelBtn = new JButton();
        accountText = new JTextField();
        passwordField = new JPasswordField();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u8d26\u6237\uff1a");
        add(label1);
        label1.setBounds(90, 75, 60, 30);

        //---- label2 ----
        label2.setText("\u7528\u6237\u5bc6\u7801\uff1a");
        add(label2);
        label2.setBounds(90, 145, 60, 30);

        //---- comfirmBtn ----
        comfirmBtn.setText("\u786e\u8ba4");
        comfirmBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                comfirmBtnMouseClicked(e);
            }
        });
        add(comfirmBtn);
        comfirmBtn.setBounds(new Rectangle(new Point(80, 220), comfirmBtn.getPreferredSize()));

        //---- cancelBtn ----
        cancelBtn.setText("\u53d6\u6d88");
        cancelBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelBtnMouseClicked(e);
            }
        });
        add(cancelBtn);
        cancelBtn.setBounds(230, 220, 78, 30);
        add(accountText);
        accountText.setBounds(200, 75, 105, accountText.getPreferredSize().height);
        add(passwordField);
        passwordField.setBounds(200, 150, 105, passwordField.getPreferredSize().height);

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
    private JButton comfirmBtn;
    private JButton cancelBtn;
    private JTextField accountText;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

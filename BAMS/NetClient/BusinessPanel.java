/*
 * Created by JFormDesigner on Tue Nov 15 10:07:05 CST 2022
 */

package NetClient;

import BankException.*;
import entity.Account;
import entity.CreditAccount;
import entity.Loanable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * @author Brainrain
 */
public class BusinessPanel extends JPanel {

    private NetClient.ATMClient atm;

    public BusinessPanel(NetClient.ATMClient atm) {
        this.atm = atm;
        initComponents();
    }

    public void initBusiness(Account e){
        accountLabel.setText(String.valueOf(e.getId()));
        nameLabel.setText(e.getVo().getName());
        restLabel.setText(String.valueOf(e.getBalance()));
        numField.setText("");
        switch (e.getType()){
            case SAVING: {
                String[] s1 = {"存款", "取款", "转账"};
                actionType.setModel(new DefaultComboBoxModel<String>(s1));
                creditLabel.setText("-");
                loanLabel.setText("-");
                break;
            }
            case CREDIT: {
                String[] s2 = {"存款", "取款", "修改额度", "转账"};
                actionType.setModel(new DefaultComboBoxModel<String>(s2));
                creditLabel.setText(String.valueOf(((CreditAccount) e).getRest()));
                loanLabel.setText("-");
                break;
            }
            case LOANSAVING: {
                String[] s3 = {"存款", "取款", "贷款", "还款", "转账"};
                actionType.setModel(new DefaultComboBoxModel<String>(s3));
                loanLabel.setText(String.valueOf(((Loanable) e).getLoan()));
                creditLabel.setText("-");
                break;
            }
            case LOANCREDIT: {
                String[] s4 = {"存款", "取款", "修改额度", "贷款", "还款", "转账"};
                actionType.setModel(new DefaultComboBoxModel<String>(s4));
                creditLabel.setText(String.valueOf(((CreditAccount) e).getRest()));
                loanLabel.setText(String.valueOf(((Loanable) e).getLoan()));
                break;
            }
        }
    }

    private void commitBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        Long id = new Long(accountLabel.getText());
        if (numField.getText() !=null && !numField.getText().equals("")) {
            Double money = new Double(numField.getText());
            switch (actionType.getItemAt(actionType.getSelectedIndex())) {
                case "存款":
                    try {
                        Account a1 = atm.request(RequestType.DEPOSIT,id,money,"",0L);
                        initBusiness(a1);
                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
                case "取款":
                    String passwd1 = JOptionPane.showInputDialog("请输入密码：");
                    try {
                        Account a2 = atm.request(RequestType.WITHDRAW,id,money,passwd1,0L);
                        initBusiness(a2);
                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
                case "贷款":

                    try {
                        Account a3 = atm.request(RequestType.REQUEST_LOAN,id,money,"",0L);
                        initBusiness(a3);
                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
                case "还款":
                    try {
                        Account a4 = atm.request(RequestType.PAY_LOAN,id,money,"",0L);
                        initBusiness(a4);

                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
                case "转账":
                    Long to = new Long(JOptionPane.showInputDialog("请输入目标账户："));
                    String passwd2 = JOptionPane.showInputDialog("请输入密码：");

                    try {
                        Account a5 = atm.request(RequestType.TRANSFER,id,money,passwd2,to);
                        initBusiness(a5);

                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
                case "修改额度":
                    String passwd3 = JOptionPane.showInputDialog("请输入密码：");
                    try {
                        Account a6 = atm.request(RequestType.UPDATE_CEILING,id,money,passwd3,0L);
                        initBusiness(a6);
                    } catch (ATMException | IOException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                    break;
            }
        }else {
            JOptionPane.showMessageDialog(null,"数额不能为空！");
        }
    }

    private void backBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"loginPanel");
        clear();

    }

    private void clear(){
        accountLabel.setText("");
        nameLabel.setText("");
        restLabel.setText("");
        creditLabel.setText("");
        loanLabel.setText("");
        actionType.setModel(new DefaultComboBoxModel<String>());
        numField.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        actionType = new JComboBox<>();
        numField = new JTextField();
        accountLabel = new JLabel();
        nameLabel = new JLabel();
        restLabel = new JLabel();
        creditLabel = new JLabel();
        loanLabel = new JLabel();
        commitBtn = new JButton();
        backBtn = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u6237\uff1a");
        add(label1);
        label1.setBounds(90, 30, 50, 25);

        //---- label2 ----
        label2.setText("\u59d3\u540d\uff1a");
        add(label2);
        label2.setBounds(90, 60, 50, 25);

        //---- label3 ----
        label3.setText("\u4f59\u989d\uff1a");
        add(label3);
        label3.setBounds(90, 90, 50, 25);

        //---- label4 ----
        label4.setText("\u4fe1\u7528\u989d\u5ea6\uff1a");
        add(label4);
        label4.setBounds(90, 120, 65, 25);

        //---- label5 ----
        label5.setText("\u8d37\u6b3e\u989d\uff1a");
        add(label5);
        label5.setBounds(90, 150, 65, 25);

        //---- actionType ----
        actionType.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5b58\u6b3e",
            "\u53d6\u6b3e"
        }));
        actionType.setSelectedIndex(1);
        add(actionType);
        actionType.setBounds(new Rectangle(new Point(90, 200), actionType.getPreferredSize()));
        add(numField);
        numField.setBounds(175, 200, 85, numField.getPreferredSize().height);
        add(accountLabel);
        accountLabel.setBounds(190, 30, 135, 25);
        add(nameLabel);
        nameLabel.setBounds(190, 60, 75, 25);
        add(restLabel);
        restLabel.setBounds(190, 90, 75, 25);
        add(creditLabel);
        creditLabel.setBounds(190, 120, 75, 25);
        add(loanLabel);
        loanLabel.setBounds(190, 150, 75, 25);

        //---- commitBtn ----
        commitBtn.setText("\u63d0\u4ea4");
        commitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                commitBtnMouseClicked(e);
            }
        });
        add(commitBtn);
        commitBtn.setBounds(55, 240, 78, 30);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backBtnMouseClicked(e);
            }
        });
        add(backBtn);
        backBtn.setBounds(200, 240, 78, 30);

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
    private JComboBox<String> actionType;
    private JTextField numField;
    private JLabel accountLabel;
    private JLabel nameLabel;
    private JLabel restLabel;
    private JLabel creditLabel;
    private JLabel loanLabel;
    private JButton commitBtn;
    private JButton backBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

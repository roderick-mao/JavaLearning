/*
 * Created by JFormDesigner on Tue Nov 08 11:46:45 CST 2022
 */

package javase.day1108;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class MainPanel extends JPanel {

    private MyFrame my;
    private UserService userService = new UserService();
    public MainPanel(MyFrame my) {
        this.my  = my;
        initComponents();
    }

    public void initMain(){
        nameField.setText(my.user.getName());
        genderField.setText(my.user.getGender());
    }


    private void backBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"loginPanel");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        mainLabel = new JLabel();
        nameLabel = new JLabel();
        genderLabel = new JLabel();
        backBtn = new JButton();
        nameField = new JTextField();
        genderField = new JTextField();

        //======== this ========
        setForeground(new Color(0xcccccc));
        setLayout(null);

        //---- mainLabel ----
        mainLabel.setText("\u4e3b  \u754c  \u9762");
        mainLabel.setFont(mainLabel.getFont().deriveFont(mainLabel.getFont().getSize() + 4f));
        mainLabel.setBackground(new Color(0x666666));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(mainLabel);
        mainLabel.setBounds(140, 35, 125, 25);

        //---- nameLabel ----
        nameLabel.setText("\u59d3\u540d\uff1a");
        add(nameLabel);
        nameLabel.setBounds(105, 85, 50, 25);

        //---- genderLabel ----
        genderLabel.setText("\u6027\u522b\uff1a");
        add(genderLabel);
        genderLabel.setBounds(105, 140, 50, 25);

        //---- backBtn ----
        backBtn.setText("\u8fd4\u56de");
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backBtnMouseClicked(e);
            }
        });
        add(backBtn);
        backBtn.setBounds(new Rectangle(new Point(160, 225), backBtn.getPreferredSize()));

        //---- nameField ----
        nameField.setEditable(false);
        nameField.setBackground(new Color(0xcccccc));
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setForeground(Color.black);
        add(nameField);
        nameField.setBounds(195, 85, 95, nameField.getPreferredSize().height);

        //---- genderField ----
        genderField.setBackground(new Color(0xcccccc));
        genderField.setForeground(Color.black);
        genderField.setEditable(false);
        genderField.setHorizontalAlignment(SwingConstants.CENTER);
        add(genderField);
        genderField.setBounds(195, 135, 95, 30);

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
    private JLabel mainLabel;
    private JLabel nameLabel;
    private JLabel genderLabel;
    private JButton backBtn;
    private JTextField nameField;
    private JTextField genderField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

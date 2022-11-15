/*
 * Created by JFormDesigner on Tue Nov 15 09:38:14 CST 2022
 */

package ATMClient;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class MainPanel extends JPanel {
    private ATMClient atm;
    public MainPanel(ATMClient atm) {
        this.atm = atm;
        initComponents();
    }

    private void toRegisterMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"registerPanel");
    }

    private void toLoginMouseClicked(MouseEvent e) {
        // TODO add your code here
        CardLayout cardLayout = (CardLayout) this.getParent().getLayout();
        cardLayout.show(this.getParent(),"loginPanel");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        toRegister = new JButton();
        toLogin = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("ATM \u7ec8\u7aef");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        add(label1);
        label1.setBounds(135, 60, 120, 35);

        //---- toRegister ----
        toRegister.setText("\u6ce8\u518c");
        toRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toRegisterMouseClicked(e);
            }
        });
        add(toRegister);
        toRegister.setBounds(new Rectangle(new Point(80, 190), toRegister.getPreferredSize()));

        //---- toLogin ----
        toLogin.setText("\u767b\u5f55");
        toLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toLoginMouseClicked(e);
            }
        });
        add(toLogin);
        toLogin.setBounds(new Rectangle(new Point(245, 190), toLogin.getPreferredSize()));

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
    private JButton toRegister;
    private JButton toLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

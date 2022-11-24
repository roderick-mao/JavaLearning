/*
 * Created by JFormDesigner on Wed Nov 23 20:36:58 CST 2022
 */

package Service;

import java.awt.*;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class InitPanel extends JPanel {
    public InitPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("ATM \u670d\u52a1\u5668");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 9f));
        add(label1);
        label1.setBounds(140, 45, 130, 45);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Mon Nov 07 15:55:22 CST 2022
 */

package javase.day1107;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class Demo1107 extends JFrame {
    public Demo1107() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        spinner1 = new JSpinner();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        button1 = new JButton();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("t1");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[30]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        contentPane.add(spinner1, "cell 0 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, "cell 2 2");

        //---- button1 ----
        button1.setText("b1");
        contentPane.add(button1, "cell 2 6");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JSpinner spinner1;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JButton button1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

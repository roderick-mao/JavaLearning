/*
 * Created by JFormDesigner on Wed Nov 23 20:36:58 CST 2022
 */

package Service;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class InitPanel extends JPanel {

    BankServer bankServer;
    public InitPanel(BankServer bankServer) {
        this.bankServer = bankServer;
        initComponents();
    }

    boolean isStart = false;
    ThreadPool pool = null;




    private void stopBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
        if (isStart == true && pool != null && bankServer.taskServer != null){
            pool.stopAll();
            bankServer.taskServer = null;
            JOptionPane.showMessageDialog(null,"服务器已经停止工作！");
        }else {
            JOptionPane.showMessageDialog(null,"服务器未启动");
        }
        startBtn.setEnabled(true);
        stopBtn.setEnabled(false);
    }

    private void startBtnMouseClicked(MouseEvent e) {
        pool = new ThreadPool(5,5);
        bankServer.taskServer = TaskServer.getInstance(32188);
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true );
        isStart = true;
        JOptionPane.showMessageDialog(null,"服务器已经启动！");
        while (isStart){
            pool.execute(bankServer.taskServer.listenAndReply);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        startBtn = new JButton();
        stopBtn = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("ATM \u670d\u52a1\u5668");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 9f));
        add(label1);
        label1.setBounds(140, 45, 130, 45);

        //---- startBtn ----
        startBtn.setText("\u542f\u52a8");
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startBtnMouseClicked(e);
            }
        });
        add(startBtn);
        startBtn.setBounds(new Rectangle(new Point(70, 205), startBtn.getPreferredSize()));

        //---- stopBtn ----
        stopBtn.setText("\u505c\u6b62");
        stopBtn.setEnabled(false);
        stopBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stopBtnMouseClicked(e);
            }
        });
        add(stopBtn);
        stopBtn.setBounds(new Rectangle(new Point(260, 205), stopBtn.getPreferredSize()));

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
    private JButton startBtn;
    private JButton stopBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

package BingoGameGUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author zahid
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    ImageIcon imageBingo = new ImageIcon("bingo-game.png");
    GameFrame gameFrame;

    public MainFrame() {
        initComponents();
        ImageLabel.setIcon(imageBingo);
        isRandomCheckBox.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJPanel = new javax.swing.JPanel();
        HeaderJPanel = new javax.swing.JPanel();
        HeaderJLabel = new javax.swing.JLabel();
        ImageJPanel = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();
        SettingsPanel = new javax.swing.JPanel();
        PlayerCountLabel = new javax.swing.JLabel();
        PlayingButton = new Custom_GUI_Components.CustomJButton();
        txtPlayerCount = new javax.swing.JTextField();
        isRandomCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainJPanel.setBackground(new java.awt.Color(95, 158, 160));
        MainJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainJPanel.setMinimumSize(new java.awt.Dimension(1172, 615));
        MainJPanel.setPreferredSize(new java.awt.Dimension(1172, 615));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderJPanel.setBackground(new java.awt.Color(95, 158, 160));
        HeaderJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HeaderJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderJLabel.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        HeaderJLabel.setForeground(new java.awt.Color(0, 0, 0));
        HeaderJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderJLabel.setText("WELCOME TO BINGO GAME");
        HeaderJPanel.add(HeaderJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 90));

        MainJPanel.add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1080, 90));

        ImageJPanel.setBackground(new java.awt.Color(95, 158, 160));
        ImageJPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ImageJPanel.setForeground(new java.awt.Color(95, 158, 160));
        ImageJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageJPanel.add(ImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 612, 400));

        MainJPanel.add(ImageJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 612, 398));

        SettingsPanel.setBackground(new java.awt.Color(95, 158, 160));
        SettingsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SettingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayerCountLabel.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        PlayerCountLabel.setForeground(new java.awt.Color(0, 0, 0));
        PlayerCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PlayerCountLabel.setText("Please Enter Your Player Count :");
        SettingsPanel.add(PlayerCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 330, 40));

        PlayingButton.setBackground(new java.awt.Color(95, 158, 160));
        PlayingButton.setForeground(new java.awt.Color(0, 0, 0));
        PlayingButton.setText("Click for playing");
        PlayingButton.setToolTipText("");
        PlayingButton.setBorderColor(new java.awt.Color(255, 255, 255));
        PlayingButton.setColorClick(new java.awt.Color(95, 158, 160));
        PlayingButton.setColorOver(new java.awt.Color(95, 158, 160));
        PlayingButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PlayingButton.setRadius(40);
        PlayingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayingButtonActionPerformed(evt);
            }
        });
        SettingsPanel.add(PlayingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, 50));

        txtPlayerCount.setBackground(new java.awt.Color(95, 158, 160));
        txtPlayerCount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPlayerCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SettingsPanel.add(txtPlayerCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 50, 40));

        isRandomCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        isRandomCheckBox.setForeground(new java.awt.Color(0, 0, 0));
        isRandomCheckBox.setText("Generate Tombala Cards Randomly");
        isRandomCheckBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SettingsPanel.add(isRandomCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        MainJPanel.add(SettingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, 410, 400));

        getContentPane().add(MainJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1172, 615));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void PlayingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayingButtonActionPerformed
        try {
            int playerCount = Integer.parseInt(txtPlayerCount.getText());
            boolean isRandom = isRandomCheckBox.isSelected();
            if (playerCount > 0 && playerCount <= 4) {
                if (gameFrame == null) {
                    gameFrame = new GameFrame(playerCount, isRandom);
                }
                gameFrame.setIsRandom(isRandomCheckBox.isSelected());
                gameFrame.setLocationRelativeTo(null); //It allows the GameFrame to open in the middle of the screen
                gameFrame.show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a number of players between 1 and 4!", "Error", JOptionPane.ERROR_MESSAGE);
                txtPlayerCount.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
            txtPlayerCount.setText("");
        }

    }//GEN-LAST:event_PlayingButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setLocationRelativeTo(null);//It allows the MainFrame to open in the middle of the screen
                mainFrame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeaderJLabel;
    private javax.swing.JPanel HeaderJPanel;
    private javax.swing.JPanel ImageJPanel;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JLabel PlayerCountLabel;
    private Custom_GUI_Components.CustomJButton PlayingButton;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JCheckBox isRandomCheckBox;
    private javax.swing.JTextField txtPlayerCount;
    // End of variables declaration//GEN-END:variables

}

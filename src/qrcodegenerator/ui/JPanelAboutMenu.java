/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.ui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JButton;

/**
 *
 * @author RESEARCH2
 */
public class JPanelAboutMenu extends javax.swing.JPanel {

    /**
     * Creates new form JPanelAboutMenu
     */
    public JPanelAboutMenu() {
        initComponents();
        addColorSchemeBtnListener();
    }

    public void addAboutBtnActionListener(ActionListener al) {
        jButtonAbout.addActionListener(al);
    }

    public void addLicenseBtnActionListener(ActionListener al) {
        jButtonLicense.addActionListener(al);
    }

    /**
     * *
     * Add mouse listener for all the buttons on the top panel
     *
     */
    public final void addColorSchemeBtnListener() {
        for (Component comp : this.getComponents()) {
            if (comp instanceof JButton) {
                JButton jbtn = (JButton) comp;
                jbtn.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        JButton jbtn = (JButton) e.getComponent();
                        jbtn.setOpaque(true);
                        repaint();
                        System.out.println("mouse entered");
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        JButton jbtn = (JButton) e.getComponent();
                        jbtn.setOpaque(false);
                        repaint();
                        System.out.println("mouse left");
                    }
                });
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLicense = new javax.swing.JButton();
        jButtonAbout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButtonLicense.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButtonLicense.setText("License");
        jButtonLicense.setBorderPainted(false);
        jButtonLicense.setContentAreaFilled(false);
        jButtonLicense.setFocusPainted(false);
        jButtonLicense.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonLicense.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButtonAbout.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jButtonAbout.setText("About QR Generator");
        jButtonAbout.setBorderPainted(false);
        jButtonAbout.setContentAreaFilled(false);
        jButtonAbout.setFocusPainted(false);
        jButtonAbout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qrcodegenerator/resources/default.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Scan this QR to get acess to the source code");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbout;
    private javax.swing.JButton jButtonLicense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

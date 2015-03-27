/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import qrcodegenerator.models.GeneratorModel;
import qrcodegenerator.ui.JDialogInfo;
import qrcodegenerator.ui.JDialogSuccess;
import qrcodegenerator.ui.JFrameGenerator;
import qrcodegenerator.utils.Desktop;
import qrcodegenerator.utils.OpenFileFilter;

/**
 *
 * @author RESEARCH_2
 */
public class GeneratorController {
    
    private final JFrameGenerator view;
    private final GeneratorModel model;
    private JDialogInfo info;
    private JDialogSuccess success;
    
    public GeneratorController(JFrameGenerator jgView, GeneratorModel gmModel) {
        this.view = jgView;
        this.model = gmModel;
        this.info = new JDialogInfo(view, false);
        this.success = new JDialogSuccess(view, false);
        view.addPanelOnMousePressed(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                view.setInitialPoint(e.getPoint());
            }
        });
        view.addPanelOnMouseDragged(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                view.updateFrameLocation(e.getLocationOnScreen());
                view.moveFrameToNewLoc(e);
            }
        });
        view.addBtnAboutActionPerformed(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //view.setAboutDialog();
            }
        });
        view.addBtnNewQRActionPerformed(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                view.newQRCode();
                view.showOpen(false);
                view.showJPanel(false);
            }
        });
        view.addBtnGenerateActionPerformed(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showOpen(false);
                if (view.getData().isEmpty()) {
                    info.setLocation(view.getjTextAreaData());
                    info.setInfoText("Please enter some text!");
                    info.setVisible(true);
                } else {
                    //view.newQRCode();
                    if (!view.getjTextAreaData().getText().isEmpty()) {
                        view.newQRCode(true);
                    }
                    view.showJPanel(true);
                    new Generator().start();
                    
                }
            }
        });
        view.addBtnExportActionPerformed(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String QRPath = null;
                if (!view.isShowOpen()) {
                    final JFileChooser fc = new JFileChooser();
                    fc.addChoosableFileFilter(new OpenFileFilter("png", "PNG image"));
                    int returnVal = fc.showSaveDialog(view);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File f = fc.getSelectedFile();
                        QRPath = f.getAbsolutePath();
                        model.exportQRImage(f.getAbsolutePath());
                        success.setInfoText("<html><p align=\"center\">QR Image<br> saved!</p>");
                        success.setLocation(view.getjButtonExport(), true);
                        success.setVisible(true);
                        view.showOpen(true);
                    }
                    
                } else {
                    Desktop.open(model.getQRImage());
                }
            }
        });
        view.addNavBtnMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                jbtn.setBackground(view.getUIColor());
                jbtn.setOpaque(true);
                view.getColorMenu().setVisible(false);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                jbtn.setOpaque(false);
            }
        });
        view.addColorBtnMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                jbtn.setBackground(view.getUIColor());
                view.showPopup(e);
                jbtn.setOpaque(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                if (view.getColorMenu().isShowing()) {
                    jbtn.setOpaque(true);
                } else {
                    jbtn.setOpaque(false);
                }
            }
        });
        view.getJpcs().addBtnActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jbtn = (JButton) e.getSource();
                view.setUIColor(jbtn.getName());
                view.getColorMenu().setVisible(false);
                view.repaint();
            }
        });
        view.getJpam().addAboutBtnActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jbtn = (JButton) e.getSource();
                view.getHelpMenu().setVisible(false);
                view.setHelpOpaqueness(false);
                view.repaint();
                view.setAboutDialog();
            }
        });
        view.getJpam().addLicenseBtnActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jbtn = (JButton) e.getSource();
                view.getHelpMenu().setVisible(false);
                view.setHelpOpaqueness(false);
                view.repaint();
                view.setLicenseDialog();
            }
        });
        view.addHelpBtnMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                jbtn.setBackground(view.getUIColor());
                view.showHelpPopup(e);
                jbtn.setOpaque(true);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton jbtn = (JButton) e.getComponent();
                if (view.getHelpMenu().isShowing()) {
                    jbtn.setOpaque(true);
                    //view.getHelpMenu().setVisible(false);
                } else {
                    jbtn.setOpaque(false);
                    //view.getHelpMenu().setVisible(false);
                }
            }
        });
        view.addHelpPoupListener(new PopupMenuListener() {
            
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
                
            }
            
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {             
                view.setHelpOpaqueness(false);
            }
            
            @Override
            public void popupMenuCanceled(PopupMenuEvent arg0) {
                view.setHelpOpaqueness(false);
            }
        });
    }
    
    private class Generator extends Thread {
        
        int xCounter = 0;
        int yCounter = 55;
        boolean generating = true;
        
        @Override
        public void run() {
            while (generating) {
                try {
                    System.out.println("ssssss" + xCounter);
                    view.setPreviewText("Gen' pixel at co-ord [ " + xCounter + ", " + yCounter + " ]");
                    if (xCounter == 50) {
                        generating = false;
                        view.setPreviewText(null);
                        generate();
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                xCounter++;
                yCounter--;
            }
        }
    }
    
    private void generate() {
        model.setQRData(view.getData());
        model.generateQRCode();
        if (!model.getQRImage().isEmpty()) {
            view.loadNewQRImage(model.getQRImage());
            view.getjPanelMiddleRight().setVisible(true);
            view.setExportVisible(true);
            success.setInfoText("<html><p align=\"center\">QR Image<br> generated!</p>");
            success.setLocation(view.getjLabelQRPreview());
            success.setVisible(true);
        }
        
    }
}

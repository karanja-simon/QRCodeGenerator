/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator;

import qrcodegenerator.controllers.GeneratorController;
import qrcodegenerator.models.GeneratorModel;
import qrcodegenerator.ui.JFrameGenerator;

/**
 *
 * @author RESEARCH_2
 */
public class QRCodeGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrameGenerator jfg = new JFrameGenerator();
                GeneratorModel gm = new GeneratorModel();
                GeneratorController gc = new GeneratorController(jfg, gm);
                jfg.setVisible(true);
            }
        });
    }

}

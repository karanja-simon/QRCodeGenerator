/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.utils;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author RESEARCH_2
 */
public class Desktop {

    public static void open(String path) {
        try {
            System.out.println(path);
            java.awt.Desktop.getDesktop().open(new File(path));
        } catch (IOException ex) {
            System.out.println("unable to open:" + ex.getMessage());
        }
    }
}

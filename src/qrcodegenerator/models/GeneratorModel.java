/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.models;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import qrcodegenerator.utils.QRGenerator;

/**
 *
 * @author RESEARCH_2
 */
public class GeneratorModel {

    private String QRData;
    private String QRImage;

    public String getQRImage() {
        return QRImage;
    }

    public String getQRData() {
        return QRData;
    }

    public void setQRData(String data) {
        this.QRData = data;
    }

    @Override
    public String toString() {
        return "GeneratorModel{" + "data=" + QRData + '}';
    }

    public void generateQRCode() {
        System.out.println(toString());
        if (QRGenerator.generateQRImage(QRData)) {
            this.QRImage = QRGenerator.getGeneratedQR();
        }
    }

    public void exportQRImage(String destPath) {
        File dest = new File(destPath);
        try {
            if (!destPath.endsWith(".jpg")) {
                dest = new File(destPath + ".jpg");
            }
            FileUtils.copyFile(new File(QRImage), dest);
            QRImage = dest.getAbsolutePath();
        } catch (IOException iOException) {
            System.out.println(iOException);
        }
    }
}

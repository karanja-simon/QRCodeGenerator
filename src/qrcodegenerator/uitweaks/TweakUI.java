/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qrcodegenerator.uitweaks;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class TweakUI {
    private static Point initialClick;
    
    public static void centerParent(JDialog parent)
    {
        parent.setLocationRelativeTo(null);
    }
    public static void centerParent(JFrame parent)
    {
        parent.setLocationRelativeTo(null);
    }    
    public static void onMouseDragged(JFrame parent, MouseEvent evt) {
        // get location of Window
        int thisX = parent.getLocation().x;
        int thisY = parent.getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        parent.setLocation(X, Y);
    }
    public static void onMousePressed(JFrame parent, MouseEvent evt)
    {
        initialClick = evt.getPoint();
        parent.getComponentAt(initialClick);        
    }
        public static void onMouseDragged(JDialog parent, MouseEvent evt) {
        // get location of Window
        int thisX = parent.getLocation().x;
        int thisY = parent.getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        parent.setLocation(X, Y);
    }
    public static void onMousePressed(JDialog parent, MouseEvent evt)
    {
        initialClick = evt.getPoint();
        parent.getComponentAt(initialClick);        
    }
}


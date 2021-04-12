package org.launhcode.healthynutrition.models;

import javax.swing.JOptionPane; //imports
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Calendar {

    public static void main(String[] args){
        JFrame f = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setUndecorated(true);
        ImageIcon image = new ImageIcon("calorie-calendar.png");
        JLabel lbl = new JLabel(image);
        f.getContentPane().add(lbl);
        f.setSize(image.getIconWidth(), image.getIconHeight());
        int x = (screenSize.width - f.getSize().width)/2;
        int y = (screenSize.height - f.getSize().height)/2;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocation(x, y); //sets the location of the jframe
        f.setVisible(true); //makes the jframe visible

    }
}

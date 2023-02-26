/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converterEjemplo;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author adbiel valdivia
 */
public class FondoPanel extends JPanel{
    private Image image;

    @Override
    public void paint(Graphics g) {
        image = new ImageIcon(getClass().getResource("/images/bgmoneda.png")).getImage();
        g.drawImage(image,0,0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}

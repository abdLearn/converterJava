/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.converterEjemplo;

import java.awt.Component;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author adbiel valdivia
 */
public class ComboBoxCustom extends JLabel implements ListCellRenderer{

    HashMap<Object, ImageIcon> elementos;
    ImageIcon imagen = new ImageIcon(this.getClass().getResource("/images/peru.png"));

    public ComboBoxCustom(HashMap<Object, ImageIcon> elementos ) {
        this.elementos = elementos;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if(elementos.get(value) == null){
            setIcon(imagen);
        }else{
            setIcon(elementos.get(value));
        }
        setText(value.toString());
        return this;
    }
    
}

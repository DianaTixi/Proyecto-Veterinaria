/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad7101
 */
public class VAgregarMascota extends JInternalFrame implements ActionListener{
    
    public VAgregarMascota(){
        initComponentes();
        ventanaAgregarMas();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Agregar Mascotas");
    }
    
    private JButton b1;
    private JButton b2;
    
    public void ventanaAgregarMas(){
        
        Container cp = getContentPane();
        GridBagConstraints g1 = new GridBagConstraints();       
        cp.setLayout(new GridBagLayout()); 
        
        JLabel l8 = new JLabel("Cédula Dueño:");
        g1.gridx =0;
        g1.gridy =0;
        cp.add(l8, g1);
        
        JTextField t1 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =0;
        cp.add(t1, g1);
        
        JLabel l1 = new JLabel("Nombre:");
        g1.gridx =0;
        g1.gridy =1;
        cp.add(l1, g1);
        
        JTextField t7 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =1;
        cp.add(t7, g1);
        
        JLabel l2 = new JLabel("Especie:");
        g1.gridx =0;
        g1.gridy =2;
        cp.add(l2, g1);
        
        JTextField t2 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =2;
        cp.add(t2, g1);
        
        JLabel l3 = new JLabel("Raza:");
        g1.gridx =0;
        g1.gridy =3;
        cp.add(l3, g1);
        
        JTextField t3 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =3;
        cp.add(t3, g1);
        
        JLabel l4 = new JLabel("Género:");
        g1.gridx =0;
        g1.gridy =4;
        cp.add(l4, g1);
        
        JTextField t4 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =4;
        cp.add(t4, g1);
        
        JLabel l5 = new JLabel("Color:");
        g1.gridx =0;
        g1.gridy =5;
        cp.add(l5, g1);
        
        JTextField t5 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =5;
        cp.add(t5, g1);
        
        JLabel l7 = new JLabel("Año de Nacimiento:");
        g1.gridx =0;
        g1.gridy =6;
        cp.add(l7, g1);
        
        JTextField t6 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =6;
        cp.add(t6, g1);
        
        b1 = new JButton("Volver");
        g1.gridx = 0;
        g1.gridy = 7;
        b1.addActionListener(this);
        b1.setActionCommand("volver");
        cp.add(b1, g1);
        
        b2 = new JButton("Registrar");
        g1.gridx = 1;
        g1.gridy = 7;
        b2.addActionListener(this);
        b2.setActionCommand("registrar");
        cp.add(b2, g1); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){ 
            case "volver":
                setVisible(false);
                break;
                
            case "registrar":
                break;
 
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        setSize(1000,500);
        setTitle("Agregar Mascotas");
        setClosable(true);
        setMaximizable(true);
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JComboBox<String> c1;
    private JLabel l9;
    private JLabel l10;
    private JLabel l11;
    private JLabel l12; 
    private JYearChooser yc;
    
    public void ventanaAgregarMas(){
        
        Container cp = getContentPane();   
        cp.setLayout(new BorderLayout()); 
        
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        
        JLabel l8 = new JLabel("Cédula Dueño:");
        p1.add(l8);
        
        JTextField t1 = new JTextField(12);
        p1.add(t1);
        
        b3 = new JButton("Buscar");
        p1.add(b3);
        
        Panel p2 = new Panel();
        GridBagConstraints g1 = new GridBagConstraints();
        p2.setLayout(new GridBagLayout());
        
        l9 = new JLabel("Juan Hernandez");
        g1.gridx =0;
        g1.gridy =0;
        g1.gridwidth =2;
        p2.add(l9, g1);
        
        l10 = new JLabel("Teléfono");
        g1.gridx =2;
        g1.gridy =0;
        g1.gridwidth =2;
        p2.add(l10, g1);
        
        l12 = new JLabel("Dirección");
        g1.gridx =4;
        g1.gridy =0;
        g1.gridwidth =2;
        p2.add(l12, g1);
        
        JLabel l1 = new JLabel("Nombre:");
        g1.gridx =0;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l1, g1);
        
        JTextField t7 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(t7, g1);
        
        JLabel l2 = new JLabel("Especie:");
        g1.gridx =2;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l2, g1);
        
        JTextField t2 = new JTextField(10);
        g1.gridx =3;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(t2, g1);
        
        JLabel l3 = new JLabel("Raza:");
        g1.gridx =4;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l3, g1);
        
        JTextField t3 = new JTextField(10);
        g1.gridx =5;
        g1.gridy =1;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(t3, g1);
        
        JLabel l4 = new JLabel("Género:");
        g1.gridx =0;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l4, g1);
        
        c1 = new JComboBox<>();
            c1.addItem("Macho");
            c1.addItem("Hembra");
        g1.gridx =1;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(c1, g1);
        
        JLabel l5 = new JLabel("Color:");
        g1.gridx =2;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l5, g1);
        
        JTextField t5 = new JTextField(10);
        g1.gridx =3;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(t5, g1);
        
        JLabel l7 = new JLabel("Año de Nacimiento:");
        g1.gridx =4;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(l7, g1);
        
        yc = new JYearChooser();
        g1.gridx =5;
        g1.gridy =2;
        g1.fill = GridBagConstraints.HORIZONTAL;
        p2.add(yc, g1);
        
        Panel p3 = new Panel();
        p3.setLayout(new FlowLayout());
        
        b1 = new JButton("Volver");
        b1.addActionListener(this);
        b1.setActionCommand("volver");
        p3.add(b1, g1);
        
        b2 = new JButton("Registrar");
        b2.addActionListener(this);
        b2.setActionCommand("registrar");
        p3.add(b2, g1); 
        
        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.SOUTH);
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
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
                break;
 
        }
    }
}

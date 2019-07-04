/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Usuario
 */
public class VBusquedaHistorial extends JInternalFrame implements ActionListener{
    private JTextArea a1 ;
    private JTextArea a2 ;
    private JButton b1;
    
    public VBusquedaHistorial(){
        initComponentes();
        ventanaBusquedaHistorial();
        
    }
    public void initComponentes(){
        setSize(500,500);
        setClosable(true);
	setMaximizable(true);
        setTitle("Ventana Busqueda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void ventanaBusquedaHistorial() {
        Container cp = getContentPane();
	cp.setLayout(new java.awt.GridBagLayout());
        Font fuente = new Font("Times New Roman", 3, 10);
	//Panel 1
	JPanel panel1 = new JPanel();
		panel1.setLayout(new java.awt.GridBagLayout());
                javax.swing.border.Border loweredlevel = BorderFactory.createLoweredBevelBorder();
                TitledBorder titulo1;
		titulo1 = BorderFactory.createTitledBorder("Diagnostico");
		titulo1.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel1.setBorder(titulo1);
                
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		gbcPanel1.gridx=0;
		gbcPanel1.gridy=0;
                gbcPanel1.gridwidth=1;
		
		cp.add(panel1, gbcPanel1);
                
                GridBagConstraints gbDiagnostico = new GridBagConstraints();
		
		a1= new JTextArea(20,20);
                gbDiagnostico.gridx=0;
		gbDiagnostico.gridy=0;
                gbDiagnostico.ipadx=200;
                gbDiagnostico.ipady=200;
		panel1.add(a1, gbDiagnostico);
                
        
        //Panel 2
                JPanel panel2 = new JPanel();
		panel2.setLayout(new java.awt.GridBagLayout());
                TitledBorder titulo2;
		titulo2 = BorderFactory.createTitledBorder("Receta");
		titulo2.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel2.setBorder(titulo2);
                
		GridBagConstraints gbcPanel2 = new GridBagConstraints();
		gbcPanel2.gridx=1;
		gbcPanel2.gridy=0;
                gbcPanel2.gridwidth=3;
		
		cp.add(panel2, gbcPanel2);
                GridBagConstraints gbReceta = new GridBagConstraints();
		
		a1= new JTextArea(20,20);
                gbReceta.gridx=1;
		gbReceta.gridy=0;
                gbReceta.ipadx=200;
                gbReceta.ipady=200;
		panel2.add(a1, gbReceta);
                
        // Panel 3
                JPanel panel4 = new JPanel();
		panel4.setLayout(new java.awt.GridBagLayout());
                TitledBorder titulo4;
		titulo4 = BorderFactory.createTitledBorder("");
		titulo4.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel4.setBorder(titulo4);
                
		GridBagConstraints gbcPanel4 = new GridBagConstraints();
		gbcPanel4.gridx=0;
		gbcPanel4.gridy=4;
                gbcPanel4.gridwidth =2;
		
		cp.add(panel4, gbcPanel4);
		
		GridBagConstraints gbVolver = new GridBagConstraints();
		
		b1= new JButton("Volver");
		gbVolver.gridx=0;
		gbVolver.gridy=5;
                b1.addActionListener(this);
                b1.setActionCommand("volver");
		panel4.add(b1, gbVolver);
	
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String comando = e.getActionCommand();
		System.out.println(comando);
		switch (comando) {
		case "volver":
			this.setVisible(false);
                        llamarVentanaHistorial(getDesktopPane());
			break;

		default:
			break;  
                }
    }

    private void llamarVentanaHistorial(JDesktopPane escritorioM) {
        VHistorial vH = new  VHistorial();
        vH.setVisible(true);
        this.setVisible(false);
        escritorioM.add(vH);
        try {
			vH.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
        }
    
}

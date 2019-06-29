/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 *
 * @author Usuario
 */
public class VDiagnostico extends JInternalFrame implements ActionListener{
   
    
    private JLabel id;
	private JLabel nombre;
	private JLabel anio;
	private JLabel raza;
	private JLabel especie;
	private JLabel colorr;
	private JLabel genero;
	private JButton ok;
        private JButton ok1;
        private JButton b1;
        private JTextArea a1;
        private JTable tabla;
    public VDiagnostico(){
        initComponentes();
        ventanaDiagnostico();
           
    }
    private void initComponentes() {
        setSize(600, 500);
        setTitle("Diagnosticos");
        setClosable(true);
        setMaximizable(true);
    }

    private void ventanaDiagnostico() {
    Container cp = getContentPane();
    cp.setLayout(new java.awt.GridBagLayout());
	
		Font fuente = new Font("Times New Roman", 3, 10);
		//Panel Imagen
		
		JPanel panelImg = new JPanel();
		panelImg.setLayout(new FlowLayout());
		ImageIcon imagen = new ImageIcon("imagenes/fotoPerfil.jpg");
		
		JLabel img = new JLabel(imagen); 
		img.setSize(1,1); 
		panelImg.add(img); 
		
		GridBagConstraints gbcpanelImg = new GridBagConstraints();
		
		gbcpanelImg.gridx=0;
		gbcpanelImg.gridy=0;
		cp.add(panelImg, gbcpanelImg);

		
		//Panel 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new java.awt.GridBagLayout());
                
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		gbcPanel1.gridx=0;
		gbcPanel1.gridy=1;
        
		cp.add(panel1, gbcPanel1);
		
		GridBagConstraints gbPerfil = new GridBagConstraints();
		
		JLabel ID = new JLabel("ID: ");
		ID.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=0;
		panel1.add(ID, gbPerfil);
		
		id = new JLabel(" ");
		id.setFont(fuente);
		id.setForeground(Color.DARK_GRAY);
		gbPerfil.gridx=1;
		gbPerfil.gridy=0;
		panel1.add(id, gbPerfil);

		JLabel Nombre = new JLabel("Nombre: ");
		Nombre.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=1;
		panel1.add(Nombre, gbPerfil);
		
		nombre = new JLabel(" ");
		nombre.setFont(fuente);
		nombre.setForeground(Color.DARK_GRAY);
		gbPerfil.gridx=1;
		gbPerfil.gridy=1;
		panel1.add(nombre, gbPerfil);
		
		JLabel anioN = new JLabel("Año de Nacimiento: ");
		anioN.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=2;
		panel1.add(anioN, gbPerfil);
		
		anio= new JLabel(" ");
		anio.setFont(fuente);
		anio.setForeground(Color.DARK_GRAY);
		gbPerfil.gridx=1;
		gbPerfil.gridy=2;
		panel1.add(anio, gbPerfil);
		
		JLabel Raza = new JLabel("Raza: ");
		Raza.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=3;
		panel1.add(Raza, gbPerfil);
		
		raza= new JLabel(" ");
		raza.setFont(fuente);
		raza.setForeground(Color.DARK_GRAY);
		gbPerfil.gridx=1;
		gbPerfil.gridy=3;
		panel1.add(raza, gbPerfil);
		
		JLabel Especie = new JLabel("Especie: ");
		Especie.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=4;
		panel1.add(Especie, gbPerfil);
		
		
		
		especie= new JLabel(" ");
		especie.setFont(fuente);
		especie.setForeground(Color.DARK_GRAY);
		gbPerfil.gridx=1;
		gbPerfil.gridy=4;
		panel1.add(especie, gbPerfil);
		
		JLabel Color = new JLabel("Color: ");
		Color.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=5;
		panel1.add(Color, gbPerfil);
		
		colorr= new JLabel(" ");
		gbPerfil.gridx=1;
		colorr.setFont(fuente);
		gbPerfil.gridy=5;
		panel1.add(colorr, gbPerfil);
                
                JLabel Genero = new JLabel("Genero: ");
		Genero.setFont(fuente);
		gbPerfil.gridx=0;
		gbPerfil.gridy=6;
		panel1.add(Genero, gbPerfil);
		
		genero= new JLabel(" ");
		gbPerfil.gridx=1;
		genero.setFont(fuente);
		gbPerfil.gridy=6;
		panel1.add(genero, gbPerfil);

                // Panel 2
                JPanel panel2 = new JPanel();
		panel2.setLayout(new java.awt.GridBagLayout());
                javax.swing.border.Border loweredlevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder titulo2;
		titulo2 = BorderFactory.createTitledBorder("");
		titulo2.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel2.setBorder(titulo2);
                
		GridBagConstraints gbcPanel2 = new GridBagConstraints();
		gbcPanel2.gridx=1;
		gbcPanel2.gridy=0;
                gbcPanel2.gridwidth=1;
                gbcPanel2.gridheight=2;
		
		cp.add(panel2, gbcPanel2);
		
		GridBagConstraints gbDiagnostico = new GridBagConstraints();
		
		JLabel diagnostico = new JLabel("Diagnostico");
		diagnostico.setFont(fuente);
		gbDiagnostico.gridx=0;
		gbDiagnostico.gridy=0;
		panel2.add(diagnostico, gbDiagnostico);
		
		a1= new JTextArea(20,20);
                gbDiagnostico.gridx=0;
		gbDiagnostico.gridy=1;
		panel2.add(a1, gbDiagnostico);
                
                ok= new JButton("Aceptar");
                gbDiagnostico.gridx=0;
		gbDiagnostico.gridy=2;
                ok.addActionListener(this);
                ok.setActionCommand("aceptar");
                panel2.add(ok, gbDiagnostico);  
                
                // Panel 3
                JPanel panel3 = new JPanel();
		panel3.setLayout(new java.awt.GridBagLayout());
                TitledBorder titulo3;
		titulo3 = BorderFactory.createTitledBorder("");
		titulo3.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel3.setBorder(titulo3);
		GridBagConstraints gbcPanel3 = new GridBagConstraints();
		gbcPanel3.gridx=2;
		gbcPanel3.gridy=0;
                gbcPanel3.gridwidth=1;
                gbcPanel3.gridheight=3;
		
		cp.add(panel3, gbcPanel3);
		
		GridBagConstraints gbReceta = new GridBagConstraints();
		
		JLabel receta = new JLabel("Receta Detalle");
		receta.setFont(fuente);
		gbReceta.gridx=1;
		gbReceta.gridy=0;
		panel3.add(receta, gbReceta);
                
                tabla = new JTable(20,3);
		gbReceta.gridx=0;
		gbReceta.gridy=1;
                gbReceta.gridwidth=3;
                
		panel3.add(tabla,gbReceta);
                
                tabla.setValueAt("FECHA", 0, 0);
		tabla.setValueAt("MASCOTA", 0, 1);
		tabla.setValueAt("ID-DIAGNOSTICO", 0, 2);
	 
                ok1= new JButton("Aceptar");
                gbReceta.gridx=0;
		gbReceta.gridy=3;
                ok1.addActionListener(this);
                ok1.setActionCommand("aceptar");
                panel3.add(ok1, gbReceta);  
                	
		 // Panel 4
                JPanel panel4 = new JPanel();
		panel4.setLayout(new java.awt.GridBagLayout());
                TitledBorder titulo4;
		titulo4 = BorderFactory.createTitledBorder("");
		titulo4.setTitlePosition(TitledBorder.ABOVE_TOP);
		panel4.setBorder(titulo4);
                
		GridBagConstraints gbcPanel4 = new GridBagConstraints();
		gbcPanel4.gridx=1;
		gbcPanel4.gridy=4;
                gbcPanel4.gridwidth=3;
		
		cp.add(panel4, gbcPanel4);
		
		GridBagConstraints gbVolver = new GridBagConstraints();
		
		b1= new JButton("Volver");
		gbVolver.gridx=1;
		gbVolver.gridy=5;
                b1.addActionListener(this);
                b1.setActionCommand("volver");
		panel4.add(b1, gbVolver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
		switch (comando) {
			
		case "volver":
			this.setVisible(false);
			break;
			
		default:
			break;
		}
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import javax.swing.*;
import javax.swing.JInternalFrame;
import vista.VIniciarSesion;

/**
 *
 * @author Usuario
 */
public class VMedico extends JFrame implements ActionListener{
    private JDesktopPane escritorioM;
    
  
    public VMedico(){
        escritorioM = new JDesktopPane();
        ventanaMedico ();
        initComponentes();
             
    }
    private void initComponentes() {
        setSize(1100,800);
        setTitle("Ventana Medico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    private void ventanaMedico(){
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(escritorioM, BorderLayout.CENTER);
        
        //crear barra de menu
        JMenuBar barra = new JMenuBar();
                   
        //Agrega opciones a la barra de menu
        JMenu m1 = new JMenu("Paciente");
            //Ingresa items en la opcion
            JMenuItem i1 = new JMenuItem("Diagnostico");
            i1.addActionListener(this);
            i1.setActionCommand("DiagnosticoM");
            m1.add(i1);
            
            JMenuItem i2 = new JMenuItem("Historial");
            i2.addActionListener(this);
            i2.setActionCommand("HistorialM");
            m1.add(i2);
            
            
        barra.add(m1);
        
        JMenu m2 = new JMenu("Cerrar Sesion");
            //Ingresa items en la opcion
            JMenuItem i4 = new JMenuItem("Cerrar");
            i4.addActionListener(this);
            i4.setActionCommand("CerrarS");
            m2.add(i4);
        barra.add(m2);   
        setJMenuBar(barra);
       
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: "+ comando);
        
        switch(comando){
            case "DiagnosticoM":
                llamarVentanaDiagnosticoM();
                break;
            
            case "HistorialM":
                llamarVentanaHistorialM();
                break;
            
            case "CerrarS":
                llamarVentanaCerrarS();
                break;
      
        }
    }

    private void llamarVentanaDiagnosticoM() {
        VDiagnostico vD = new VDiagnostico();
        vD.setVisible(true);
        
        escritorioM.add(vD);
    }

    private void llamarVentanaHistorialM() {
        VHistorial vH = new VHistorial();
        vH.setVisible(true);
        escritorioM.add(vH);
        try {
			vH.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
    }

    private void llamarVentanaCerrarS() {
        VIniciarSesion vIS = new VIniciarSesion();
        vIS.setVisible(true);
        
        setVisible(false);
    }
                   
}
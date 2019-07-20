/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rakrad7101
 */
public class VRealizarFactura extends JInternalFrame implements ActionListener{
    
    private int dia;
    private int mes;
    private int annio;
    private int hora;
    private int minuto;
    Calendar fecha;
    
    private static int id = 1;
    private static int id1;
    private String nombre = "Roberto";
    private String direccion = "Del Obrero";
    private String ci; 
    
    public VRealizarFactura(){
        fecha = new GregorianCalendar();
        initComponentes();
        ventanaRealizarFac();
    } 
    
    
    public void initComponentes(){
        setSize(700,400);
        setTitle("Realizar Factura");
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JTextField t1;
    DefaultTableModel dt;
    private JTable tb1;
    private JScrollPane scr;
    private boolean[] editable = {false, true, false, false};
    
    public void ventanaRealizarFac(){
        
        annio = fecha.get(Calendar.YEAR);
        mes = fecha.get(Calendar.MONTH);
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        
        Container cp = getContentPane();       
        cp.setLayout(new BorderLayout()); 
        
        JPanel p1 = new JPanel();
        GridBagConstraints g1 = new GridBagConstraints(); 
        p1.setLayout(new GridBagLayout());
        
        JLabel l1 = new JLabel("Nº Factura: ");
        g1.gridx =0;
        g1.gridy =0;
        p1.add(l1, g1);
        
        JLabel l2 = new JLabel(generarNF());
        g1.gridx =1;
        g1.gridy =0;
        p1.add(l2, g1);
        
        JLabel l3 = new JLabel("Fecha: ");
        g1.gridx =2;
        g1.gridy =0;
        p1.add(l3, g1);
        
        JLabel l4 = new JLabel(dia + "/" + mes + "/" + annio);
        g1.gridx =3;
        g1.gridy =0;
        p1.add(l4, g1);
        
        JLabel l5 = new JLabel("Cédula: ");
        g1.gridx =0;
        g1.gridy =1;
        p1.add(l5, g1);
        
        t1 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =1;
        p1.add(t1, g1);
        
        b1 = new JButton("Buscar");
        g1.gridx = 2;
        g1.gridy = 1;
        b1.addActionListener(this);
        b1.setActionCommand("buscar");
        p1.add(b1, g1);
        
        obtenerDatos();
        JLabel l6 = new JLabel("Nombre: ");
        g1.gridx =0;
        g1.gridy =2;
        p1.add(l6, g1);
        
        JLabel l7 = new JLabel(nombre);
        g1.gridx =1;
        g1.gridy =2;
        p1.add(l7, g1);
        
        JLabel l8 = new JLabel("C.I.: ");
        g1.gridx =2;
        g1.gridy =2;
        p1.add(l8, g1);
        
        JLabel l9 = new JLabel(ci);
        g1.gridx =3;
        g1.gridy =2;
        p1.add(l9, g1);
        
        JLabel l10 = new JLabel("Dirección: ");
        g1.gridx =0;
        g1.gridy =3;
        p1.add(l10, g1);
        
        JLabel l11 = new JLabel(direccion);
        g1.gridx =1;
        g1.gridy =3;
        p1.add(l11, g1);
        
        JLabel l12 = new JLabel("Teléfono: ");
        g1.gridx =2;
        g1.gridy =3;
        p1.add(l12, g1);
        
        JLabel l13 = new JLabel(direccion);
        g1.gridx =3;
        g1.gridy =3;
        p1.add(l13, g1);
        
        JPanel p2 = new JPanel(); 
        p2.setLayout(new BorderLayout());
        Border loweredbevel = BorderFactory.createLoweredBevelBorder();
        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder("Detalle Factura");
        title1.setTitlePosition(TitledBorder.ABOVE_TOP);
        p2.setBorder(title1);
        
        JPanel p3 = new JPanel(); 
        GridBagConstraints g2 = new GridBagConstraints();
        p3.setLayout(new GridBagLayout());
        
        JLabel l14 = new JLabel("Nombre:");
        g2.gridx =0;
        g2.gridy =0;
        p3.add(l14, g2);
        
        JTextField t2= new JTextField(12);
        g2.gridx =1;
        g2.gridy =0;
        p3.add(t2, g2);
        
        b2 = new JButton("Agregar");
        g1.gridx =2;
        g1.gridy =0;
        b2.addActionListener(this);
        b2.setActionCommand("agregar");
        p3.add(b2, g1);
        
        JPanel p4 = new JPanel(); 
        p4.setLayout(new GridBagLayout());
        
        dt = new DefaultTableModel(new String[]{"Nombre", "Cantidad", "Precio U."
                                                , "Subtotal"}, 0) {
 
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.Integer.class, 
                java.lang.Double.class, java.lang.Double.class
            };
 
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        };
        
        tb1 = new JTable();
        
        //Método para listar los datos
        //mostrar();
        
        tb1.setModel(dt);
        scr = new JScrollPane(tb1);
        g1.ipadx = 600;
        g1.ipady = 100;
        p4.add(scr, g1);

        p2.add(p3, BorderLayout.NORTH);
        p2.add(p4, BorderLayout.CENTER);
        
        JPanel p5 = new JPanel(); 
        p5.setLayout(new FlowLayout());
        
        b3 = new JButton("Volver");
        b3.addActionListener(this);
        b3.setActionCommand("volver");
        p5.add(b3);
        
        b4 = new JButton("Terminar");
        b4.addActionListener(this);
        b4.setActionCommand("terminar");
        p5.add(b4);
        
        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p5, BorderLayout.SOUTH);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){
            case "buscar":
                break;
            
            case "agregar":
                break;    
                
            case "volver":
                setVisible(false);
                break;
                
            case "terminar":
                llamarVentanaElegirMP(getDesktopPane());
                break;
        }
    }
    
    public String generarNF(){
        String ids = Integer.toString(id);
        id++;
        return ids;
    }
    
    public void obtenerDatos(){
        ci = t1.getText();
    }
    
    public void llamarVentanaElegirMP(JDesktopPane escritorio){
        VMetodoPago vmp = new VMetodoPago();
        vmp.setVisible(true);
        setVisible(false);
        
        escritorio.add(vmp);
    }
}

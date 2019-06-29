/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Rakrad7101
 */
public class VAdministrador extends JFrame implements ActionListener {

    
    private JDesktopPane escritorioA;
    
    public VAdministrador(){
        escritorioA = new JDesktopPane();
        ventanaAdministrador();
        initComponentes();
    }
    
    public void initComponentes(){
        setSize(1100,800);
        setTitle("Ventana Administrador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void ventanaAdministrador(){
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(escritorioA, BorderLayout.CENTER);
        
        //crear barra de menu
        JMenuBar barra = new JMenuBar();
                   
        //Agrega opciones a la barra de menu
        JMenu m1 = new JMenu("Empleados");
            //Ingresa items en la opcion
            JMenuItem i1 = new JMenuItem("Agregar Empleados");
            i1.addActionListener(this);
            i1.setActionCommand("agregarE");
            m1.add(i1);
            
            JMenuItem i2 = new JMenuItem("Modificar Empleados");
            i2.addActionListener(this);
            i2.setActionCommand("modificarE");
            m1.add(i2);
            
        barra.add(m1);
        
        //Agrega opciones a la barra de menu
        JMenu m2 = new JMenu("Productos");
            //Ingresa items en la opcion
            JMenuItem i3 = new JMenuItem("Mostrar Productos");
            i3.addActionListener(this);
            i3.setActionCommand("mostrarPd");
            m2.add(i3);
            
            JMenuItem i4 = new JMenuItem("Agregar Proveedores");
            i4.addActionListener(this);
            i4.setActionCommand("agregarPv");
            m2.add(i4);
            
            JMenuItem i5 = new JMenuItem("Modificar Proveedores");
            i5.addActionListener(this);
            i5.setActionCommand("modificarPv");
            m2.add(i5);
            
            JMenuItem i6 = new JMenuItem("Agregar Productos");
            i6.addActionListener(this);
            i6.setActionCommand("agregarPd");
            m2.add(i6);
            
            JMenuItem i7 = new JMenuItem("Modificar Productos");
            i7.addActionListener(this);
            i7.setActionCommand("modificarPd");
            m2.add(i7);
            
        barra.add(m2);
        
        //Añade la opcion de prestamo a la barra de menu
        JMenu m3 = new JMenu("Ventas");
            //Ingresa items en la opcion
            JMenuItem i8 = new JMenuItem("Listar Ventas");
            i8.addActionListener(this);
            i8.setActionCommand("listarV");
            m3.add(i8);
            
            JMenuItem i9 = new JMenuItem("Listar Facturas");
            i9.addActionListener(this);
            i9.setActionCommand("listarF");
            m3.add(i9);
            
        barra.add(m3);
       
        JMenu m4 = new JMenu("Cerrar Sesión");
        //Ingresar items en la opción
            JMenuItem i10 = new JMenuItem("Cerrar");
            i10.addActionListener(this);
            i10.setActionCommand("cerrarS");
            m4.add(i10);
           
        barra.add(m4);
        
       setJMenuBar(barra);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando :" + comando);
        
        switch(comando){
            case "agregarE":
                llamarVentanaAgregarE();
                break;
            
            case "modificarE":
                llamarVentanaModificarE();
                break;
            
            case "mostrarPd":
                llamarVentanaMostrarPd();
                break;
                    
            case "agregarPv":
                llamarVentanaAgregarPv();
                break;
            
            case "modificarPv":
                llamarVentanaModificarPv();
                break;
                    
            case "agregarPd":
                llamarVentanaAgregarPd();
                break;
            
            case "modificarPd":
                llamarVentanaModificarPd();
                break;
                
            case "listarV":
                llamarVentanaListarV();
                break;
            
            case "listarF":
                llamarVentanaListarF();
                break;
                    
            case "cerrarS":
                llamarVentanaIniciarS();
                break;

        }
    }
    
    public void llamarVentanaAgregarE(){
        VAgregarEmpleado vae = new VAgregarEmpleado();
        vae.setVisible(true);
        
        escritorioA.add(vae);
    }

    public void llamarVentanaModificarE() {
        VModificarEmpleado vme = new VModificarEmpleado();
        vme.setVisible(true);
        
        escritorioA.add(vme);
    }

    public void llamarVentanaMostrarPd() {
        VMostrarProducto vmp = new VMostrarProducto();
        vmp.setVisible(true);
        
        escritorioA.add(vmp);
    }

    public void llamarVentanaAgregarPv() {
        VAgregarProveedor vapv = new VAgregarProveedor();
        vapv.setVisible(true);
        
        escritorioA.add(vapv);
    }

    public void llamarVentanaModificarPv() {
        VModificarProveedor vmpv = new VModificarProveedor();
        vmpv.setVisible(true);
        
        escritorioA.add(vmpv);
    }

    public void llamarVentanaAgregarPd() {
        VAgregarProducto vapd = new VAgregarProducto();
        vapd.setVisible(true);
        
        escritorioA.add(vapd);
    }

    public void llamarVentanaModificarPd() {
        VModificarProducto vmpd = new VModificarProducto();
        vmpd.setVisible(true);
        
        escritorioA.add(vmpd);
    }

    public void llamarVentanaListarV() {
        VListarVentas vlv = new VListarVentas();
        vlv.setVisible(true);
        
        escritorioA.add(vlv);
    }

    public void llamarVentanaListarF() {
        
        VListarFacturas vlf = new VListarFacturas();
        vlf.setVisible(true);
        
        escritorioA.add(vlf);
    }

    public void llamarVentanaIniciarS() {
        VIniciarSesion vI = new VIniciarSesion();
        vI.setVisible(true);
        
        setVisible(false);
    }
    
    
}   
    
  

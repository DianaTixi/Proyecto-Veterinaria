
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
public class VSecretaria extends JFrame implements ActionListener{
    
    private JDesktopPane escritorioS;
    
    public VSecretaria(){
        escritorioS = new JDesktopPane();
        initComponentes();
        ventanaSecretaria();
    }
    
    public void initComponentes(){
        setSize(1100,800);
        setTitle("Ventana Secretaría");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void ventanaSecretaria(){
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(escritorioS, BorderLayout.CENTER);
        
        //crear barra de menu
        JMenuBar barra = new JMenuBar();
                   
        //Agrega opciones a la barra de menu
        JMenu m1 = new JMenu("Clientes");
            //Ingresa items en la opcion
            JMenuItem i1 = new JMenuItem("Agregar Clientes");
            i1.addActionListener(this);
            i1.setActionCommand("agregarCl");
            m1.add(i1);
            
            JMenuItem i2 = new JMenuItem("Modificar Clientes");
            i2.addActionListener(this);
            i2.setActionCommand("modificarCl");
            m1.add(i2);
            
        barra.add(m1);
        
        //Agrega opciones a la barra de menu
        JMenu m2 = new JMenu("Citas");
            //Ingresa items en la opcion
            JMenuItem i3 = new JMenuItem("Mostrar Cronograma");
            i3.addActionListener(this);
            i3.setActionCommand("mostrarC");
            m2.add(i3);
            
            JMenuItem i4 = new JMenuItem("Realizar Cita");
            i4.addActionListener(this);
            i4.setActionCommand("agregarC");
            m2.add(i4);
            
            JMenuItem i5 = new JMenuItem("Modificar Citas");
            i5.addActionListener(this);
            i5.setActionCommand("modificarC");
            m2.add(i5);
            
        barra.add(m2);
        
        //Añade la opcion de prestamo a la barra de menu
        JMenu m3 = new JMenu("Facturas");
            //Ingresa items en la opcion
            JMenuItem i6 = new JMenuItem("Realizar Factura");
            i6.addActionListener(this);
            i6.setActionCommand("realizarF");
            m3.add(i6);
            
            JMenuItem i7 = new JMenuItem("Anular Facturas");
            i7.addActionListener(this);
            i7.setActionCommand("anularF");
            m3.add(i7);
   
        barra.add(m3);
       
        JMenu m4 = new JMenu("Cerrar Sesión");
        //Ingresar items en la opción
            JMenuItem i8 = new JMenuItem("Cerrar");
            i8.addActionListener(this);
            i8.setActionCommand("cerrarS");
            m4.add(i8);
           
        barra.add(m4);
        
       setJMenuBar(barra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando :" + comando);
        
        switch(comando){
            case "agregarCl":
                llamarVentanaAgregarCl();
                break;
            
            case "modificarCl":
                llamarVentanaModificarCl();
                break;
            
            case "mostrarC":
                llamarVentanaMostrarC();
                break;
                    
            case "agregarC":
                llamarVentanaRealizarC();
                break;
            
            case "modificarC":
                llamarVentanaModificarC();
                break;
                    
            case "realizarF":
                llamarVentanaRealizarF();
                break;
            
            case "anularF":
                llamarVentanaAnularF();
                break;
                    
            case "cerrarS":
                llamarVentanaIniciarS();
                break;

        }
    }
    
    public void llamarVentanaAgregarCl(){
        
    }
    
    public void llamarVentanaModificarCl(){
        
    }
    
    public void llamarVentanaMostrarC(){
        
    }
    
    public void llamarVentanaRealizarC(){
        
    }
    
    public void llamarVentanaModificarC(){
        
    }
    
    public void llamarVentanaRealizarF(){
        
    }
    
    public void llamarVentanaAnularF(){
        
    }
    
    public void llamarVentanaIniciarS() {
        VIniciarSesion vI = new VIniciarSesion();
        vI.setVisible(true);
        
        setVisible(false);
    }

}

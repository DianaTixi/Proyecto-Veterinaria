
package vista;

import conexionbd.Conexion;
import conexionbd.ControladorCita;
import conexionbd.ControladorCliente;
import conexionbd.ControladorDiagnostico;
import conexionbd.ControladorEspecie;
import conexionbd.ControladorFacturaCabecera;
import conexionbd.ControladorFacturaDetalle;
import conexionbd.ControladorMascota;
import conexionbd.ControladorProducto;
import conexionbd.ControladorRaza;
import conexionbd.ControladorRecetaCabecera;
import conexionbd.ControladorRecetaDetalle;
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
    Conexion con;
    ControladorProducto cpd;
    ControladorCliente cc;
    ControladorMascota cm;
    ControladorEspecie ces;
    ControladorRaza cr;
    ControladorCita cct;
    ControladorFacturaCabecera cfc;
    ControladorFacturaDetalle cfd;
    ControladorDiagnostico cd;
    ControladorRecetaCabecera crc;
    ControladorRecetaDetalle crd;
    
    public VSecretaria(Conexion con,ControladorProducto cpd,ControladorCliente cc,
            ControladorMascota cm,ControladorEspecie ces,ControladorRaza cr,
            ControladorCita cct,ControladorFacturaCabecera cfc,ControladorFacturaDetalle cfd,
            ControladorDiagnostico cd,ControladorRecetaCabecera crc,
            ControladorRecetaDetalle crd){
        this.con = con;
        this.cpd = cpd;
        this.cc = cc;
        this.cm = cm;
        this.ces = ces;
        this.cr = cr;
        this.cct = cct;
        this.cfc = cfc;
        this.cfd = cfd;
        this.cd = cd;
        this.crc = crc;
        this.crd = crd;
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
            
            JMenuItem i9 = new JMenuItem("Agregar Mascota");
            i9.addActionListener(this);
            i9.setActionCommand("agregarM");
            m1.add(i9);
            
            JMenuItem i10 = new JMenuItem("Modificar Mascota");
            i10.addActionListener(this);
            i10.setActionCommand("modificarM");
            m1.add(i10);
            
        barra.add(m1);
        
        //Agrega opciones a la barra de menu
        JMenu m2 = new JMenu("Citas");
            //Ingresa items en la opcion
            
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
            
            case "agregarM":
                llamarVentanaAgregarM();
                break;
            
            case "modificarM":
                llamarVentanaModificarM();
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
        VAgregarCliente vacl = new VAgregarCliente();
        vacl.setVisible(true);
        
        escritorioS.add(vacl);
    }
    
    public void llamarVentanaModificarCl(){
        VModificarCliente vmcl = new VModificarCliente();
        vmcl.setVisible(true);
        
        escritorioS.add(vmcl);
    }
    
    public void llamarVentanaAgregarM(){
        VAgregarMascota vam = new VAgregarMascota();
        vam.setVisible(true);
        
        escritorioS.add(vam);
    }
    
    public void llamarVentanaModificarM(){
        VModificarMascota vmm = new VModificarMascota();
        vmm.setVisible(true);
    
        escritorioS.add(vmm);
    }
    
    public void llamarVentanaRealizarC(){
        VRealizarCita vrc = new VRealizarCita();
        vrc.setVisible(true);
        
        escritorioS.add(vrc);
    }
    
    public void llamarVentanaModificarC(){
        VModificarCita vmdc = new VModificarCita();
        vmdc.setVisible(true);
        
        escritorioS.add(vmdc);
    }
    
    public void llamarVentanaRealizarF(){
        VRealizarFactura vrf = new VRealizarFactura();
        vrf.setVisible(true);
        
        escritorioS.add(vrf);
    }
    
    public void llamarVentanaAnularF(){
        VAnularFactura vaf = new VAnularFactura();
        vaf.setVisible(true);
    
        escritorioS.add(vaf);
    }
    
    public void llamarVentanaIniciarS() {
        VIniciarSesion vI = new VIniciarSesion(con,null,null,cpd,cc,cm,ces,cr,cct,
                cfc,cfd,cd,crc,crd);
        vI.setVisible(true);
        
        setVisible(false);
    }

}

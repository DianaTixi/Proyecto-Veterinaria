
package vista;

import conexionbd.Conexion;
import conexionbd.ControladorCaracter;
import conexionbd.ControladorProducto;
import conexionbd.ControladorProveedor;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class VModificarProducto extends JInternalFrame implements ActionListener{
    
    Conexion con;
    ControladorProducto cpd;
    
    public VModificarProducto(Conexion con,ControladorProducto cpd){
        this.con = con;
        this.cpd = cpd;
        initComponentes();
        ventanaModificarProd();
    }
    
    public void initComponentes(){
        setSize(400, 400);
        setTitle("Modificar Productos");
        setClosable(true);
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JTextField t1;
    private JTextField t2;
    private JComboBox<String> cb1;
    private JComboBox<String> cb2;
    private JComboBox<String> cb3;
    
    public void ventanaModificarProd(){
        
        Container cp = getContentPane();
        GridBagConstraints g1 = new GridBagConstraints();       
        cp.setLayout(new GridBagLayout()); 
        
        JLabel l1 = new JLabel("Nombre:");
        g1.gridx =0;
        g1.gridy =0;
        cp.add(l1, g1);
        
        t1 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =0;
        cp.add(t1, g1);
        
        b1 = new JButton("Buscar");
        b1.addActionListener(this);
        b1.setActionCommand("buscar");
        g1.gridx =2;
        g1.gridy =0;
        cp.add(b1, g1);
        
        JLabel l2 = new JLabel("Categoría:");
        g1.gridx =0;
        g1.gridy =1;
        cp.add(l2, g1);
        
        cb1 = new JComboBox<>();
            cb1.addItem("Servicio");
            cb1.addItem("Accesorios");
            cb1.addItem("Comida");
            cb1.addItem("Medicina");
        g1.gridx =1;
        g1.gridy =1;
        cp.add(cb1, g1);
        
        JLabel l3 = new JLabel("Precio Venta:");
        g1.gridx =0;
        g1.gridy =2;
        cp.add(l3, g1);
        
        t2 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =2;
        cp.add(t2, g1);
        
        JLabel l4 = new JLabel("Origen:");
        g1.gridx =0;
        g1.gridy =3;
        cp.add(l4, g1);
        
        cb2 = new JComboBox<>();
            cb2.addItem("Nacional");
            cb2.addItem("Extrangero");
        g1.gridx =1;
        g1.gridy =3;
        cp.add(cb1, g1);
        
        JLabel l5 = new JLabel("Alianza:");
        g1.gridx =0;
        g1.gridy =4;
        cp.add(l5, g1);
        
        cb3 = new JComboBox<>();
            cb3.addItem("Propio");
            cb3.addItem("Asociado");
        g1.gridx =1;
        g1.gridy =4;
        cp.add(cb1, g1);
        
        b2 = new JButton("Volver");
        g1.gridx = 0;
        g1.gridy = 5;
        b2.addActionListener(this);
        b2.setActionCommand("volver");
        cp.add(b2, g1); 
        
        b3 = new JButton("Editar");
        g1.gridx = 1;
        g1.gridy = 5;
        b3.addActionListener(this);
        b3.setActionCommand("editar");
        cp.add(b3, g1);
        
        b4 = new JButton("Eliminar");
        g1.gridx = 2;
        g1.gridy = 5;
        b4.addActionListener(this);
        b4.setActionCommand("eliminar");
        cp.add(b4, g1);
        
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){
            case "buscar":
                buscarProducto();
                break;
            
            case "volver":
                setVisible(false);
                break;
                
            case "editar":
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
                break;
                
            case "eliminar":
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
                break;
        }
    }
    
    String categoria;
    String nombre;
    double precioV;
    String origen;
    String alianza;
    Boolean v;
    
    public void buscarProducto(){
        nombre = t1.getText();
        
        if(cpd.proBuscar(con, nombre).getProductoNombre().equals(nombre)){
            
            categoria = cpd.proBuscar(con, nombre).getProductoCategoria();
            cb1.setSelectedItem(categoria);
            
            origen = cpd.proBuscar(con, nombre).getProductoOrigen();
            cb2.setSelectedItem(origen);
            
            alianza = cpd.proBuscar(con, nombre).getProductoAlianza();
            cb3.setSelectedItem(alianza);
            
        }else{
            JOptionPane.showMessageDialog(null,"Error","No existe el producto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    public void editarProducto(){
        nombre = t1.getText();
        categoria = cb1.getSelectedItem().toString();
        precioV = Double.parseDouble(t2.getText());
        origen = cb2.getSelectedItem().toString();
        alianza = cb3.getSelectedItem().toString();
        
        int res = JOptionPane.showConfirmDialog(null,"Desea Confirmar la acción?",
                "Alerta!",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
        
        if(res == 0){
            if(cem.empEditar(con, emp) == true){
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
            }else{
                JOptionPane.showMessageDialog(null,"Error","No se pudo completar "
                        + "la operación",JOptionPane.ERROR_MESSAGE); 
            }
        }else{
            
        }
    }
    
    public void eliminarProducto(){
        
    }
    
}

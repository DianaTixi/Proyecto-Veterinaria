
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rakrad7101
 */
public class VListarFacturas extends JInternalFrame implements ActionListener{
    
    public VListarFacturas(){
        initComponentes();
        ventanaListarFac();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Listar Facturas");
    }
    
    JButton b1;
    JButton b2;
    DefaultTableModel dt;
    private JTable tb1;
    private JScrollPane scr;
    private boolean[] editable = {false,false,false};
    
    public void ventanaListarFac(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        JPanel pa = new JPanel();
        pa.setLayout(new BorderLayout()); 
        
        dt = new DefaultTableModel(new String[]{"Nº Factura", "Cliente", 
            "Total"}, 0) {
 
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        pa.add(scr, BorderLayout.NORTH);
        
        JPanel pa2 = new JPanel();
        pa2.setLayout(new FlowLayout()); 
        b1 = new JButton("Volver");
        b1.addActionListener(this);
        b1.setActionCommand("volver");
        pa2.add(b1);
        
        b2 = new JButton("Listar");
        b2.addActionListener(this);
        b2.setActionCommand("listar");
        pa2.add(b2);
        
        cp.add(pa, BorderLayout.CENTER);
        cp.add(pa2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){
            case "volver":
                setVisible(false);
                break;
                
            case "listar":
                break;
        }
    }
    
    
    
}

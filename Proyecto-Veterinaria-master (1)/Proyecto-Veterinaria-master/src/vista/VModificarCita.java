
package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rakrad7101
 */
public class VModificarCita extends JInternalFrame implements ActionListener{
    
    public VModificarCita(){
        initComponentes();
        ventanaModificarC();
    }
    
    public void initComponentes(){
        setSize(500,400);
        setTitle("Modificar Cita");
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    DefaultTableModel dt;
    private JTable tb1;
    private JScrollPane scr;
    private boolean[] editable = {true,true,true,true};
    
    public void ventanaModificarC(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
 
        JPanel p1 = new JPanel();
        GridBagConstraints g1 = new GridBagConstraints(); 
        p1.setLayout(new GridBagLayout());
        
        JLabel l1 = new JLabel("Citas");
        g1.gridx =0;
        g1.gridy =0;
        p1.add(l1, g1);
        
        dt = new DefaultTableModel(new String[]{"Fecha","Hora","Mascota","Check"}, 0) {
 
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
                java.lang.Boolean.class    
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
        g1.gridx = 0;
        g1.gridy = 1;
        g1.ipadx = 300;
        g1.ipady = 400;
        g1.gridwidth =3;
        p1.add(scr, g1);
        
        JPanel p2 = new JPanel(); 
        p2.setLayout(new FlowLayout());
        
        b1 = new JButton("Volver");
        b1.addActionListener(this);
        b1.setActionCommand("volver");
        p2.add(b1, g1);
        
        b2 = new JButton("Editar");
        b2.addActionListener(this);
        b2.setActionCommand("editar");
        p2.add(b2, g1); 
        
        b3 = new JButton("Eiminar");
        b3.addActionListener(this);
        b3.setActionCommand("eliminar");
        p2.add(b3, g1);
        
        cp.add(p1, BorderLayout.CENTER);
        cp.add(p2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){ 
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
    
}

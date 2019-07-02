
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
public class VRealizarCita extends JInternalFrame implements ActionListener{
    
    private String nombre = "Roberto";
    
    public VRealizarCita(){
        initComponentes();
        ventanaRealizarC();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Realizar Cita");
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    DefaultTableModel dt;
    private JTable tb1;
    private JScrollPane scr;
    private boolean[] editable = {false, true};
    
    public void ventanaRealizarC(){
        
        Container cp = getContentPane();      
        cp.setLayout(new BorderLayout());
 
        JPanel p1 = new JPanel();
        GridBagConstraints g1 = new GridBagConstraints(); 
        p1.setLayout(new GridBagLayout());
        
        JLabel l1 = new JLabel("Fecha: ");
        g1.gridx =0;
        g1.gridy =0;
        p1.add(l1, g1);
        
        JTextField t1 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =0;
        p1.add(t1, g1);
        
        JLabel l3 = new JLabel("Hora: ");
        g1.gridx =0;
        g1.gridy =1;
        p1.add(l3, g1);
        
        JTextField t2 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =1;
        p1.add(t2, g1);
        
        JLabel l5 = new JLabel("Cédula:");
        g1.gridx =0;
        g1.gridy =2;
        p1.add(l5, g1);
        
        JTextField t3 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =2;
        p1.add(t3, g1);
        
        b1 = new JButton("Buscar");
        b1.addActionListener(this);
        b1.setActionCommand("buscar");
        g1.gridx =2;
        g1.gridy =2;
        p1.add(b1, g1);
        
        JLabel l6 = new JLabel("Nombre: ");
        g1.gridx =0;
        g1.gridy =3;
        p1.add(l6, g1);
        
        JLabel l7 = new JLabel(nombre);
        g1.gridx =1;
        g1.gridy =3;
        p1.add(l7, g1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        
        JLabel l8 = new JLabel("Mascotas");
        g1.gridx =0;
        g1.gridy =0;
        p2.add(l8, g1);
        
        dt = new DefaultTableModel(new String[]{"Nombre", "Check"}, 0) {
 
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Boolean.class
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
        g1.ipadx = 200;
        g1.ipady = 100;
        g1.gridwidth =3;
        p2.add(scr, g1);
        
        JPanel p3 = new JPanel(); 
        p3.setLayout(new FlowLayout());
        
        b2 = new JButton("Volver");
        b2.addActionListener(this);
        b2.setActionCommand("volver");
        p3.add(b2);
        
        b3 = new JButton("Terminar");
        b3.addActionListener(this);
        b3.setActionCommand("terminar");
        p3.add(b3);
        
        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.SOUTH);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){
            case "buscar":
                break;
            
            case "volver":
                setVisible(false);
                break;
                
            case "terminar":
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
                break;
        }
    }
    
    /*
    Método para mostrar la información
    */
    /*
    public void mostrar(){
        int n = g.listarProductosExistentes().size();
        for(int i = 0; i < n; i++){
            Object fila[] = new Object[2];
            fila[0] = g.listarProductosExistentes().get(i).getCodigo();
            fila[1] = false;

            dt.addRow(fila);
        }
    }
    */
    
    /*
    Método para obtener el dato de una fila
    */
    /*
    public void setPreferencias(){
        pref = new ArrayList<>();
        for(int i = 0; i < tb1.getRowCount(); i++){
            System.out.println("Check: " + tb1.getValueAt(i, 3));
            if((boolean)tb1.getValueAt(i, 3)==true){
                pref.add(g.listarProductosExistentes().get(i));
            }
        }  
        
        g.setPreferencias((ArrayList<Producto>) pref, persona);
        JOptionPane.showMessageDialog(null, mensajes.getString("jPreferencias"));
    }
    */
}

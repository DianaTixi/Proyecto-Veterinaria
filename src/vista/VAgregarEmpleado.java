
package vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad7101
 */

public class VAgregarEmpleado extends JInternalFrame implements ActionListener{
    
    public VAgregarEmpleado(){
        initComponentes();
        ventanaAgregarEmp();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Agregar Empleados");
    }
    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JComboBox<String> cb1;
    
    public void ventanaAgregarEmp(){
        Container cp = getContentPane();
        GridBagConstraints g1 = new GridBagConstraints();       
        cp.setLayout(new GridBagLayout()); 
        
        JLabel l1 = new JLabel("Cédula:");
        g1.gridx =0;
        g1.gridy =0;
        cp.add(l1, g1);
        
        JTextField t1 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =0;
        cp.add(t1, g1);
        
        JLabel l2 = new JLabel("Nombres:");
        g1.gridx =0;
        g1.gridy =1;
        cp.add(l2, g1);
        
        JTextField t2 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =1;
        cp.add(t2, g1);
        
        JLabel l3 = new JLabel("Apellidos:");
        g1.gridx =0;
        g1.gridy =2;
        cp.add(l3, g1);
        
        JTextField t3 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =2;
        cp.add(t3, g1);
        
        JLabel l4 = new JLabel("Teléfono:");
        g1.gridx =0;
        g1.gridy =3;
        cp.add(l4, g1);
        
        JTextField t4 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =3;
        cp.add(t4, g1);
        
        JLabel l5 = new JLabel("Cargo:");
        g1.gridx =0;
        g1.gridy =4;
        cp.add(l5, g1);
        
        cb1 = new JComboBox<>();
            cb1.addItem("Administrador");
            cb1.addItem("Secretaria/o");
            cb1.addItem("Médico");
        g1.gridx =1;
        g1.gridy =4;
        cp.add(cb1, g1);
        
        JLabel l6 = new JLabel("Correo:");
        g1.gridx =0;
        g1.gridy =5;
        cp.add(l6, g1);
        
        JTextField t5 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =5;
        cp.add(t5, g1);
        
        JLabel l7 = new JLabel("Dirección:");
        g1.gridx =0;
        g1.gridy =6;
        cp.add(l7, g1);
        
        JTextField t6 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =6;
        cp.add(t6, g1);
    
        JLabel l8 = new JLabel("Usuario:");
        g1.gridx =0;
        g1.gridy =7;
        cp.add(l8, g1);
        
        JTextField t7 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =7;
        cp.add(t7, g1);
        
        JLabel l9 = new JLabel("Contraseña:");
        g1.gridx =0;
        g1.gridy =8;
        cp.add(l9, g1);
        
        JTextField t8 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =8;
        cp.add(t8, g1);

        b1 = new JButton("Generar");
        g1.gridx = 2;
        g1.gridy = 7;
        b1.addActionListener(this);
        b1.setActionCommand("generar");
        cp.add(b1, g1); 
        
        b2 = new JButton("Volver");
        g1.gridx = 0;
        g1.gridy = 9;
        g1.gridwidth = 2;
        b2.addActionListener(this);
        b2.setActionCommand("volver");
        cp.add(b2, g1);
        
        b3 = new JButton("Agregar");
        g1.gridx = 1;
        g1.gridy = 9;
        g1.gridwidth = 2;
        b3.addActionListener(this);
        b3.setActionCommand("agregar");
        cp.add(b3, g1);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){
            case "generar":
                break;
                
            case "volver":
                setVisible(false);
                break;
                
            case "agregar":
                break;
 
        }
    }
}


package vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad7101
 */
public class VAgregarCliente extends JInternalFrame implements ActionListener{
    
    public VAgregarCliente(){
        initComponentes();
        ventanaAgregarCli();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Agregar Clientes");
    }
    
    private JButton b1;
    private JButton b2;
    
    public void ventanaAgregarCli(){
        
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
        
        JLabel l5 = new JLabel("Correo:");
        g1.gridx =0;
        g1.gridy =4;
        cp.add(l5, g1);
        
        JTextField t5 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =4;
        cp.add(t5, g1);
        
        JLabel l7 = new JLabel("Dirección:");
        g1.gridx =0;
        g1.gridy =5;
        cp.add(l7, g1);
        
        JTextField t6 = new JTextField(12);
        g1.gridx =1;
        g1.gridy =5;
        cp.add(t6, g1);
        
        b1 = new JButton("Volver");
        g1.gridx = 0;
        g1.gridy = 6;
        b1.addActionListener(this);
        b1.setActionCommand("volver");
        cp.add(b1, g1);
        
        b2 = new JButton("Agregar");
        g1.gridx = 1;
        g1.gridy = 6;
        b2.addActionListener(this);
        b2.setActionCommand("agregar");
        cp.add(b2, g1); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando: " + comando);
        
        switch(comando){ 
            case "volver":
                setVisible(false);
                break;
                
            case "agregar":
                JOptionPane.showMessageDialog(null, "Operación Exitosa");
                break;
 
        }
    }

}

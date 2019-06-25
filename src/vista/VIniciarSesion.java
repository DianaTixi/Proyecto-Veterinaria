
package vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad7101
 */
public class VIniciarSesion extends JFrame implements ActionListener{

    
    private JButton b1;
    String user;
    String contra;
    
    public VIniciarSesion(){
        ventanaIniciar();
        initComponentes();
    }
    
    public void initComponentes(){
        setSize(300,300);
        setTitle("Inicar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void ventanaIniciar(){
        
        Container cp = getContentPane();
        
        GridBagConstraints g1 = new GridBagConstraints();
                
        cp.setLayout(new GridBagLayout());
        
        JLabel l1 = new JLabel("Username");
        g1.gridx =0;
        g1.gridy =0;
        cp.add(l1, g1);
        
        JTextField t1 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =0;
        cp.add(t1, g1);
        
        JLabel l2 = new JLabel("Contraseña");
        g1.gridx =0;
        g1.gridy =1;
        cp.add(l2, g1);
        
        JTextField t2 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =1;
        cp.add(t2, g1);
        
        b1 = new JButton("Log In");
        g1.gridx =0;
        g1.gridy =2;
        g1.gridwidth = 2;
        b1.addActionListener(this);
        b1.setActionCommand("iniciar");
        cp.add(b1, g1);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println("Comando :" + comando);
        
        switch(comando){
            case "iniciar":
                llamarVentanaAdministrador();
                setVisible(false);
                break;
        }
     
    }
    
    public void llamarVentanaAdministrador(){
        VAdministrador vA = new VAdministrador();
        vA.setVisible(true);
        
    }
    
}

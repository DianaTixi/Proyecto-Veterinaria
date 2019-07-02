
package vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad7101
 */
public class VIniciarSesion extends JFrame implements ActionListener{

    
    private JButton b1;
    String user;
    String contra;
    
    int v;
    
    public VIniciarSesion(){
        ventanaIniciar();
        initComponentes();
    }
    
    public void initComponentes(){
        setSize(300,300);
        setTitle("Inicar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    JTextField t1;
    
    public void ventanaIniciar(){
        
        Container cp = getContentPane();
        
        GridBagConstraints g1 = new GridBagConstraints();
                
        cp.setLayout(new GridBagLayout());
        
        JLabel l1 = new JLabel("Username:");
        g1.gridx =0;
        g1.gridy =0;
        cp.add(l1, g1);
        
        t1 = new JTextField(10);
        g1.gridx =1;
        g1.gridy =0;
        cp.add(t1, g1);
        
        JLabel l2 = new JLabel("Contraseña:");
        g1.gridx =0;
        g1.gridy =1;
        cp.add(l2, g1);
        
        JPasswordField t2 = new JPasswordField(10);
        g1.gridx =1;
        g1.gridy =1;
        cp.add(t2, g1);
        
        b1 = new JButton("Iniciar Sesión");
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
                try {
                    user = t1.getText();
                    v = Integer.parseInt(user);
                    
                    if(v == 1){
                        llamarVentanaAdministrador();
                        setVisible(false);
                    }else if(v == 2){
                        llamarVentanaSecretaria();
                        setVisible(false);
                    }else if(v ==3){
                        llamarVentanaMedico();
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Vuelva a ingresar los datos");
                    }
                    
                } catch (NumberFormatException r) {
                    r.printStackTrace();
                }
                break;
        }
     
    }
    
    public void llamarVentanaAdministrador(){
        VAdministrador vA = new VAdministrador();
        vA.setVisible(true); 
    }
    
    public void llamarVentanaSecretaria(){
        VSecretaria vS = new VSecretaria();
        vS.setVisible(true); 
    }
    
    public void llamarVentanaMedico(){
        VMedico vM = new VMedico();
        vM.setVisible(true); 
    }
}

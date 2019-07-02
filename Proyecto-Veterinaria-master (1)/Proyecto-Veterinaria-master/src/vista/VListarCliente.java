
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 *
 * @author Rakrad7101
 */
public class VListarCliente extends JInternalFrame implements ActionListener{
    
    public VListarCliente(){
        initComponentes();
        ventanaListarCl();
    }
    
    public void initComponentes(){
        setSize(400,400);
        setTitle("Listar Clientes");
        setClosable(true);
        setMaximizable(true);
    }
    
    public void ventanaListarCl(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}

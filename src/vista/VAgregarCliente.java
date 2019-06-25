
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

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
    
    public void ventanaAgregarCli(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }

}

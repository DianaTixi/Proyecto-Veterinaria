package ejecucion;

import conexionbd.Conexion;
import conexionbd.SentenciasCRUD;

/**
 *
 * @author Usuario
 */
public class BaseDatos {
    
    public static void main(String [] args){
        
        Conexion con = new Conexion();
        SentenciasCRUD s = new SentenciasCRUD();
        
        con.setUrl("jdbc:oracle:thin:@localhost:1521:robbynbd");
        con.setUserNmae("hr");
        con.setPassword("hr_123");
        
        con.conectar();
        
        if(con.getConexion()!= null){
            System.out.println("Base de datos conectada");
            
            //s.consultarEmployees(con, 100);
            s.eliminarPais(con, "EC");
            //s.insertarPais(con, "EC", "Ecuador", 2);
            
            con.cerrarConexion();
        }
        
    }
    
    
}

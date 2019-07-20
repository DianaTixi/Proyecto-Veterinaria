package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private String userNmae;
    private String password;
    private String url;
    private Connection conexion=null;

    
    /**
     * Este metodo permite conectarse a la base de datos
     */
    public void conectar(){
        
        try{
            this.setConexion(DriverManager.getConnection(this.getUrl(), this.getUserNmae(), this.getPassword()));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Metodo para cerrar una conexion a la base de datos
     */
    public void cerrarConexion(){
        
        try {
            if(this.getConexion() != null && !this.getConexion().isClosed()){
                this.getConexion().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
    
    
    
}

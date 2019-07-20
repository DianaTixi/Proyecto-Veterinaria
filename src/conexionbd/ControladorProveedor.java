/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Proveedor;

/**
 *
 * @author plojam
 */
public class ControladorProveedor {
    
    private ResultSet resultado = null;
    private PreparedStatement sentencia = null;
    
    
    public Proveedor pvdBuscar(Conexion con, String ruc){
        Proveedor proveedor = new Proveedor();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT prv_id, prv_razons, prv_ruc, prv_correo, prv_direccion "
            + "FROM vet_proveedores "
            + "WHERE prv_ruc = ?");
            sentencia.setString(1, ruc);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                
                proveedor.setProveedorId(resultado.getInt("prv_id"));
                proveedor.setProveedorRazonSocial(resultado.getString("prv_razons"));
                proveedor.setProveedorRuc(resultado.getString("prv_ruc"));
                proveedor.setProveedorEmail(resultado.getString("prv_correo"));
                proveedor.setProveedorDireccion(resultado.getString("prv_direccion"));
            }
            
            return proveedor;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    public Proveedor pvdBuscarId(Conexion con, int proveedorId){
        Proveedor proveedor = new Proveedor();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT prv_id, prv_razons, prv_ruc, prv_correo, prv_direccion "
            + "FROM vet_proveedores "
            + "WHERE prv_id = ?");
            sentencia.setInt(1, proveedorId);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                
                proveedor.setProveedorId(resultado.getInt("prv_id"));
                proveedor.setProveedorRazonSocial(resultado.getString("prv_razons"));
                proveedor.setProveedorRuc(resultado.getString("prv_ruc"));
                proveedor.setProveedorEmail(resultado.getString("prv_correo"));
                proveedor.setProveedorDireccion(resultado.getString("prv_direccion"));
            }
            
            return proveedor;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    
    /**
     * Metodo para insetar paises
     */
    public boolean pvdAgregar(Conexion con, Proveedor proveedor){
        
        if(pvdBuscar(con, proveedor.getProveedorRuc())==null){
            try {

                sentencia = con.getConexion().prepareStatement("INSERT INTO vet_proveedores VALUES (prv_id_seq.nextval,?,?,?,?)");

                //sentencia.setInt(1, proveedor.getProveedorId());
                sentencia.setString(1, proveedor.getProveedorRuc());
                sentencia.setString(2, proveedor.getProveedorRazonSocial());
                sentencia.setString(3, proveedor.getProveedorEmail());
                sentencia.setString(4, proveedor.getProveedorDireccion());

                sentencia.executeUpdate();

                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
    }
    
    public boolean pvdEditar(Conexion con, Proveedor proveedor){
        
        if(pvdBuscar(con, proveedor.getProveedorRuc())!=null){
            try {

                sentencia = con.getConexion().prepareStatement("UPDATE vet_proveedores SET "
                + "prv_razons=?, prv_correo=?, prv_direccion=? "
                + "WHERE prv_ruc=?");
                
                sentencia.setString(1, proveedor.getProveedorRazonSocial());
                sentencia.setString(2, proveedor.getProveedorEmail());
                sentencia.setString(3, proveedor.getProveedorDireccion());
                sentencia.setString(4, proveedor.getProveedorRuc());

                sentencia.executeUpdate();

                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
            
        
    }
    
}



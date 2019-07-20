/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author plojam
 */
public class ControladorProducto {
    
    private ResultSet resultado = null;
    private PreparedStatement sentencia = null;
    
    
    public Producto proBuscar(Conexion con, String nombre){
        ControladorProveedor proveedor= new ControladorProveedor();
        Producto producto = new Producto();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT pro_id, pro_nombre,pro_precioc,pro_preciov, " 
                    +"pro_stock, pro_categoria, pro_origen, pro_alianza, pvd_id "
            + "FROM vet_productos "
            + "WHERE UPPER(pro_nombre) = UPPER(?)");
            sentencia.setString(1, nombre);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                producto.setProductoId(resultado.getInt("pro_id"));
                producto.setProductoNombre(resultado.getString("pro_nombre"));
                producto.setProductoPrecioCompra(resultado.getDouble("pro_precioc"));
                producto.setProductoPrecioVenta(resultado.getDouble("pro_preciov"));
                producto.setProductoStock(resultado.getInt("pro_stock"));
                producto.setProductoCategoria(resultado.getString("pro_categoria"));
                producto.setProductoOrigen(resultado.getString("pro_origen"));
                producto.setProductoAlianza(resultado.getString("pro_alianza"));
                int proveedorId = resultado.getInt("pvd_id");
                producto.setProveedor(proveedor.pvdBuscarId(con, proveedorId));
            }
            
            return producto;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    
    public Producto proBuscarId(Conexion con, int id){
        ControladorProveedor proveedor= new ControladorProveedor();
        Producto producto = new Producto();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT pro_id, pro_nombre, pro_precioc, pro_preciov, "
                    + "pro_stock, pro_categoria, pro_origen, pro_alianza pvd_id "
            + "FROM vet_productos "
            + "WHERE pro_id = ?");
            sentencia.setInt(1, id);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                producto.setProductoId(resultado.getInt("pro_id"));
                producto.setProductoNombre(resultado.getString("pro_nombre"));
                producto.setProductoPrecioCompra(resultado.getDouble("pro_precioc"));
                producto.setProductoPrecioVenta(resultado.getDouble("pro_preciov"));
                producto.setProductoStock(resultado.getInt("pro_stock"));
                producto.setProductoCategoria(resultado.getString("pro_categoria"));
                producto.setProductoOrigen(resultado.getString("pro_origen"));
                producto.setProductoAlianza(resultado.getString("pro_alianza"));
                int proveedorId = resultado.getInt("pvd_id");
                producto.setProveedor(proveedor.pvdBuscarId(con, proveedorId));
            }
            
            return producto;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    
    
    /**
     * Metodo para insetar paises
     */
    public boolean proAgregar(Conexion con, Producto producto){
        
        if(proBuscar(con, producto.getProductoNombre())==null){
            try {

                sentencia = con.getConexion().prepareStatement("INSERT INTO vet_productos VALUES (pro_id_seq.nextval,?,?,?,?,?,?,?,?)");

                //sentencia.setInt(1, producto.getProductoId());
                sentencia.setString(1, producto.getProductoNombre());
                sentencia.setInt(2, producto.getProductoStock());
                sentencia.setString(3, producto.getProductoCategoria());
                sentencia.setDouble(4, producto.getProductoPrecioCompra());
                sentencia.setDouble(5, producto.getProductoPrecioVenta());
                sentencia.setString(6, producto.getProductoOrigen());
                sentencia.setString(7, producto.getProductoAlianza());
                sentencia.setInt(8, producto.getProveedor().getProveedorId());

                sentencia.executeUpdate();

                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
    }
    
    public boolean proEditar(Conexion con, Producto producto){
        
        if(proBuscar(con, producto.getProductoNombre())!=null){
            try {
                
                sentencia = con.getConexion().prepareStatement("UPDATE vet_productos SET "
                + "pro_precioc=?, pro_preciov=?, pro_stock=? "
                + "WHERE pro_nombre=?");

                sentencia.setDouble(1, producto.getProductoPrecioCompra());
                sentencia.setDouble(2, producto.getProductoPrecioVenta());
                sentencia.setInt(3, producto.getProductoStock());
                sentencia.setString(4, producto.getProductoNombre());

                sentencia.executeUpdate();

                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
        
    }
    
    public boolean agregarStock(Conexion con, Producto producto, int cantidad){
        
        int stock = producto.getProductoStock();
        stock = stock+cantidad;
        
        producto.setProductoStock(stock);
        
        proEditar(con, producto);
        
        return true;
        
    }
    
    public boolean quitarStock(Conexion con, Producto producto, int cantidad){
        
        int stock = producto.getProductoStock();
        stock = stock-cantidad;
        
        producto.setProductoStock(stock);
        
        proEditar(con, producto);
        
        return true;
        
    }
    
    
    public boolean eliminarProducto (Conexion con, String nombre){
        
        if(proBuscar(con, nombre)==null){
            try {

                sentencia = con.getConexion().prepareStatement("DELETE FROM vet_productos WHERE pro_nombre=?");

                sentencia.setString(1, nombre);

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




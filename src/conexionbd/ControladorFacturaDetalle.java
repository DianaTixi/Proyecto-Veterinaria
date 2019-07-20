/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.FacturaDetalle;
import modelo.Producto;

/**
 *
 * @author plojam
 */
public class ControladorFacturaDetalle {
    
    private ResultSet resultado = null;
    private PreparedStatement sentencia = null;
    
    
    public List<FacturaDetalle> detObtener(Conexion con, int facturaCabeceraNumero){
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        ControladorProducto controladorProducto = new ControladorProducto();
        List<FacturaDetalle> detalles = new ArrayList<>();
        
        try {
            sentencia = con.getConexion().prepareStatement("SELECT fde_id, fde_cantidad, fde_preciou, fde_subtotal, "
                    + "pro_id "
            + "FROM vet_factura_Detalles "
            + "WHERE fac_numerof = ?");
            sentencia.setInt(1, facturaCabeceraNumero);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                facturaDetalle.setFacturaDetalleId(resultado.getInt("fde_id"));
                facturaDetalle.setFacturaDetalleCantidad(resultado.getInt("fde_cantidad"));
                facturaDetalle.setFacturaDetallePrecioUnitario(resultado.getDouble("fde_preciou"));
                facturaDetalle.setFacturaDetalleSubtotal(resultado.getDouble("fde_subtotal"));
                Producto producto = controladorProducto.proBuscarId(con, resultado.getInt("pro_id"));
                facturaDetalle.setProducto(producto);
                detalles.add(facturaDetalle);
            }
            
            return detalles;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    public FacturaDetalle detBuscar(Conexion con, int facturaDetalleId){
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        ControladorProducto controladorProducto = new ControladorProducto();
        
        try {
            sentencia = con.getConexion().prepareStatement("SELECT fde_id, fde_cantidad, fde_preciou, fde_subtotal, "
                    + "fde_id "
            + "FROM vet_factura_Detalles "
            + "WHERE fde_id = ?");
            sentencia.setInt(1, facturaDetalleId);
            resultado= sentencia.executeQuery();

            //Se presenta el resultado
            while(resultado.next()){
                facturaDetalle.setFacturaDetalleId(resultado.getInt("fde_id"));
                facturaDetalle.setFacturaDetalleCantidad(resultado.getInt("fde_cantidad"));
                facturaDetalle.setFacturaDetallePrecioUnitario(resultado.getDouble("fde_preciou"));
                facturaDetalle.setFacturaDetalleSubtotal(resultado.getDouble("fde_subtotal"));
                Producto producto = controladorProducto.proBuscarId(con, resultado.getInt("pro_id"));
                facturaDetalle.setProducto(producto);
            }
            
            return facturaDetalle;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    public boolean detAgregar(Conexion con, FacturaDetalle facturaDetalle, int facturaCabeceraNumero){
        ControladorProducto controlarodProducto = new ControladorProducto();
        if(detBuscar(con, facturaDetalle.getFacturaDetalleId())==null){
            try {

                sentencia = con.getConexion().prepareStatement("INSERT INTO vet_factura_Detalles VALUES (fde_id_seq.nextval,?,?,?,?,?)");

                //sentencia.setInt(1, facturaDetalle.getFacturaDetalleId());
                sentencia.setInt(1, facturaDetalle.getFacturaDetalleCantidad());
                sentencia.setDouble(2, facturaDetalle.getFacturaDetallePrecioUnitario());
                sentencia.setDouble(3, facturaDetalle.getFacturaDetalleSubtotal());
                sentencia.setInt(4, facturaDetalle.getProducto().getProductoId());
                sentencia.setInt(5, facturaCabeceraNumero);

                sentencia.executeUpdate();

                controlarodProducto.quitarStock(con, facturaDetalle.getProducto(), facturaDetalle.getFacturaDetalleCantidad());
                
                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
    }
    
    
}



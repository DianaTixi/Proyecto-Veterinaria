/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.FacturaCabecera;
import modelo.FacturaDetalle;

/**
 *
 * @author plojam
 */
public class ControladorFacturaCabecera {
    
    private ResultSet resultado = null;
    private PreparedStatement sentencia = null;
    
    
    public List<FacturaCabecera> cabObtener(Conexion con){
        FacturaCabecera facturaCabecera = new FacturaCabecera();
        List<FacturaCabecera> cabeceras = new ArrayList<>();
        List<FacturaDetalle> detalles = new ArrayList<>();
        Cliente cliente = new Cliente();
        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorFacturaDetalle controladorFacturaDetalle = new ControladorFacturaDetalle();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT fac_numerof, fac_fecha, fac_subtotal, fac_iva, "
                    + "fac_descuento, fac_total, fac_metodop, fac_estado, fac_id "
            + "FROM cet_factura_Cabeceras "
            + "ORDER BY fac_numerof;");
            resultado= sentencia.executeQuery();
            
            //Se presenta el resultado
            while(resultado.next()){
                int cabeceraNumero = resultado.getInt("fac_numerof");
                facturaCabecera.setFacturaCabeceraNumero(cabeceraNumero);
                facturaCabecera.setFacturaCabeceraFehca(resultado.getDate("fac_fecha"));
                facturaCabecera.setFacturaCabeceraSubtotal(resultado.getDouble("fac_subtotal"));
                facturaCabecera.setFacturaCabeceraIva(resultado.getDouble("fac_iva"));
                facturaCabecera.setFacturaCabeceraDescuento(resultado.getDouble("fac_descuento"));
                facturaCabecera.setFacturaCabeceraTotal(resultado.getDouble("fac_total"));
                facturaCabecera.setFacturaCabeceraTipoPago(resultado.getString("fac_metodop"));
                facturaCabecera.setFacturaCabeceraEstado(resultado.getString("fac_estado"));
                int clienteId = resultado.getInt("cli_id");
                
                cliente = controladorCliente.cliBuscarId(con, clienteId);
                facturaCabecera.setCliente(cliente);
                
                detalles = controladorFacturaDetalle.detObtener(con, cabeceraNumero);
                for(int i=0; i<detalles.size();i++){
                    facturaCabecera.addFacturasDetalle(detalles.get(i));
                }
                
                cabeceras.add(facturaCabecera);
                
            }
            
            return cabeceras;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    public FacturaCabecera cabBuscar(Conexion con, int facturaCabeceraNumero){
        FacturaCabecera facturaCabecera = new FacturaCabecera();
        List<FacturaDetalle> detalles = new ArrayList<>();
        Cliente cliente = new Cliente();
        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorFacturaDetalle controladorFacturaDetalle = new ControladorFacturaDetalle();
        try {
            sentencia = con.getConexion().prepareStatement("SELECT fac_numerof, fac_fecha, fac_subtotal, fac_iva, "
                    + "fac_descuento, fac_total, fac_metodop, fac_estado, cli_id "
            + "FROM vet_factura_Cabeceras "
            + "WHERE fac_numerof = ?");
            sentencia.setInt(1, facturaCabeceraNumero);
            resultado= sentencia.executeQuery();
            
            //Se presenta el resultado
            while(resultado.next()){
                int cabeceraNumero = resultado.getInt("fac_numerof");
                facturaCabecera.setFacturaCabeceraNumero(cabeceraNumero);
                facturaCabecera.setFacturaCabeceraFehca(resultado.getDate("fac_fecha"));
                facturaCabecera.setFacturaCabeceraSubtotal(resultado.getDouble("fac_subtotal"));
                facturaCabecera.setFacturaCabeceraIva(resultado.getDouble("fac_iva"));
                facturaCabecera.setFacturaCabeceraDescuento(resultado.getDouble("fac_descuento"));
                facturaCabecera.setFacturaCabeceraTotal(resultado.getDouble("fac_total"));
                facturaCabecera.setFacturaCabeceraTipoPago(resultado.getString("fac_metodop"));
                facturaCabecera.setFacturaCabeceraEstado(resultado.getString("fac_estado"));
                
                int clienteId = resultado.getInt("cli_id");
                cliente = controladorCliente.cliBuscarId(con, clienteId);
                facturaCabecera.setCliente(cliente);
                
                
                
                detalles = controladorFacturaDetalle.detObtener(con, cabeceraNumero);
                for(int i=0; i<detalles.size();i++){
                    facturaCabecera.addFacturasDetalle(detalles.get(i));
                }
                
            }
            
            return facturaCabecera;
            
        } catch (SQLException e) {
            e.printStackTrace();
            
            return null;
            
        }
        
    }
    
    
    private int obtenerId(Conexion con){
        int cabeceraNumero=0;
        try {
            
            sentencia = con.getConexion().prepareStatement("SELECT max(fac_numerof) "
            + "FROM vet_factura_Cabeceras");
            resultado= sentencia.executeQuery();

            while(resultado.next()){
                cabeceraNumero = resultado.getInt("fac_numerof");

            }

            return cabeceraNumero;

        } catch (SQLException e) {
            e.printStackTrace();

            return 0;

        }

        
    }
    
    
    public boolean cabAgregar(Conexion con, FacturaCabecera facturaCabecera){
        ControladorFacturaDetalle controladorFacturaDetalle = new ControladorFacturaDetalle();
        ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
        if(cabBuscar(con, facturaCabecera.getFacturaCabeceraNumero())==null){
            
            
            try {

                sentencia = con.getConexion().prepareStatement("INSERT INTO vet_factura_Cabeceras VALUES (fac_numeroF_seq.nextval,?,?,?,?,?,?,?,?)");

                sentencia.setInt(1, facturaCabecera.getFacturaCabeceraNumero());
                sentencia.setDate(2, (Date) facturaCabecera.getFacturaCabeceraFehca());
                sentencia.setDouble(3, facturaCabecera.getFacturaCabeceraSubtotal());
                sentencia.setDouble(4, facturaCabecera.getFacturaCabeceraIva());
                sentencia.setDouble(5, facturaCabecera.getFacturaCabeceraDescuento());
                sentencia.setDouble(6, facturaCabecera.getFacturaCabeceraTotal());
                sentencia.setString(7, facturaCabecera.getFacturaCabeceraTipoPago());
                sentencia.setString(8, facturaCabecera.getFacturaCabeceraEstado());
                sentencia.setInt(9, facturaCabecera.getCliente().getClienteId());
                
                sentencia.executeUpdate();
                
                int cabeceraNumero=controladorFacturaCabecera.obtenerId(con);
                
                for(int i=0; i<facturaCabecera.getFacturasDetalle().size();i++){
                    controladorFacturaDetalle.detAgregar(con, facturaCabecera.getFacturasDetalle().get(i), cabeceraNumero);
                }

                return true;
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            
        } else
            return false;
        
    }
    
    
    public boolean cabCancelar (Conexion con, FacturaCabecera facturaCabecera){
        ControladorProducto controlarodProducto = new ControladorProducto();
        if(cabBuscar(con, facturaCabecera.getFacturaCabeceraNumero())!=null){
            try {
                
                sentencia = con.getConexion().prepareStatement("UPDATE vet_factura_Cabeceras SET "
                + "fac_estado=? "
                + "WHERE fac_numerof=?");

                sentencia.setString(1, facturaCabecera.getFacturaCabeceraEstado());
                sentencia.setInt(2, facturaCabecera.getFacturaCabeceraNumero());
                
                for(int i=0; i<facturaCabecera.getFacturasDetalle().size(); i++){
                    
                    controlarodProducto.agregarStock(con, facturaCabecera.getFacturasDetalle().get(i).getProducto(), facturaCabecera.getFacturasDetalle().get(i).getFacturaDetalleCantidad());
                    
                }
                
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


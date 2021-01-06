package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.Coordinador;

public class LogicaConsultas {
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

	public void mostrarTablaTrabajador(Connection conexion, JTable tabla) {
		 try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Trabajador;" );
			while (rs.next()) {
			       String rut = rs.getString(1);
			       String nombre = rs.getString(2);
			       String tel�fono  = rs.getString("tel�fono_trab");
			       String correo = rs.getString("correo_trab");
			    
			       miCoordinador.agregarDatosATabla(nombre,rut,tel�fono,correo, tabla);
			    }
			miCoordinador.cerrarConexion(stmt, rs, conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disponibilidadProductoYValor(Connection conexion, JTable tabla, String producto) {
		 try {
				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery( "SELECT c�digo, descripci�n, stock, precio_actual FROM producto WHERE producto.c�digo= '"+producto+"';" );
				while (rs.next()) {
				       String c�digo = rs.getString("c�digo");
				       String descripci�n = rs.getString("descripci�n");
				       String stock  = rs.getString("stock");
				       String precioActual = rs.getString("precio_actual");				       
				       	
				       miCoordinador.agregarDatosATabla(c�digo,descripci�n,stock,precioActual,tabla);
				    }
				miCoordinador.cerrarConexion(stmt, rs, conexion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	public void buscarDeudores(Connection cn, JTable tabla) {
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT estado, doc_fac ,monto_total, correo_emp, tel�fono_emp, rut_trabajador, nombre\r\n"
					+ "FROM factura , empresa, trabajador , venta_fc \r\n"
					+ "WHERE factura.estado = 'impaga' AND factura.doc_fac = venta_fc.doc_fc AND factura.rut_empresa = empresa.rut_empresa AND venta_fc.rut_trabajador_fc = trabajador.rut_trabajador;" );
			while (rs.next()) {
			       String estado = rs.getString("estado");
			       String doc_fac = rs.getString("doc_fac");
			       String monto_total  = rs.getString("monto_total");
			       String correo_emp = rs.getString("correo_emp");
			       String tel�fono_emp = rs.getString("tel�fono_emp");
			       String rut_trabajador = rs.getString("rut_trabajador");
			       String nombre = rs.getString("nombre");
			       miCoordinador.agregarDatosATabla(estado,doc_fac,monto_total,correo_emp,tel�fono_emp,rut_trabajador,nombre,tabla);
			       System.out.println(estado);
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void buscarProducto(Connection cn, String cod, JTextField textC�dBarra, JTextField textDecripci�n, JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT c�digo, c�digo_barra ,descripci�n, stock, precio_actual, familia\r\n"
					+ "FROM producto \r\n"
					+ "WHERE c�digo = '"+cod+"';" );
			while (rs.next()) {
			       //String c�digo = rs.getString("c�digo");
			       String c�digo_barra = rs.getString("c�digo_barra");
			       String descripci�n = rs.getString("descripci�n");
			       String stock  = rs.getString("stock");
			       String precio_actual = rs.getString("precio_actual");
			       String familia = rs.getString("familia");
			
			       miCoordinador.agregarDatosProductoBuscado(c�digo_barra,descripci�n,stock,precio_actual,familia, textC�dBarra, textDecripci�n, textFamilia, textPrecioActual, textStock);
			       
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void agregarProducto(Connection cn, JTextField textC�digo, JTextField textC�dBarra, JTextField textDescripci�n, JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		try {
			
			String c�digo = textC�digo.getText();
			String c�dBarra = textC�dBarra.getText();
			String descripci�n = textDescripci�n.getText();
			String familia = textFamilia.getText();
			Integer precioActual = Integer.parseInt(textPrecioActual.getText());
			Integer stock = Integer.parseInt(textStock.getText());
			Integer stockCr�tico = 10;
			
			PreparedStatement stmt = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?,?);");
			stmt.setString(1, c�digo);
			stmt.setString(2, c�dBarra);
			stmt.setString(3, descripci�n);
			stmt.setString(6, familia);
			stmt.setInt(5, precioActual);
			stmt.setInt(4, stock);
			stmt.setInt(7, stockCr�tico);
			
			stmt.executeUpdate();
				
		    stmt.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void mostrarTablaProductos(Connection cn, JTable tabla) {
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT c�digo, descripci�n ,familia, stock, precio_actual\r\n"
					+ "FROM producto  ;" );
			while (rs.next()) {
			       String c�digo = rs.getString("c�digo");
			       String descripci�n = rs.getString("descripci�n");
			       String familia  = rs.getString("familia");
			       String stock = rs.getString("stock");
			       String precio_actual = rs.getString("precio_actual");
			       miCoordinador.agregarDatosATablaProducto(c�digo,descripci�n,familia,stock,precio_actual,tabla);
			       
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}

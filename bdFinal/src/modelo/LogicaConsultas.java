package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

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
			       
			       System.out.println( "Sucursal = "+nombre+" Rut = "+rut+" N� Tel�fono = "+tel�fono );
			       System.out.println();
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
				ResultSet rs = stmt.executeQuery( "Select c�digo, descripci�n, stock, precio_actual FROM producto WHERE producto.c�digo= '"+producto+"';" );
				while (rs.next()) {
				       String c�digo = rs.getString("c�digo");
				       String descripci�n = rs.getString("descripci�n");
				       String stock  = rs.getString("stock");
				       String precioActual = rs.getString("precio_actual");
				       
				       System.out.println( "C�digo = "+c�digo+" Descripcci�n = "+descripci�n+" N� Tel�fono = "+stock+"Precio Actual = "+precioActual );
				       System.out.println();
				       miCoordinador.agregarDatosATabla(c�digo,descripci�n,stock,precioActual,tabla);
				    }
				miCoordinador.cerrarConexion(stmt, rs, conexion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	

}

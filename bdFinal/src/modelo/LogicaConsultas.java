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
			       String teléfono  = rs.getString("teléfono_trab");
			       String correo = rs.getString("correo_trab");
			       
			       System.out.println( "Sucursal = "+nombre+" Rut = "+rut+" N° Teléfono = "+teléfono );
			       System.out.println();
			       miCoordinador.agregarDatosATabla(nombre,rut,teléfono,correo, tabla);
			    }
			miCoordinador.cerrarConexion(stmt, rs, conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disponibilidadProductoYValor(Connection conexion, JTable tabla, String producto) {
		 try {
				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery( "Select código, descripción, stock, precio_actual FROM producto WHERE producto.código= '"+producto+"';" );
				while (rs.next()) {
				       String código = rs.getString("código");
				       String descripción = rs.getString("descripción");
				       String stock  = rs.getString("stock");
				       String precioActual = rs.getString("precio_actual");
				       
				       System.out.println( "Código = "+código+" Descripcción = "+descripción+" N° Teléfono = "+stock+"Precio Actual = "+precioActual );
				       System.out.println();
				       miCoordinador.agregarDatosATabla(código,descripción,stock,precioActual,tabla);
				    }
				miCoordinador.cerrarConexion(stmt, rs, conexion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	
	
	

}

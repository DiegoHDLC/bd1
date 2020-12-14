package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.Coordinador;

public class LogicaConsultas {
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

	public void mostrarTablaTrabajador(Connection conexion) {
		 try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Trabajador;" );
			while (rs.next()) {
			       String rut = rs.getString(1);
			       String nombre = rs.getString(2);
			       String correo  = rs.getString("teléfono_trab");
			       System.out.println( "Nombre = "+nombre+" Rut = "+rut+" Correo = "+correo );
			       System.out.println();
			    }
			miCoordinador.cerrarConexion(stmt, rs, conexion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}

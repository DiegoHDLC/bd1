package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.Coordinador;

public class Conexion {
	@SuppressWarnings("unused")
	private Coordinador miCoordinador;
	public Connection connectDatabase() {
		try {
		    Class.forName("org.postgresql.Driver");
		    Connection conexion = DriverManager.getConnection("jdbc:postgresql://10.4.3.195:5432/repuestos",
                    "repuestos_dev", "a9Bl93k2");
		    System.out.println("Conexion exitosa.");
		    return conexion;

		 } catch ( Exception e ) {
		    System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		 }
		return null;
	}
	
	public void cerrarConexion(Statement stmt, ResultSet rs, Connection conexion) {
	    try {
	    	rs.close();
		    stmt.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

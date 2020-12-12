package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import controlador.Coordinador;

public class Conexion {
	private Coordinador miCoordinador;
	public void connectDatabase() {
		try {
		    Class.forName("org.postgresql.Driver");
		   Connection conexion = DriverManager.getConnection("jdbc:postgresql://10.4.3.195:5432/repuestos",
                    "repuestos_dev", "a9Bl93k2");
		    System.out.println("Conexion exitosa.");

		    Statement stmt = conexion.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Vendedor;" );

		    while (rs.next()) {
		       String rut = rs.getString(1);
		       String nombre = rs.getString(2);
		       String correo  = rs.getString("teléfono");
		       System.out.println( "Nombre = "+nombre+" Rut = "+rut+" Correo = "+correo );
		       System.out.println();
		    }

		    rs.close();
		    stmt.close();
		    conexion.close();

		 } catch ( Exception e ) {

		    System.err.println( e.getClass().getName()+": "+ e.getMessage() );

		 }
	}
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import controlador.Coordinador;

public class Conexion {
	@SuppressWarnings("unused")
	private Coordinador miCoordinador;
	public MongoDatabase connectDatabase() {
		try {
		MongoClient mongoClient = MongoClients.create("mongodb+srv://dherrera:dherrera123@cluster0.hjcq9.mongodb.net/Repuestos?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Repuestos");

        //database.createCollection("java4");
        return database;
		}catch(Error e){
			
		}

		/*
		try {
		    Class.forName("org.postgresql.Driver");
		    Connection conexion = DriverManager.getConnection("jdbc:postgresql://10.4.3.195:5432/repuestos",
                    "repuestos_dev", "a9Bl93k2");
		    System.out.println("Conexion exitosa.");
		    return conexion;

		 } catch ( Exception e ) {
		    System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		 }
		
		*/
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

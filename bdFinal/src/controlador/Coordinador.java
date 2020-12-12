package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import utils.JavaPostgreSQLBasic;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

public class Coordinador {
	
	private VentanaLogin ventanaLogin;
	private VentanaPrincipal ventanaPrincipal;
	private LogicaLogin logicaLogin;
	private LogicaPrincipal logicaPrincipal;
	private JavaPostgreSQLBasic javaPostgreSQL;
	private Conexion conexion;
	
	public Coordinador() {
		
	}

	public void movimientoVentana(JPanel panelGeneralLogin) {	
		
	}

	public void setVentanaLogin(VentanaLogin ventanaLogin) {
		this.ventanaLogin = ventanaLogin;
		
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;	
	}
	
	public void setLogicaLogin(LogicaLogin logicaLogin) {
		this.logicaLogin = logicaLogin;
		
	}

	public void abrirVentanaPrincipal() {
		ventanaLogin.getFrame().dispose();
		logicaLogin.abrirVentanaPrincipal(ventanaPrincipal);
		
		
	}

	public void setLogicaPrincipal(LogicaPrincipal logicaPrincipal) {
		this.logicaPrincipal = logicaPrincipal;
		
	}

	public void setJavaPostgreSQL(JavaPostgreSQLBasic javaPostgreSQL) {
		this.javaPostgreSQL = javaPostgreSQL;
		
	}

	

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
		
	}
	
	public void conexiónBD() {
		conexion.connectDatabase();
	}

	
	
}

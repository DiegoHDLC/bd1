package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

public class Coordinador {
	
	private VentanaLogin ventanaLogin;
	private VentanaPrincipal ventanaPrincipal;
	private LogicaLogin logicaLogin;
	private LogicaPrincipal logicaPrincipal;
	private Conexion conexion;
	private LogicaConsultas logicaConsultas;
	
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

	

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
		
	}
	
	public void conexiónBD() {
		conexion.connectDatabase();
	}

	public void setLogicaConsultas(LogicaConsultas logicaConsultas) {
		this.logicaConsultas = logicaConsultas;
		
	}

	public void cerrarConexion(Statement stmt, ResultSet rs, Connection cn) {
		conexion.cerrarConexion(stmt,rs,cn);
	}

	public void mostrarTablaTrabajador() {
		Connection cn = conexion.connectDatabase();
		logicaConsultas.mostrarTablaTrabajador(cn);
		
	}

	public void abrirTabla(JScrollPane scrollPane) {
		logicaPrincipal.abrirTabla(scrollPane);
		
	}

	
	
}

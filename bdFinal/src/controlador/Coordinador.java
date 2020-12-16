package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.Deudores;
import vista.DisponibilidadProducto;
import vista.GestionarEmpresa;
import vista.GestionarProductos;
import vista.GestionarTrabajador;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentasRapidas;

public class Coordinador {
	
	private VentanaLogin ventanaLogin;
	private VentanaPrincipal ventanaPrincipal;
	private LogicaLogin logicaLogin;
	private LogicaPrincipal logicaPrincipal;
	private Conexion conexion;
	private LogicaConsultas logicaConsultas;
	private DisponibilidadProducto ventDispProduct;
	private VentasRapidas ventasRapidas;
	private GestionarTrabajador gestionarTrabajador;
	private GestionarProductos gestionarProductos;
	private GestionarEmpresa gestionarEmpresa;
	private Deudores deudores;
	
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
	
	public void conexi�nBD() {
		conexion.connectDatabase();
	}

	public void setLogicaConsultas(LogicaConsultas logicaConsultas) {
		this.logicaConsultas = logicaConsultas;
		
	}

	public void cerrarConexion(Statement stmt, ResultSet rs, Connection cn) {
		conexion.cerrarConexion(stmt,rs,cn);
	}

	public void mostrarTablaTrabajador(JTable tabla) {
		Connection cn = conexion.connectDatabase();
		//tabla = logicaPrincipal.definirColumnas(tabla);
		logicaConsultas.mostrarTablaTrabajador(cn, tabla);
	}

	public void abrirTabla(JScrollPane scrollPane) {
		logicaPrincipal.abrirTabla(scrollPane);
		
	}

	public void agregarDatosATabla(String nombre, String rut, String tel�fono, String correo, JTable tabla) {
		logicaPrincipal.agregarDatosAtabla(nombre,rut,tel�fono,correo,tabla);
		
	}
	public void disponibilidadProductoYValor(JTable tabla, String producto) {
		Connection cn = conexion.connectDatabase();
		logicaConsultas.disponibilidadProductoYValor(cn, tabla, producto);
		
	}

	public void agregarDatosATablaDisponibilidadPYV(String c�digo, String descripci�n, String stock, String precioActual, JTable tabla) {
		logicaPrincipal.agregarDatosATablaDisponibilidadPYV(c�digo,descripci�n,stock,precioActual, tabla);
		
	}

	public JTable crearTablaDisponibilidadProducto(JScrollPane scrollPane, JTable tabla) {
		tabla = logicaPrincipal.crearTablaDisponibilidadProducto(scrollPane, tabla);
		return tabla;
		
	}

	public void setVentDispProduct(DisponibilidadProducto ventDispProduct) {
		this.ventDispProduct = ventDispProduct;
		
	}

	public void abrirVentanaDispProduct() {
		ventDispProduct.setVisible(true);
		
	}

	public void abrirVentanaVentasRapidas() {
		ventasRapidas.setVisible(true);
		
	}

	public void setVentasRapidas(VentasRapidas ventasRapidas) {
		this.ventasRapidas = ventasRapidas;
		
	}

	public void abrirVentanaGestionarTrabajador() {
		gestionarTrabajador.setVisible(true);
		
	}

	public void setGestionarTrabajador(GestionarTrabajador gestionarTrabajador) {
		this.gestionarTrabajador = gestionarTrabajador;
		
	}

	public void setGestionarProductos(GestionarProductos gestionarProductos) {
		this.gestionarProductos = gestionarProductos;
		
	}

	public void abrirVentanaGestionarProducto() {
		gestionarProductos.setVisible(true);
		
	}

	public void setGestionarEmpresa(GestionarEmpresa gestionarEmpresa) {
		this.gestionarEmpresa = new GestionarEmpresa();
		
	}

	public void abrirVentanaGestionarEmpresa() {
		gestionarEmpresa.setVisible(true);
		
	}

	public void setDeudores(Deudores deudores) {
		this.deudores = deudores;
		
	}
	
	public void abrirVentanaDeudores() {
		deudores.setVisible(true);
	}

	public void buscarDeudores(JTable tabla) {
		Connection cn = conexion.connectDatabase();
		logicaConsultas.buscarDeudores(cn,tabla);
	}

	public void agregarDatosATabla(String estado, String doc_fac, String monto_total, String correo_emp,
			String tel�fono_emp, String rut_trabajador, String nombre, JTable tabla) {
		logicaPrincipal.agregarDatosATabla(estado, doc_fac, monto_total, correo_emp, tel�fono_emp, rut_trabajador, nombre, tabla);
		
	}

	public JTable crearTablaDeudores(JScrollPane scrollPane, JTable tabla) {
		tabla = logicaPrincipal.crearTablaDeudores(scrollPane, tabla);
		return tabla;
	}


	public void buscarProducto(String c�digo, JTextField textC�digo, JTextField textC�dBarra, JTextField textDecripci�n,
			JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		Connection cn = conexion.connectDatabase();
		logicaConsultas.buscarProducto(cn, c�digo, textC�dBarra, textDecripci�n, textFamilia, textPrecioActual, textStock);
	}

	public void agregarDatosProductoBuscado(String c�digo_barra, String stock, String descripci�n, String precio_actual,
			String familia, JTextField textC�dBarra, JTextField textDescripci�n, JTextField textFamilia,
			JTextField textPrecioActual, JTextField textStock) {
		logicaPrincipal.rellenarCamposProducto(c�digo_barra, stock, descripci�n, precio_actual, familia, textC�dBarra, textDescripci�n, textFamilia, textPrecioActual, textStock);
		
	}

	public void agregarProducto(JTextField textC�digo, JTextField textC�dBarra, JTextField textDescripci�n, JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		Connection cn = conexion.connectDatabase();
		logicaConsultas.agregarProducto(cn, textC�digo, textC�dBarra, textDescripci�n, textFamilia, textPrecioActual, textStock);
		
	}




	
	
}

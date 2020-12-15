package principal;

import controlador.Coordinador;
import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.DisponibilidadProducto;
import vista.GestionarProductos;
import vista.GestionarTrabajador;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentasRapidas;

public class Principal {

	public static void main(String[] args) {
		Coordinador miCoordinador = new Coordinador();
		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		LogicaLogin logicaLogin = new LogicaLogin();
		LogicaPrincipal logicaPrincipal = new LogicaPrincipal();
		Conexion conexion = new Conexion();
		LogicaConsultas logicaConsultas = new LogicaConsultas();
		DisponibilidadProducto ventDispProduct = new DisponibilidadProducto();
		VentasRapidas ventasRapidas = new VentasRapidas();
		GestionarTrabajador gestionarTrabajador = new GestionarTrabajador();
		GestionarProductos gestionarProductos = new GestionarProductos();
		
		
		ventanaLogin.setCoordinador(miCoordinador);
		ventanaPrincipal.setCoordinador(miCoordinador);
		logicaLogin.setCoordinador(miCoordinador);
		logicaPrincipal.setCoordinador(miCoordinador);
		conexion.setCoordinador(miCoordinador);
		logicaConsultas.setCoordinador(miCoordinador);
		ventDispProduct.setCoordinador(miCoordinador);
		ventasRapidas.setCoordinador(miCoordinador);
		gestionarTrabajador.setCoordinador(miCoordinador);
		gestionarProductos.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaLogin(ventanaLogin);
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setLogicaLogin(logicaLogin);
		miCoordinador.setLogicaPrincipal(logicaPrincipal);
		miCoordinador.setConexion(conexion);
		miCoordinador.setLogicaConsultas(logicaConsultas);
		miCoordinador.setVentDispProduct(ventDispProduct);
		miCoordinador.setVentasRapidas(ventasRapidas);
		miCoordinador.setGestionarTrabajador(gestionarTrabajador);
		miCoordinador.setGestionarProductos(gestionarProductos);
		
		ventanaLogin.setVisible(true);

	}

}

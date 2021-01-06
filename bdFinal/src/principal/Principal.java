package principal;

import controlador.Coordinador;
import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.Deudores;
import vista.DisponibilidadProducto;
import vista.GestionarEmpresa;
import vista.GestionarProductos;
import vista.GestionarTrabajador;
import vista.Gráfico;
import vista.VentanaListaProductos;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaPrincipal;

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
		VentanaPrincipal ventasRapidas = new VentanaPrincipal();
		GestionarTrabajador gestionarTrabajador = new GestionarTrabajador(ventanaPrincipal, false);
		GestionarProductos gestionarProductos = new GestionarProductos();
		GestionarEmpresa gestionarEmpresa = new GestionarEmpresa();
		Deudores deudores = new Deudores();
		VentanaListaProductos listaProductos = new VentanaListaProductos();
		Gráfico gráfico = new Gráfico();
		
		
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
		gestionarEmpresa.setCoordinador(miCoordinador);
		deudores.setCoordinador(miCoordinador);
		listaProductos.setCoordinador(miCoordinador);
		gráfico.setCoordinador(miCoordinador);
		
		
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
		miCoordinador.setGestionarEmpresa(gestionarEmpresa);
		miCoordinador.setDeudores(deudores);
		miCoordinador.setListaProductos(listaProductos);
		miCoordinador.setGráfico(gráfico);
		
		ventanaLogin.setVisible(true);

	}

}

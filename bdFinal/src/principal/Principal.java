package principal;

import controlador.Coordinador;
import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.DisponibilidadProducto;
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
		
		
		ventanaLogin.setCoordinador(miCoordinador);
		ventanaPrincipal.setCoordinador(miCoordinador);
		logicaLogin.setCoordinador(miCoordinador);
		logicaPrincipal.setCoordinador(miCoordinador);
		conexion.setCoordinador(miCoordinador);
		logicaConsultas.setCoordinador(miCoordinador);
		ventDispProduct.setCoordinador(miCoordinador);
		ventasRapidas.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaLogin(ventanaLogin);
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setLogicaLogin(logicaLogin);
		miCoordinador.setLogicaPrincipal(logicaPrincipal);
		miCoordinador.setConexion(conexion);
		miCoordinador.setLogicaConsultas(logicaConsultas);
		miCoordinador.setVentDispProduct(ventDispProduct);
		miCoordinador.setVentasRapidas(ventasRapidas);
		
		ventanaLogin.setVisible(true);

	}

}

package principal;

import controlador.Coordinador;
import modelo.LogicaConsultas;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import vista.VentanaLogin;
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
		
		
		ventanaLogin.setCoordinador(miCoordinador);
		ventanaPrincipal.setCoordinador(miCoordinador);
		logicaLogin.setCoordinador(miCoordinador);
		logicaPrincipal.setCoordinador(miCoordinador);
		conexion.setCoordinador(miCoordinador);
		logicaConsultas.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaLogin(ventanaLogin);
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setLogicaLogin(logicaLogin);
		miCoordinador.setLogicaPrincipal(logicaPrincipal);
		miCoordinador.setConexion(conexion);
		miCoordinador.setLogicaConsultas(logicaConsultas);
		
		ventanaLogin.setVisible(true);

	}

}

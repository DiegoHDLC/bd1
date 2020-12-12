package principal;

import controlador.Coordinador;
import modelo.LogicaLogin;
import modelo.LogicaPrincipal;
import utils.Conexion;
import utils.JavaPostgreSQLBasic;
import vista.VentanaLogin;
import vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		Coordinador miCoordinador = new Coordinador();
		VentanaLogin ventanaLogin = new VentanaLogin();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		LogicaLogin logicaLogin = new LogicaLogin();
		LogicaPrincipal logicaPrincipal = new LogicaPrincipal();
		JavaPostgreSQLBasic javaPostgreSQL = new JavaPostgreSQLBasic();
		Conexion conexion = new Conexion();
		
		
		ventanaLogin.setCoordinador(miCoordinador);
		ventanaPrincipal.setCoordinador(miCoordinador);
		logicaLogin.setCoordinador(miCoordinador);
		logicaPrincipal.setCoordinador(miCoordinador);
		javaPostgreSQL.setCoordinador(miCoordinador);
		conexion.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaLogin(ventanaLogin);
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setLogicaLogin(logicaLogin);
		miCoordinador.setLogicaPrincipal(logicaPrincipal);
		miCoordinador.setJavaPostgreSQL(javaPostgreSQL);
		miCoordinador.setConexion(conexion);
		
		ventanaLogin.setVisible(true);

	}

}

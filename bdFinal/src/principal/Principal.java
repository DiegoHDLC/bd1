package principal;

import controlador.Coordinador;
import modelo.LogicaVentana;
import vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		Coordinador miCoordinador = new Coordinador();
		VentanaPrincipal ventana = new VentanaPrincipal();
		LogicaVentana logicaVentana = new LogicaVentana();
		
		
		ventana.setCoordinador(miCoordinador);
		logicaVentana.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaPrincipal(ventana);
		miCoordinador.setLogicaVentana(logicaVentana);
		
		ventana.setVisible(true);

	}

}

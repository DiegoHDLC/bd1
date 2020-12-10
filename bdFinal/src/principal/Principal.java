package principal;

import controlador.Coordinador;
import vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		Coordinador miCoordinador = new Coordinador();
		VentanaPrincipal ventana = new VentanaPrincipal();
		
		
		ventana.setCoordinador(miCoordinador);
		
		
		miCoordinador.setVentanaPrincipal(ventana);
		
		
		ventana.setVisible(true);

	}

}

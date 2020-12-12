package modelo;

import controlador.Coordinador;
import vista.VentanaPrincipal;

public class LogicaLogin {
	private Coordinador miCoordinador;
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
	public void abrirVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		ventanaPrincipal.setVisible(true);
	}
	
}

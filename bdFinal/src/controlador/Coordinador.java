package controlador;

import modelo.LogicaVentana;
import vista.VentanaPrincipal;

public class Coordinador {
	
	private VentanaPrincipal ventana;
	private LogicaVentana logicaVentana;
	
	public Coordinador() {
		
	}
	
	
	
	public void setVentanaPrincipal(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	

	public void setLogicaVentana(LogicaVentana logicaVentana) {
		this.logicaVentana = logicaVentana;
		
	}
	
	
}

package modelo;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;

public class LogicaPrincipal {
	private Coordinador miCoordinador;
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	public void abrirTabla(JScrollPane scrollPane) {
		JTable table = new JTable();
		
		table.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Subt\u00EDtulo", "Tiempo"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(246);
		table.getColumnModel().getColumn(2).setPreferredWidth(118);
		scrollPane.setViewportView(table);
	}
	
}

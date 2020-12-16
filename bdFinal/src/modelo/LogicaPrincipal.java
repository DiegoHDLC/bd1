package modelo;

import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	public void agregarDatosAtabla(String nombre, String rut, String teléfono, String correo, JTable tabla) {
		Object [] fila = new Object[4];
		fila[0] = nombre;
		fila[1] = rut;
		fila[2] = teléfono;
		fila[3] = correo;
		 ((DefaultTableModel) tabla.getModel()).addRow(fila);
		
	}
	public JTable definirColumnas() {
		JTable tabla = new JTable();
		
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Sucursal", "RUT", "Teléfono", "Correo"
				}
			));
		return tabla;
	}
	public void agregarDatosATablaDisponibilidadPYV(String código, String descripción, String stock,
			String precioActual, JTable tabla) {
		// TODO Auto-generated method stub
		
	}
	public JTable crearTablaDisponibilidadProducto(JScrollPane scrollPane, JTable tabla) {
		Vector columnas = new Vector();
		columnas.add("Código");
		columnas.add("Descripción");
		columnas.add("Stock");
		columnas.add("Precio actual");
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		//filas.add(fila);
		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		return tabla;
	}
	public void agregarDatosATabla(String estado, String doc_fac, String monto_total, String correo_emp,
			String teléfono_emp, String rut_trabajador, String nombre, JTable tabla) {
		Object [] fila = new Object[7];
		fila[0] = estado;
		fila[1] = doc_fac;
		fila[2] = monto_total;
		fila[3] = correo_emp;
		fila[4] = teléfono_emp;
		fila[5] = rut_trabajador;
		fila[6] = nombre;
		 ((DefaultTableModel) tabla.getModel()).addRow(fila);
		
	}
	public JTable crearTablaDeudores(JScrollPane scrollPane, JTable tabla) {
		Vector columnas = new Vector();
		columnas.add("Estado");
		columnas.add("Documento");
		columnas.add("Monto Total");
		columnas.add("Correo");
		columnas.add("Teléfono");
		columnas.add("RUT Trabajador");
		columnas.add("Nombre");
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		//filas.add(fila);
		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		return tabla;
		
	}
	
	
	public void rellenarCamposProducto(String código_barra, String descripción, String stock, String precio_actual, 
			String familia, JTextField textCódBarra, JTextField textDescripción, JTextField textFamilia, JTextField textPrecioActual,
			JTextField textStock) {
		textCódBarra.setText(código_barra);
		textStock.setText(stock);
		textDescripción.setText(descripción);
		textPrecioActual.setText(precio_actual);
		textFamilia.setText(familia);
		
		
		
	}
	
}

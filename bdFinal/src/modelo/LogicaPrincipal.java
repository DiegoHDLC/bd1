package modelo;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
	public void agregarDatosAtabla(String nombre, String rut, String tel�fono, String correo, JTable tabla) {
		Object [] fila = new Object[4];
		fila[0] = nombre;
		fila[1] = rut;
		fila[2] = tel�fono;
		fila[3] = correo;
		 ((DefaultTableModel) tabla.getModel()).addRow(fila);
		
	}
	public JTable definirColumnas() {
		JTable tabla = new JTable();
		
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Sucursal", "RUT", "Tel�fono", "Correo"
				}
			));
		return tabla;
	}
	public void agregarDatosATablaDisponibilidadPYV(String c�digo, String descripci�n, String stock,
			String precioActual, JTable tabla) {
		// TODO Auto-generated method stub
		
	}
	public JTable crearTablaDisponibilidadProducto(JScrollPane scrollPane, JTable tabla) {
		Vector columnas = new Vector();
		columnas.add("C�digo");
		columnas.add("Descripci�n");
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
			String tel�fono_emp, String rut_trabajador, String nombre, JTable tabla) {
		Object [] fila = new Object[7];
		fila[0] = estado;
		fila[1] = doc_fac;
		fila[2] = monto_total;
		fila[3] = correo_emp;
		fila[4] = tel�fono_emp;
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
		columnas.add("Tel�fono");
		columnas.add("RUT Trabajador");
		columnas.add("Nombre");
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		//filas.add(fila);
		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		return tabla;
		
	}
	
	
	public void rellenarCamposProducto(String c�digo_barra, String descripci�n, String stock, String precio_actual, 
			String familia, JTextField textC�dBarra, JTextField textDescripci�n, JTextField textFamilia, JTextField textPrecioActual,
			JTextField textStock) {
		textC�dBarra.setText(c�digo_barra);
		textStock.setText(stock);
		textDescripci�n.setText(descripci�n);
		textPrecioActual.setText(precio_actual);
		textFamilia.setText(familia);
		
		
		
	}
	public JTable crearTablaProductos(JScrollPane scrollPane, JTable tabla) {
		Vector columnas = new Vector();
		columnas.add("C�digo");
		columnas.add("Descripcci�n");
		columnas.add("Familia");
		columnas.add("Stock");
		columnas.add("Precio");

		
		Vector filas = new Vector();
		Vector fila = new Vector();

		//filas.add(fila);
		tabla = new JTable(filas,columnas);

		scrollPane.setViewportView(tabla);
		return tabla;
	}
	public void agregarDatosATabla(String c�digo, String descripci�n, String familia, String stock,
			String precio_actual, JTable tabla) {
		Object [] fila = new Object[7];
		fila[0] = c�digo;
		fila[1] = descripci�n;
		fila[2] = familia;
		fila[3] = stock;
		fila[4] = precio_actual;
		 ((DefaultTableModel) tabla.getModel()).addRow(fila);
		
	}
	
	public static void crearGrafico(ArrayList<String> nombreProductos, ArrayList<Integer> cantidadProductos ) {
		XYSeries oSeries = new XYSeries("");
	   	
   		for(int i = 0; i < tiempo.size()-1;i++) {
   			oSeries.add(tamano.get(i),tiempo.get(i));
   		}
   	
   		XYSeriesCollection oDataset = new XYSeriesCollection();
   		
   		oDataset.addSeries(oSeries);
   		
   		
   		JFreeChart oChart = ChartFactory.createXYLineChart("HeapSort", "Productos", "Cantidad de productos", oDataset, PlotOrientation.VERTICAL, true, false, false);
   		oChart.setBackgroundPaint(new Color(208, 121, 3));
   		ChartPanel oPanel = new ChartPanel(oChart);
   		
   		panelGrafico.setLayout(new java.awt.BorderLayout());
   		panelGrafico.add(oPanel);
   		panelGrafico.validate();
	}
	
}

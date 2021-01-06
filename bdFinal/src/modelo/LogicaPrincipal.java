package modelo;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
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
		Vector<String> columnas = new Vector<String>();
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
		Vector<String> columnas = new Vector<String>();
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
		Vector<String> columnas = new Vector<String>();
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
	
	public static void crearGrafico(ArrayList<String> nP, ArrayList<Integer> cP, JPanel panelGr�fico ) {
		//XYSeries oSeries = new XYSeries("");
	   	
   		
   	
   		//XYSeriesCollection oDataset = new XYSeriesCollection();
   		
   		//oDataset.addSeries(oSeries);
   		
   		
   		JFreeChart oChart = ChartFactory.createBarChart("Ventas diarias", "Productos", "Cantidad de productos", crearDataSet(nP, cP), PlotOrientation.VERTICAL, true, true, false);
   		oChart.setBackgroundPaint(new Color(101, 118, 140));
   		ChartPanel oPanel = new ChartPanel(oChart);
   		
   		panelGr�fico.setLayout(new java.awt.BorderLayout());
   		panelGr�fico.add(oPanel);
   		panelGr�fico.validate();
	}
	private static CategoryDataset crearDataSet(ArrayList<String> nombreProductos, ArrayList<Integer> cantidadProductos) {
		final DefaultCategoryDataset dataset = 
			      new DefaultCategoryDataset( ); 
		
		for(int i = 0; i < nombreProductos.size()-1;i++) {
   			dataset.addValue(cantidadProductos.get(i), cantidadProductos.get(i),nombreProductos.get(i));
   		}
		return dataset;
	}
	
}

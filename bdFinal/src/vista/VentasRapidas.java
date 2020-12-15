package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentasRapidas extends JDialog {
	public JTable tabla;
	private Coordinador miCoordinador;
	private JTextField textFieldNumero;
	private JTextField textFieldFecha;
	private JTextField textFieldVendedor;
	private JTextField textFieldNombre;
	private JTextField textFieldRUT;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentasRapidas dialog = new VentasRapidas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentasRapidas() {
		initComponents();
	}
	public void initComponents() {
		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 965, 30);
		getContentPane().add(barra);
		setUndecorated(true);
		barra.setBackground(new Color(101, 118, 140));
		setBounds(100, 100, 965, 577);
		setLocationRelativeTo(null);
		JLabel btnCerrar = new JLabel("");
		btnCerrar.setBounds(935, 0, 30, 30);
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorBlanco_30px.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorPrincipal_30px.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		barra.setLayout(null);
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorPrincipal_30px.png")));
		barra.add(btnCerrar);
		
		JPanel barraVentasRapidas = new JPanel();
		barraVentasRapidas.setBounds(0, 30, 697, 36);
		getContentPane().add(barraVentasRapidas);
		
		JLabel lblVentasRapidas = new JLabel("VENTAS R\u00C1PIDAS");
		lblVentasRapidas.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		barraVentasRapidas.add(lblVentasRapidas);
		
		JButton btnGuardarVenta = new JButton("Guardar");
		btnGuardarVenta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGuardarVenta.setBounds(707, 30, 89, 36);
		getContentPane().add(btnGuardarVenta);
		
		JButton btnCerrar_1 = new JButton("Cerrar");
		btnCerrar_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCerrar_1.setBounds(806, 30, 89, 36);
		getContentPane().add(btnCerrar_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 92, 148, 22);
		getContentPane().add(comboBox);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSucursal.setBounds(10, 96, 80, 14);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox_1.setBounds(100, 125, 148, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDocumento.setBounds(10, 129, 80, 14);
		getContentPane().add(lblDocumento);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNumero.setBounds(10, 161, 80, 14);
		getContentPane().add(lblNumero);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFecha.setBounds(10, 194, 80, 14);
		getContentPane().add(lblFecha);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(100, 158, 148, 22);
		getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(100, 191, 148, 22);
		getContentPane().add(textFieldFecha);
		
		JPanel panelDetalleVenta = new JPanel();
		panelDetalleVenta.setBounds(0, 224, 965, 36);
		getContentPane().add(panelDetalleVenta);
		panelDetalleVenta.setLayout(null);
		
		JLabel lblDetalleVenta = new JLabel("DETALLE DE LA VENTA");
		lblDetalleVenta.setBounds(125, 0, 194, 34);
		lblDetalleVenta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panelDetalleVenta.add(lblDetalleVenta);
		
		JLabel lblRUT = new JLabel("RUT");
		lblRUT.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRUT.setBounds(301, 96, 80, 14);
		getContentPane().add(lblRUT);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNombre.setBounds(301, 130, 80, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblVendedor.setBounds(301, 162, 80, 14);
		getContentPane().add(lblVendedor);
		
		textFieldVendedor = new JTextField();
		textFieldVendedor.setColumns(10);
		textFieldVendedor.setBounds(391, 159, 148, 22);
		getContentPane().add(textFieldVendedor);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(391, 127, 148, 22);
		getContentPane().add(textFieldNombre);
		
		textFieldRUT = new JTextField();
		textFieldRUT.setColumns(10);
		textFieldRUT.setBounds(391, 93, 148, 22);
		getContentPane().add(textFieldRUT);
		
		JLabel lblCondicion = new JLabel("Condicion");
		lblCondicion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCondicion.setBounds(301, 195, 80, 14);
		getContentPane().add(lblCondicion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 945, 190);
		getContentPane().add(scrollPane);
		
		Vector columnas = new Vector();
		columnas.add("Código");
		columnas.add("Producto");
		columnas.add("Stock");
		columnas.add("Cantidad");
		columnas.add("Precio Venta");
		
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

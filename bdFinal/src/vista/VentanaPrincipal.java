package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame {
	public JTable tabla;
	private Coordinador miCoordinador;
	private JTextField textFieldNumero;
	private JTextField textFieldFecha;
	private JTextField textFieldVendedor;
	private JTextField textFieldNombre;
	private JTextField textFieldRUT;
	private JTable table;
	
	
	JMenuBar barraMenu;
	JMenu menuProducto;
	JMenu menuProveedores;
	JMenu menuTrabajadores;
	JMenu menuVentas;
	JMenuItem itemDisponibilidad;
	JMenuItem itemVentasRapidas;
	JMenuItem itemIngresarTrabajador;
	JMenuItem itemEliminarTrabajador;
	JMenuItem itemActualizarTrabajador;
	JMenuItem itemIngresarSucursal;
	JMenuItem itemEliminarSucursal;
	JMenuItem itemActualizarSucursal;
	JMenuItem itemDeudores;
	JMenuItem itemEliminarEmpresa;
	JMenuItem itemActualizarEmpresa;
	JMenuItem itemGestionarTrabajador;
	JMenuItem itemGestionarProductos;
	JMenuItem itemGestionarEmpresa;
	JMenu menuSucursal;
	JMenu menuProveedor;
	JMenu menuEmpresas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPrincipal dialog = new VentanaPrincipal();
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPrincipal() {
		initComponents();
	}
	public void initComponents() {
		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setLayout(null);
		crearMenu();
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
		barraVentasRapidas.setBounds(0, 52, 965, 36);
		getContentPane().add(barraVentasRapidas);
		
		JLabel lblVentasRapidas = new JLabel("VENTAS R\u00C1PIDAS");
		lblVentasRapidas.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		barraVentasRapidas.add(lblVentasRapidas);
		
		JButton btnGuardarVenta = new JButton("Guardar");
		btnGuardarVenta.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGuardarVenta.setBounds(84, 202, 89, 36);
		getContentPane().add(btnGuardarVenta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 99, 148, 22);
		getContentPane().add(comboBox);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblSucursal.setBounds(10, 102, 44, 15);
		getContentPane().add(lblSucursal);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		comboBox_1.setBounds(84, 128, 148, 22);
		getContentPane().add(comboBox_1);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDocumento.setBounds(10, 132, 80, 14);
		getContentPane().add(lblDocumento);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblNumero.setBounds(596, 131, 80, 14);
		getContentPane().add(lblNumero);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFecha.setBounds(295, 164, 80, 14);
		getContentPane().add(lblFecha);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(670, 128, 164, 22);
		getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(385, 161, 148, 22);
		getContentPane().add(textFieldFecha);
		
		JPanel panelDetalleVenta = new JPanel();
		panelDetalleVenta.setBounds(0, 313, 965, 36);
		getContentPane().add(panelDetalleVenta);
		panelDetalleVenta.setLayout(null);
		
		JLabel lblDetalleVenta = new JLabel("DETALLE DE LA VENTA");
		lblDetalleVenta.setBounds(125, 0, 194, 34);
		lblDetalleVenta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panelDetalleVenta.add(lblDetalleVenta);
		
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miCoordinador.AbrirVentanaListaProductos();
			}
		});
		lblBuscar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/icons8_search_30px_1.png")));
		lblBuscar.setBounds(661, 0, 30, 34);
		panelDetalleVenta.add(lblBuscar);
		
		JButton btnGráfico = new JButton("Ver");
		btnGráfico.setBackground(new Color(191, 205, 217));
		btnGráfico.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnGráfico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.mostrarGráfico();
			}
		});
		btnGráfico.setBounds(866, 1, 89, 33);
		panelDetalleVenta.add(btnGráfico);
		
		JLabel lblVentasDiarias = new JLabel("Ventas diarias:");
		lblVentasDiarias.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblVentasDiarias.setBounds(754, 2, 102, 34);
		panelDetalleVenta.add(lblVentasDiarias);
		
		JLabel lblBuscarProducto = new JLabel("Buscar producto: ");
		lblBuscarProducto.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblBuscarProducto.setBounds(534, 2, 130, 34);
		panelDetalleVenta.add(lblBuscarProducto);
		
		JLabel lblRUT = new JLabel("RUT");
		lblRUT.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRUT.setBounds(295, 102, 20, 15);
		getContentPane().add(lblRUT);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCliente.setBounds(10, 164, 65, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblVendedor.setBounds(596, 99, 54, 19);
		getContentPane().add(lblVendedor);
		
		textFieldVendedor = new JTextField();
		textFieldVendedor.setColumns(10);
		textFieldVendedor.setBounds(670, 99, 164, 22);
		getContentPane().add(textFieldVendedor);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(84, 161, 148, 22);
		getContentPane().add(textFieldNombre);
		
		textFieldRUT = new JTextField();
		textFieldRUT.setColumns(10);
		textFieldRUT.setBounds(385, 99, 148, 22);
		getContentPane().add(textFieldRUT);
		
		JLabel lblTipoPago = new JLabel("Tipo de Pago");
		lblTipoPago.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblTipoPago.setBounds(295, 131, 80, 14);
		getContentPane().add(lblTipoPago);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 360, 945, 206);
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
		
		JComboBox cmbTipoPago = new JComboBox();
		cmbTipoPago.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		cmbTipoPago.setBounds(385, 128, 148, 22);
		getContentPane().add(cmbTipoPago);
		
		
		
		
	}
	
	public void crearMenu() {
		barraMenu = new JMenuBar();
		barraMenu.setBorder(null);
		barraMenu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		barraMenu.setBounds(0, 30, 965, 22);
		getContentPane().add(barraMenu);
		//PRODUCTOS
		menuProducto = agregarMenu(menuProducto, "Productos");
		//TRABAJADOR
		menuTrabajadores = agregarMenu(menuTrabajadores, "Trabajadores");
		//SUCURSAL
		
		//PROVEEDORES
		menuProveedor = agregarMenu(menuProveedor, "Proveedores");
		//EMPRESAS
		menuEmpresas = agregarMenu(menuEmpresas, "Empresas");
	
		//ITEMS TRABAJADOR
		itemIngresarTrabajador = agregarItem(itemIngresarTrabajador,"Ingresar Trabajador");
		itemActualizarTrabajador = agregarItem(itemActualizarTrabajador,"Actualizar Datos");
		itemEliminarTrabajador = agregarItem(itemEliminarTrabajador,"Eliminar Trabajador");
		itemGestionarTrabajador = agregarItem(itemGestionarTrabajador,"Gestionar");
		//ITEMS PRODUCTOS
		
		itemGestionarProductos = agregarItem(itemGestionarProductos, "Gestionar");
		//ITEMS SUCURSAL
		
		//ITEMS EMPRESAS
		itemDeudores = agregarItem(itemDeudores,"Deudores");
		
		
		itemGestionarEmpresa = agregarItem(itemGestionarEmpresa,"Gestionar");
	
		
		
		
		menuTrabajadores.add(itemGestionarTrabajador);
		
		menuEmpresas.add(itemDeudores);
		
		menuEmpresas.add(itemGestionarEmpresa);
		menuProducto.add(itemGestionarProductos);
		barraMenu.add(menuProducto);
		barraMenu.add(menuTrabajadores);
		barraMenu.add(menuProveedor);
		
		barraMenu.add(menuEmpresas);
		
		
	
		
		
		itemGestionarTrabajador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaGestionarTrabajador();
			}
		});
		
		itemGestionarProductos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaGestionarProducto();
			}
		});
		itemGestionarEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaGestionarEmpresa();
			}
		});
		
		itemDeudores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaDeudores();
			}
		});
	}

	
	private JMenu agregarMenu(JMenu menu, String titulo) {
		menu = new JMenu(titulo);
		menu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		menu.setBorder(null);
		return menu;
		
	}

	private JMenuItem agregarItem(JMenuItem item, String titulo) {
		item = new JMenuItem(titulo);
		item.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		return item;
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

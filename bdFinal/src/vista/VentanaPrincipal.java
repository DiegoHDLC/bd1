package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {
	private Coordinador miCoordinador;
	public JTable tabla;
	private JTextField txtFieldProducto;
	
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
	JMenuItem itemIngresarEmpresa;
	JMenuItem itemEliminarEmpresa;
	JMenuItem itemActualizarEmpresa;
	JMenu menuSucursal;
	JMenu menuProveedor;
	JMenu menuEmpresas;
	
	//private JTable tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPrincipal dialog = new VentanaPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPrincipal() {
		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 11));
		initComponents();
	}
	
	public void initComponents() {
		
		setUndecorated(true);
		setBounds(100, 100, 710, 453);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		crearMenu();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 182, 483, 260);
		getContentPane().add(scrollPane);
		
		txtFieldProducto = new JTextField();
		txtFieldProducto.setBounds(375, 95, 146, 20);
		getContentPane().add(txtFieldProducto);
		txtFieldProducto.setColumns(10);
		
		JButton btnDisponibilidad = new JButton("Disponibilidad");
		btnDisponibilidad.setBounds(238, 94, 114, 23);
		btnDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String producto;
				tabla = miCoordinador.crearTablaDisponibilidadProducto(scrollPane,tabla);
				
				producto = txtFieldProducto.getText();
				miCoordinador.disponibilidadProductoYValor(tabla, producto);
			}
		});
		getContentPane().add(btnDisponibilidad);
	
		
		
		
		//miCoordinador.abrirTabla(scrollPane);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 710, 30);
		getContentPane().add(barra);
		barra.setBackground(new Color(101, 118, 140));
		
		
		
		JLabel btnCerrar = new JLabel("");
		btnCerrar.setBounds(680, 0, 30, 30);
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
		
		
		
		@SuppressWarnings("rawtypes")
		Vector columnas = new Vector();
		columnas.add("Sucursal");
		columnas.add("RUT");
		columnas.add("Teléfono");
		columnas.add("Correo");
		
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		
		JButton consulta = new JButton("consulta");
		consulta.setBounds(103, 94, 107, 23);
		getContentPane().add(consulta);
		consulta.setActionCommand("AGREGAR-JTABLE");
		
		
		
		
		
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equalsIgnoreCase("AGREGAR-JTABLE")) {
					miCoordinador.mostrarTablaTrabajador(tabla);	
				}	
			}
		});
		
	
		
		
		
	
		
		
	}

	private void crearTabla(JScrollPane scrollPane) {
		
		
	}
	
	public void crearMenu() {
		barraMenu = new JMenuBar();
		barraMenu.setBorder(null);
		barraMenu.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		barraMenu.setBounds(0, 30, 710, 22);
		getContentPane().add(barraMenu);
		//PRODUCTOS
		menuProducto = agregarMenu(menuProducto, "Productos");
		//TRABAJADOR
		menuTrabajadores = agregarMenu(menuTrabajadores, "Trabajadores");
		//SUCURSAL
		menuSucursal = agregarMenu(menuSucursal, "Sucursal");
		//PROVEEDORES
		menuProveedor = agregarMenu(menuProveedor, "Proveedores");
		//EMPRESAS
		menuEmpresas = agregarMenu(menuEmpresas, "Empresas");
		//VENTAS
		menuVentas = agregarMenu(menuVentas, "Ventas");
		//ITEMS TRABAJADOR
		itemIngresarTrabajador = agregarItem(itemIngresarTrabajador,"Ingresar Trabajador");
		itemActualizarTrabajador = agregarItem(itemActualizarTrabajador,"Actualizar Datos");
		itemEliminarTrabajador = agregarItem(itemEliminarTrabajador,"Eliminar Trabajador");
		//ITEMS PRODUCTOS
		itemDisponibilidad = agregarItem(itemDisponibilidad,"Disponibilidad");
		//ITEMS SUCURSAL
		itemIngresarSucursal = agregarItem(itemIngresarSucursal,"Ingresar Sucursal");
		itemActualizarSucursal = agregarItem(itemActualizarSucursal,"Actualizar Sucursal");
		itemEliminarSucursal = agregarItem(itemEliminarSucursal,"Eliminar Sucursal");
		//ITEMS EMPRESAS
		itemIngresarEmpresa = agregarItem(itemIngresarEmpresa,"Ingresar Empresa");
		itemActualizarEmpresa = agregarItem(itemActualizarEmpresa,"Actualizar Empresa");
		itemEliminarEmpresa = agregarItem(itemEliminarEmpresa,"Eliminar Empresa");
		//ITEMS VENTAS
		itemVentasRapidas = agregarItem(itemVentasRapidas,"Ventas Rápidas");
		
		menuProducto.add(itemDisponibilidad);
		menuTrabajadores.add(itemIngresarTrabajador);
		menuTrabajadores.add(itemActualizarTrabajador);
		menuTrabajadores.add(itemEliminarTrabajador);
		menuSucursal.add(itemIngresarSucursal);
		menuSucursal.add(itemActualizarSucursal);
		menuSucursal.add(itemEliminarSucursal);
		menuEmpresas.add(itemIngresarEmpresa);
		menuEmpresas.add(itemActualizarEmpresa);
		menuEmpresas.add(itemEliminarEmpresa);
		menuVentas.add(itemVentasRapidas);
		barraMenu.add(menuProducto);
		barraMenu.add(menuTrabajadores);
		barraMenu.add(menuProveedor);
		barraMenu.add(menuSucursal);
		barraMenu.add(menuEmpresas);
		barraMenu.add(menuVentas);
		
		
		itemDisponibilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaDispProduct();
			}
		});
		
		itemVentasRapidas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaVentasRapidas();
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

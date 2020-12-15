package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;

import java.awt.Color;
import javax.swing.JLabel;
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

public class VentanaPrincipal extends JDialog {
	private Coordinador miCoordinador;
	public JTable tabla;
	private JTextField txtFieldProducto;
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
		initComponents();
	}
	
	public void initComponents() {
		
		setUndecorated(true);
		setBounds(100, 100, 710, 453);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 182, 483, 260);
		getContentPane().add(scrollPane);
		
		txtFieldProducto = new JTextField();
		txtFieldProducto.setBounds(375, 95, 146, 20);
		getContentPane().add(txtFieldProducto);
		txtFieldProducto.setColumns(10);
		
		JButton btnDisponibilidad = new JButton("Disponibilidad");
		btnDisponibilidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String producto;
				tabla = miCoordinador.crearTablaDisponibilidadProducto(scrollPane,tabla);
				
				producto = txtFieldProducto.getText();
				miCoordinador.disponibilidadProductoYValor(tabla, producto);
			}
		});
		btnDisponibilidad.setBounds(238, 94, 114, 23);
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
		
		
		
		Vector columnas = new Vector();
		columnas.add("Sucursal");
		columnas.add("RUT");
		columnas.add("Teléfono");
		columnas.add("Correo");
		
		
		Vector filas = new Vector();
		Vector fila = new Vector();

		//filas.add(fila);
		tabla = new JTable(filas,columnas);
		scrollPane.setViewportView(tabla);
		//tabla = miCoordinador.definirColumnas();
		/*tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Sucursal", "RUT", "Teléfono", "Correo"
				}
			));
		*/
		
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

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
}

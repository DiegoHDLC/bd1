package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;

public class VentanaListaProductos extends JDialog {

	Coordinador miCoordinador;
	private JTable tabla;
	private JTextField textfContador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaListaProductos dialog = new VentanaListaProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaListaProductos() {
		initComponents();
	}
	
	public void initComponents() {
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 768, 436);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(101, 118, 140));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.getSelectedRow();
				System.out.println("fila: "+fila);
			}
		});
		scrollPane.setBounds(10, 151, 748, 274);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();

		 
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tabla);
		
		JLabel lblAgregar = new JLabel("");
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int stockAux = 
				//int stockOriginal = 
				int fila = tabla.getSelectedRow();
				int columna = 3;
				
				int contador = Integer.parseInt(textfContador.getText());
				
				
			}
		});
		lblAgregar.setIcon(new ImageIcon(VentanaListaProductos.class.getResource("/imagenes/icons8_add_new_50px_1.png")));
		lblAgregar.setBounds(10, 25, 50, 50);
		getContentPane().add(lblAgregar);
		
		JLabel lblAgregar_1 = new JLabel("");
		lblAgregar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblAgregar_1.setIcon(new ImageIcon(VentanaListaProductos.class.getResource("/imagenes/icons8_reduce_50px_1.png")));
		lblAgregar_1.setBounds(62, 25, 50, 50);
		getContentPane().add(lblAgregar_1);
		
		textfContador = new JTextField();
		textfContador.setHorizontalAlignment(SwingConstants.CENTER);
		textfContador.setText("0");
		textfContador.setEditable(false);
		textfContador.setFont(new Font("Century Gothic", Font.PLAIN, 41));
		textfContador.setBounds(122, 25, 86, 50);
		getContentPane().add(textfContador);
		textfContador.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAgregar.setBounds(225, 25, 137, 50);
		getContentPane().add(btnAgregar);
		
		
		
		
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnCancelar.setBounds(621, 25, 137, 50);
		getContentPane().add(btnCancelar);
		
		JButton btnMostrarLista = new JButton("MOSTRAR LISTA");
		btnMostrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabla = miCoordinador.mostrarTablaProductos(scrollPane, tabla);
				miCoordinador.mostrarTablaProductos(tabla);
				
			}
		});
		btnMostrarLista.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnMostrarLista.setBounds(10, 86, 352, 50);
		getContentPane().add(btnMostrarLista);
	
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
}

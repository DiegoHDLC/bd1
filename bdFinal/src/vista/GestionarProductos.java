package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class GestionarProductos extends JDialog {
	private Coordinador miCoordinador;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionarProductos dialog = new GestionarProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionarProductos() {
		initComponents();
	}
	public void initComponents() {
		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 519, 30);
		getContentPane().add(barra);
		setUndecorated(true);
		barra.setBackground(new Color(101, 118, 140));
		setBounds(100, 100, 519, 396);
		setLocationRelativeTo(null);
		JLabel btnCerrar = new JLabel("");
		btnCerrar.setBounds(489, 0, 30, 30);
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
		
		JLabel lblCódigo = new JLabel("C\u00F3digo");
		lblCódigo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCódigo.setBounds(47, 57, 81, 14);
		getContentPane().add(lblCódigo);
		
		JLabel lblCdBarra = new JLabel("C\u00F3d. Barra");
		lblCdBarra.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCdBarra.setBounds(47, 89, 81, 14);
		getContentPane().add(lblCdBarra);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblDescripcin.setBounds(47, 120, 81, 14);
		getContentPane().add(lblDescripcin);
		
		JLabel lblFamilia = new JLabel("Familia");
		lblFamilia.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFamilia.setBounds(47, 151, 81, 14);
		getContentPane().add(lblFamilia);
		
		JLabel lblPrecioActual = new JLabel("Precio Actual");
		lblPrecioActual.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblPrecioActual.setBounds(47, 182, 81, 14);
		getContentPane().add(lblPrecioActual);
		
		textField = new JTextField();
		textField.setBounds(154, 55, 163, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 87, 163, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(154, 118, 163, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(154, 149, 163, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(154, 180, 163, 20);
		getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(47, 220, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(154, 220, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(304, 220, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(420, 54, 89, 23);
		getContentPane().add(btnBuscar);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblStock.setBounds(353, 89, 81, 14);
		getContentPane().add(lblStock);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(420, 87, 89, 20);
		getContentPane().add(textField_5);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(420, 220, 89, 23);
		getContentPane().add(btnNewButton_2_1);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

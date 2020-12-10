package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Coordinador miCoordinador;
	private JTextField usuarioTxtField;
	private JPasswordField contraseñaPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setUndecorated(true);
		initComponents();
	}
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelGeneralLogin = new JPanel();
		panelGeneralLogin.setBounds(0, 0, 450, 341);
		contentPane.add(panelGeneralLogin);
		panelGeneralLogin.setLayout(null);
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(new Color(101, 118, 140));
		panelNombre.setBounds(0, 0, 226, 341);
		panelGeneralLogin.add(panelNombre);
		SpringLayout sl_panelNombre = new SpringLayout();
		panelNombre.setLayout(sl_panelNombre);
		
		JLabel nombre = new JLabel("");
		sl_panelNombre.putConstraint(SpringLayout.NORTH, nombre, 23, SpringLayout.NORTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.WEST, nombre, 28, SpringLayout.WEST, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.EAST, nombre, -36, SpringLayout.EAST, panelNombre);
		nombre.setHorizontalTextPosition(SwingConstants.CENTER);
		nombre.setText("<html>Nombre <p>del<p> Proyecto<html>");
		nombre.setForeground(new Color(255, 255, 224));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		panelNombre.add(nombre);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panelNombre.putConstraint(SpringLayout.SOUTH, nombre, -6, SpringLayout.NORTH, lblNewLabel);
		sl_panelNombre.putConstraint(SpringLayout.SOUTH, lblNewLabel, -74, SpringLayout.SOUTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.NORTH, lblNewLabel, 151, SpringLayout.NORTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.WEST, lblNewLabel, 50, SpringLayout.WEST, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.EAST, lblNewLabel, 168, SpringLayout.WEST, panelNombre);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logoPrincipal_125px.png")));
		panelNombre.add(lblNewLabel);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(191, 205, 217));
		panelLogin.setBounds(224, 0, 226, 341);
		panelGeneralLogin.add(panelLogin);
		panelLogin.setLayout(null);
		
		usuarioTxtField = new JTextField();
		usuarioTxtField.setBounds(57, 53, 159, 42);
		usuarioTxtField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		usuarioTxtField.setBackground(new Color(159, 173, 191));
		panelLogin.add(usuarioTxtField);
		usuarioTxtField.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(113, 234, 75, 23);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIngresar.setBackground(new Color(101, 118, 140));
		panelLogin.add(btnIngresar);
		
		contraseñaPassField = new JPasswordField();
		contraseñaPassField.setBounds(57, 148, 159, 42);
		contraseñaPassField.setBackground(new Color(159, 173, 191));
		contraseñaPassField.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		panelLogin.add(contraseñaPassField);
		
		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setBounds(16, 53, 40, 40);
		iconoUsuario.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconoUsuario_40px_2.png")));
		panelLogin.add(iconoUsuario);
		
		JLabel iconoUsuario_1 = new JLabel("");
		iconoUsuario_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconoContrase\u00F1a.png")));
		iconoUsuario_1.setBounds(16, 148, 40, 40);
		panelLogin.add(iconoUsuario_1);
		
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

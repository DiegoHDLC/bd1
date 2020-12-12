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
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Coordinador miCoordinador;
	private JTextField usuarioTxtField;
	private JPasswordField contraseñaPassField;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setUndecorated(true);
		initComponents();
	}
	
	public JFrame getFrame() {
		return this;
	}
	public void initComponents() {
		addMouseMotionListener((MouseMotionListener) new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				setLocation(x-xx, y-xy);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//miCoordinador.movimientoVentana(getFrame());
		JPanel panelGeneralLogin = new JPanel();
		panelGeneralLogin.setBounds(0, 0, 450, 330);
		setLocationRelativeTo(null);
		contentPane.add(panelGeneralLogin);
		panelGeneralLogin.setLayout(null);
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(new Color(101, 118, 140));
		panelNombre.setBounds(0, 0, 226, 308);
		panelGeneralLogin.add(panelNombre);
		SpringLayout sl_panelNombre = new SpringLayout();
		panelNombre.setLayout(sl_panelNombre);
		
		JLabel nombre = new JLabel("");
		sl_panelNombre.putConstraint(SpringLayout.NORTH, nombre, 34, SpringLayout.NORTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.WEST, nombre, 29, SpringLayout.WEST, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.SOUTH, nombre, -152, SpringLayout.SOUTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.EAST, nombre, -35, SpringLayout.EAST, panelNombre);
		nombre.setHorizontalTextPosition(SwingConstants.CENTER);
		nombre.setText("<html>Nombre <p>del<p> Proyecto<html>");
		nombre.setForeground(new Color(255, 255, 224));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setFont(new Font("Century Gothic", Font.PLAIN, 33));
		panelNombre.add(nombre);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panelNombre.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, nombre);
		sl_panelNombre.putConstraint(SpringLayout.WEST, lblNewLabel, 51, SpringLayout.WEST, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.SOUTH, lblNewLabel, -33, SpringLayout.SOUTH, panelNombre);
		sl_panelNombre.putConstraint(SpringLayout.EAST, lblNewLabel, 169, SpringLayout.WEST, panelNombre);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/logoPrincipal_125px.png")));
		panelNombre.add(lblNewLabel);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(191, 205, 217));
		panelLogin.setBounds(224, 0, 226, 308);
		panelGeneralLogin.add(panelLogin);
		panelLogin.setLayout(null);
		
		usuarioTxtField = new JTextField();
		usuarioTxtField.setBounds(51, 75, 159, 42);
		usuarioTxtField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		usuarioTxtField.setBackground(new Color(159, 173, 191));
		panelLogin.add(usuarioTxtField);
		usuarioTxtField.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.abrirVentanaPrincipal();
			}
		});
		btnIngresar.setBounds(117, 235, 93, 34);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnIngresar.setBackground(new Color(101, 118, 140));
		panelLogin.add(btnIngresar);
		
		contraseñaPassField = new JPasswordField();
		contraseñaPassField.setBounds(51, 170, 159, 42);
		contraseñaPassField.setBackground(new Color(159, 173, 191));
		contraseñaPassField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		panelLogin.add(contraseñaPassField);
		
		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setBounds(10, 75, 40, 40);
		iconoUsuario.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/iconoUsuario_40px_2.png")));
		panelLogin.add(iconoUsuario);
		
		JLabel iconoUsuario_1 = new JLabel("");
		iconoUsuario_1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/iconoContrase\u00F1a.png")));
		iconoUsuario_1.setBounds(10, 170, 40, 40);
		panelLogin.add(iconoUsuario_1);
		
		JLabel usuarioLbl = new JLabel("Usuario");
		usuarioLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		usuarioLbl.setBounds(10, 43, 56, 21);
		panelLogin.add(usuarioLbl);
		
		JLabel contraseñaLbl = new JLabel("Contrase\u00F1a");
		contraseñaLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		contraseñaLbl.setBounds(10, 138, 93, 21);
		panelLogin.add(contraseñaLbl);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
			}
		});
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCerrar.setBackground(new Color(101, 118, 140));
		btnCerrar.setBounds(10, 235, 93, 34);
		panelLogin.add(btnCerrar);
		
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

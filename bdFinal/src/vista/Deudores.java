package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.MongoException;

import controlador.Coordinador;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Deudores extends JDialog {
	private Coordinador miCoordinador;
	private JTable tabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Deudores dialog = new Deudores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Deudores() {
		initComponents();
	}
	public void initComponents() {
		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 710, 30);
		getContentPane().add(barra);
		setUndecorated(true);
		barra.setBackground(new Color(101, 118, 140));
		setBounds(100, 100, 710, 453);
		setLocationRelativeTo(null);
		JLabel btnCerrar = new JLabel("");
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
		SpringLayout sl_barra = new SpringLayout();
		sl_barra.putConstraint(SpringLayout.NORTH, btnCerrar, 0, SpringLayout.NORTH, barra);
		sl_barra.putConstraint(SpringLayout.EAST, btnCerrar, 0, SpringLayout.EAST, barra);
		barra.setLayout(sl_barra);
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorPrincipal_30px.png")));
		barra.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 690, 338);
		getContentPane().add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 29, 710, 30);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDeudores = new JLabel("DEUDORES");
		lblDeudores.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeudores.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDeudores.setBounds(10, 0, 690, 31);
		panel.add(lblDeudores);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabla = miCoordinador.crearTablaDeudores(scrollPane,tabla);
				try {
					miCoordinador.buscarDeudores(tabla);
				} catch (UnknownHostException | MongoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnBuscar.setBounds(10, 70, 89, 23);
		getContentPane().add(btnBuscar);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

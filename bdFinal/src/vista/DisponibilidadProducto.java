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
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class DisponibilidadProducto extends JDialog {
	private Coordinador miCoordinador;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DisponibilidadProducto dialog = new DisponibilidadProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DisponibilidadProducto() {
		initComponents();
	}
	public void initComponents() {
		getContentPane().setBackground(new Color(191, 205, 217));
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel barra = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, barra, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, barra, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, barra, 30, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, barra, 519, SpringLayout.WEST, getContentPane());
		getContentPane().add(barra);
		setUndecorated(true);
		barra.setBackground(new Color(101, 118, 140));
		setBounds(100, 100, 519, 396);
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
		sl_barra.putConstraint(SpringLayout.WEST, btnCerrar, 489, SpringLayout.WEST, barra);
		barra.setLayout(sl_barra);
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorPrincipal_30px.png")));
		barra.add(btnCerrar);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 135, SpringLayout.SOUTH, barra);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -49, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 225, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 127, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -148, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -210, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, -50, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, textField, 144, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -27, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnNewButton);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 109, SpringLayout.SOUTH, barra);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 30, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -243, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 102, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

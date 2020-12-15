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

public class VentasRapidas extends JDialog {
	private Coordinador miCoordinador;

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
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

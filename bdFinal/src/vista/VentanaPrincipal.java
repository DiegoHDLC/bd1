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

public class VentanaPrincipal extends JDialog {
	private Coordinador miCoordinador;
	private static JTable table;
	private JTable table2;
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
		setBounds(100, 100, 710, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 205, 217));
		panel.setBounds(0, 0, 710, 500);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		
		
		//miCoordinador.abrirTabla(scrollPane);
		
		JPanel barra = new JPanel();
		barra.setBackground(new Color(101, 118, 140));
		barra.setBounds(0, 0, 710, 30);
		panel.add(barra);
		barra.setLayout(null);
		
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
		btnCerrar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/cerrarColorPrincipal_30px.png")));
		btnCerrar.setBounds(680, 0, 30, 30);
		barra.add(btnCerrar);
		
		JButton consulta = new JButton("New button");
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					miCoordinador.mostrarTablaTrabajador();
					
					String [] cabezera = {"Nombre","Pais"};				
					String [][] datos = {	
							{"Diego","Chile"},
							
					};

					DefaultTableModel mod = new DefaultTableModel(datos,cabezera);
					
					JTable tabla = new JTable(mod);
					JScrollPane scroll = new JScrollPane(tabla);
					scroll.setBounds(40,40,400,200);
					panel.add(tabla);
					
					
					
							
			}	
					
			
		});
		consulta.setBounds(142, 157, 89, 23);
		panel.add(consulta);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 287, 690, 202);
		panel.add(panelTabla);
		panelTabla.setLayout(null);
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 17, 48);
		panelTabla.add(scrollBar);
		
		JTable tabla = new JTable();
		tabla.setBounds(6, 275, 471, -269);
		
		
		
		
	}

	private void crearTabla(JScrollPane scrollPane) {
		
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
}

package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarProductos extends JDialog {
	private Coordinador miCoordinador;
	private JTextField textCódigo;
	private JTextField textCódBarra;
	private JTextField textDecripción;
	private JTextField textFamilia;
	private JTextField textPrecioActual;
	private JTextField textStock;
	int xx,xy;

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

		getContentPane().setBackground(new Color(191, 205, 217));
		getContentPane().setLayout(null);
		
		JPanel barra = new JPanel();
		barra.setBounds(0, 0, 519, 30);
		getContentPane().add(barra);
		setUndecorated(true);
		barra.setBackground(new Color(101, 118, 140));
		setBounds(100, 100, 519, 272);
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
		
		textCódigo = new JTextField();
		textCódigo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textCódigo.setBounds(154, 55, 163, 20);
		getContentPane().add(textCódigo);
		textCódigo.setColumns(10);
		
		textCódBarra = new JTextField();
		textCódBarra.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textCódBarra.setColumns(10);
		textCódBarra.setBounds(154, 87, 163, 20);
		getContentPane().add(textCódBarra);
		
		textDecripción = new JTextField();
		textDecripción.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textDecripción.setColumns(10);
		textDecripción.setBounds(154, 118, 323, 20);
		getContentPane().add(textDecripción);
		
		textFamilia = new JTextField();
		textFamilia.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textFamilia.setColumns(10);
		textFamilia.setBounds(154, 149, 323, 20);
		getContentPane().add(textFamilia);
		
		textPrecioActual = new JTextField();
		textPrecioActual.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textPrecioActual.setColumns(10);
		textPrecioActual.setBounds(154, 180, 323, 20);
		getContentPane().add(textPrecioActual);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.agregarProducto(textCódigo, textCódBarra, textDecripción, textFamilia, textPrecioActual, textStock);
			}
		});
		btnAgregar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAgregar.setBounds(23, 220, 100, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnModificar.setBounds(146, 220, 100, 23);
		getContentPane().add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnGuardar.setBounds(269, 220, 100, 23);
		getContentPane().add(btnGuardar);
		
		
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblStock.setBounds(327, 89, 81, 14);
		getContentPane().add(lblStock);
		
		textStock = new JTextField();
		textStock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		textStock.setColumns(10);
		textStock.setBounds(373, 87, 104, 20);
		getContentPane().add(textStock);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBorrar.setBounds(392, 220, 104, 23);
		getContentPane().add(btnBorrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String código = textCódigo.getText();

				miCoordinador.buscarProducto(código, textCódigo, textCódBarra, textDecripción, textFamilia, textPrecioActual, textStock);
			}
		});
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBuscar.setBounds(373, 54, 104, 23);
		getContentPane().add(btnBuscar);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
}

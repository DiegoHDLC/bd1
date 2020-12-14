package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Prueba extends JFrame implements ActionListener {

public Prueba() {
// TODO Auto-generated constructor stub

JButton button = new JButton("Agregar JTable");
button.addActionListener(this);
button.setActionCommand("AGREGAR-JTABLE");

JPanel panel = new JPanel(new FlowLayout());
panel.add(button);

getContentPane().setLayout(new BorderLayout());
getContentPane().add(panel, BorderLayout.SOUTH);

setSize(800, 600);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setTitle("Colocar dinamicamente un JTable dentro de un JPanel");
setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
if(e.getActionCommand().equalsIgnoreCase("AGREGAR-JTABLE")) {
Vector columnas = new Vector();
columnas.add("Local");
columnas.add("");
columnas.add("");
columnas.add("Visita");
columnas.add("completar");

Vector filas = new Vector();
Vector fila = new Vector();

fila.add("X");
fila.add("Y");
fila.add("Z");
filas.add(fila);

JTable tbl = new JTable(filas,columnas);
JScrollPane scroll =new JScrollPane(tbl);
getContentPane().add(scroll, BorderLayout.CENTER);
getContentPane().invalidate();
getContentPane().validate();
}
}

public static void main(String[] args) {
// TODO Auto-generated method stub
new Prueba();
}

}

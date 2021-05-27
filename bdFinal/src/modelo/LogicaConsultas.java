package modelo;

import java.awt.Cursor;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JTable;
import javax.swing.JTextField;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.*;
import controlador.Coordinador;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Accumulators.push;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class LogicaConsultas {
	private Coordinador miCoordinador;
	ArrayList<Object> lista;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}

	public void mostrarTablaTrabajador(MongoDatabase cn, JTable tabla) {
		
		/*
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Trabajador;" );
			while (rs.next()) {
			       String rut = rs.getString(1);
			       String nombre = rs.getString(2);
			       String teléfono  = rs.getString("teléfono_trab");
			       String correo = rs.getString("correo_trab");
			    
			       miCoordinador.agregarDatosATabla(nombre,rut,teléfono,correo, tabla);
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

	public void disponibilidadProductoYValor(MongoDatabase db, JTable tabla, String producto) {
		var coleccion = db.getCollection(producto);
		db.getCollection(producto).aggregate(null);
		/*
		db.producto.aggregate([
		               		{ $match: producto.código: ‘KML60092RS’}},
		               		{
		               		$group: {	
		               código: “$código”,
		                  		descripción: “$descripción”
		               		precio_actual: “$precio_actual”
		               }
		                     }
		               ]);
*/
	
		/*
		 
		try {
				Statement stmt = db.createStatement();
				ResultSet rs = stmt.executeQuery( "SELECT código, descripción, stock, precio_actual FROM producto WHERE producto.código= '"+producto+"';" );
				while (rs.next()) {
				       String código = rs.getString("código");
				       String descripción = rs.getString("descripción");
				       String stock  = rs.getString("stock");
				       String precioActual = rs.getString("precio_actual");				       
				       	
				       miCoordinador.agregarDatosATabla(código,descripción,stock,precioActual,tabla);
				    }
				miCoordinador.cerrarConexion(stmt, rs, db);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		*/
	}

	public void buscarDeudores(MongoDatabase db, JTable tabla) throws UnknownHostException, MongoException {
		MongoCollection<Document> collection = db.getCollection("documento_compra");
		
		System.out.print("entra");
		Bson match = match(eq("Estado", "impaga"));
		List<Document> results = collection.aggregate(Arrays.asList(match)).into(new ArrayList<>());
		results.forEach(printDocuments());
		
		
		/*
		db.factura.aggregate([
		              		{ $match: estado: ‘impaga’}},
		              		{
		              		$group: {
		              			_id:”rut_empresa”,
		                 		deuda_total: { $sum: “monto_total” }
		              }
		                    }
		              ])
		              */

		/*try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT estado, doc_fac ,monto_total, correo_emp, teléfono_emp, rut_trabajador, nombre\r\n"
					+ "FROM factura , empresa, trabajador , venta_fc \r\n"
					+ "WHERE factura.estado = 'impaga' AND factura.doc_fac = venta_fc.doc_fc AND factura.rut_empresa = empresa.rut_empresa AND venta_fc.rut_trabajador_fc = trabajador.rut_trabajador;" );
			while (rs.next()) {
			       String estado = rs.getString("estado");
			       String doc_fac = rs.getString("doc_fac");
			       String monto_total  = rs.getString("monto_total");
			       String correo_emp = rs.getString("correo_emp");
			       String teléfono_emp = rs.getString("teléfono_emp");
			       String rut_trabajador = rs.getString("rut_trabajador");
			       String nombre = rs.getString("nombre");
			       miCoordinador.agregarDatosATabla(estado,doc_fac,monto_total,correo_emp,teléfono_emp,rut_trabajador,nombre,tabla);
			       System.out.println(estado);
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	 private static Consumer<Document> printDocuments() {
	        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
	    }
	

	public void buscarProducto(Connection cn, String cod, JTextField textCódBarra, JTextField textDecripción, JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT código, código_barra ,descripción, stock, precio_actual, familia\r\n"
					+ "FROM producto \r\n"
					+ "WHERE código = '"+cod+"';" );
			while (rs.next()) {
			       //String código = rs.getString("código");
			       String código_barra = rs.getString("código_barra");
			       String descripción = rs.getString("descripción");
			       String stock  = rs.getString("stock");
			       String precio_actual = rs.getString("precio_actual");
			       String familia = rs.getString("familia");
			
			       miCoordinador.agregarDatosProductoBuscado(código_barra,descripción,stock,precio_actual,familia, textCódBarra, textDecripción, textFamilia, textPrecioActual, textStock);
			       
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void agregarProducto(Connection cn, JTextField textCódigo, JTextField textCódBarra, JTextField textDescripción, JTextField textFamilia, JTextField textPrecioActual, JTextField textStock) {
		try {
			
			String código = textCódigo.getText();
			String códBarra = textCódBarra.getText();
			String descripción = textDescripción.getText();
			String familia = textFamilia.getText();
			Integer precioActual = Integer.parseInt(textPrecioActual.getText());
			Integer stock = Integer.parseInt(textStock.getText());
			Integer stockCrítico = 10;
			
			PreparedStatement stmt = cn.prepareStatement("INSERT INTO producto VALUES(?,?,?,?,?,?,?);");
			stmt.setString(1, código);
			stmt.setString(2, códBarra);
			stmt.setString(3, descripción);
			stmt.setString(6, familia);
			stmt.setInt(5, precioActual);
			stmt.setInt(4, stock);
			stmt.setInt(7, stockCrítico);
			
			stmt.executeUpdate();
				
		    stmt.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void mostrarTablaProductos(Connection cn, JTable tabla) {
		try {
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT código, descripción ,familia, stock, precio_actual\r\n"
					+ "FROM producto  ;" );
			while (rs.next()) {
			       String código = rs.getString("código");
			       String descripción = rs.getString("descripción");
			       String familia  = rs.getString("familia");
			       String stock = rs.getString("stock");
			       String precio_actual = rs.getString("precio_actual");
			       miCoordinador.agregarDatosATablaProducto(código,descripción,familia,stock,precio_actual,tabla);
			       
			    }
			miCoordinador.cerrarConexion(stmt, rs, cn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Object> obtenerProductos(Connection cn) {
		try {
			ArrayList<Object> lista = new ArrayList<Object>();
			ArrayList<String> listaCódigo = new ArrayList<String>();
			ArrayList<Integer> listaCantidad = new ArrayList<Integer>();
			
			/*
			select datos.cod,sum(datos.cantidad)
from ((select Boleta.fecha_boleta as fecha, Boleta.doc_bt as doc, detalle_ventabt.código as cod,  		detalle_ventabt.cantidad_vendida as cantidad
	from detalle_ventabt,boleta
	where detalle_ventabt.doc_bt=boleta.doc_bt ) union (select factura.fecha_factura as fecha, factura.doc_fac as doc, detalle_ventafc.código as cod, detalle_ventafc.cantidad_vendida as cantidad
	from detalle_ventafc,factura
	where detalle_ventafc.doc_fc=factura.doc_fac ))as datos
where datos.fecha = '20200102' 
group by datos.cod;
	*/
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery( "select datos.cod,sum(datos.cantidad)\r\n"
					+ "from ((select Boleta.fecha_boleta as fecha, Boleta.doc_bt as doc, detalle_ventabt.código as cod,  		detalle_ventabt.cantidad_vendida as cantidad\r\n"
					+ "	from detalle_ventabt,boleta\r\n"
					+ "	where detalle_ventabt.doc_bt=boleta.doc_bt ) union (select factura.fecha_factura as fecha, factura.doc_fac as doc, detalle_ventafc.código as cod, detalle_ventafc.cantidad_vendida as cantidad\r\n"
					+ "	from detalle_ventafc,factura\r\n"
					+ "	where detalle_ventafc.doc_fc=factura.doc_fac ))as datos\r\n"
					+ "where datos.fecha = '20200102' \r\n"
					+ "group by datos.cod;" );
			while (rs.next()) {
			       String código = rs.getString("cod");
			       listaCódigo.add(código);
			       int cantidad = rs.getInt("sum");
			       listaCantidad.add(cantidad);
			       
			}
			lista.add(listaCódigo);
			lista.add(listaCantidad);
			miCoordinador.cerrarConexion(stmt, rs, cn);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
		
		
	}
	
	

}

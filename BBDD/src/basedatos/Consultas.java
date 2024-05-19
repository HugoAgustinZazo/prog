package basedatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

	
	public static void clientePorNombre(String nombre) {
		
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlSelect = "SELECT * FROM clientes WHERE nombre LIKE '" + nombre + "' ORDER BY id DESC";  
			ResultSet rs = stmt.executeQuery(sqlSelect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Dbmanager.close();
	}
	public static void productoPorDescr(String descripcion) {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlSelect = "SELECT * FROM Productos WHERE descripcion LIKE '" + descripcion + "' ORDER BY id DESC";
			ResultSet rs = stmt.executeQuery(sqlSelect);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Dbmanager.close();
	}
	public static void productoPorPrecio(Double precio) {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlSelect = "SELECT id, nombre FROM Productos WHERE precio = " + precio + " ORDER BY id DESC";
			ResultSet rs = stmt.executeQuery(sqlSelect);
			System.out.println(rs.getString(1)+" - "+rs.getString("nombre"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Dbmanager.close();
	}public static void ventaPorCli(int id) {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlSelect = "SELECT id,nombre FROM Ventas WHERE id = " + id + " ORDER BY id DESC";
			ResultSet rs = stmt.executeQuery(sqlSelect);
			System.out.println(rs.getString(1)+" - "+rs.getString("nombre"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Dbmanager.close();
	}
	public static void ventaPorFecha(int fecha) {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlSelect = "SELECT id,nombre,fecha_venta FROM Ventas WHERE YEAR(fecha_venta) = " + fecha + " ORDER BY id DESC";
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while(rs.next()) {
			System.out.println(rs.getString(1)+" - "+rs.getString("nombre")+" - "+rs.getString(3));
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		Dbmanager.close();
	}
	
}

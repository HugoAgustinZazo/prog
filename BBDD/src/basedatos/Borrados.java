package basedatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Borrados {
public static void clientePorNombre(String nombre) {
		
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Statement stmt;
		try {
			stmt = Dbmanager.conn.createStatement();
			String sqlDelete = "DELETE FROM clientes WHERE nombre LIKE '" + nombre + "'";  
			int reg = stmt.executeUpdate(sqlDelete);
			System.out.println("Número de registros borrados: "+reg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Dbmanager.close();
	}

public static void productoPorNombre(String nombre) {
	Dbmanager.loadDriver();
	Dbmanager.connect();
	Statement stm;
	try {
		stm = Dbmanager.conn.createStatement();
		String sqlDelete="DELETE FROM productos WHERE nombre LIKE '"+ nombre +"'";
		int reg = stm.executeUpdate(sqlDelete);
		System.out.println("Número de registros borrados: "+reg);
	}catch(SQLException e) {
		e.printStackTrace();
	}
Dbmanager.close();
}

public static void ventaPorCli(int idcliente) {
	Dbmanager.loadDriver();
	Dbmanager.connect();
	Statement stm;
	try {
		stm = Dbmanager.conn.createStatement();
		String sqlDelete="DELETE FROM ventas WHERE cliente_id = "+ idcliente +"";
		int reg = stm.executeUpdate(sqlDelete);
		System.out.println("Número de registros borrados: "+reg);
	}catch(SQLException e) {
		e.printStackTrace();
	}
Dbmanager.close();
}
public static void ventaPorProducto(int idproducto) {
	Dbmanager.loadDriver();
	Dbmanager.connect();
	Statement stm;
	try {
		stm = Dbmanager.conn.createStatement();
		String sqlDelete="DELETE FROM ventas WHERE cliente_id = "+ idproducto +"";
		int reg = stm.executeUpdate(sqlDelete);
		System.out.println("Número de registros borrados: "+reg);
	}catch(SQLException e) {
		e.printStackTrace();
	}
Dbmanager.close();
}
}


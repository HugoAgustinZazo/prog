package bbdd;

import java.sql.SQLException;
import java.sql.Statement;



public class Probar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Principal.loadDriver();
Principal.connect();
try {
	Statement stmt =  Principal.conn.createStatement();
	for(int i=0;i<10;i++) {
	String nombre="'Pedro Gil";
	nombre = nombre + i;
	String sql = "INSERT INTO clientes(nombre,direccion) VALUES ("+nombre+"', 'leganes')";
	int nr =stmt.executeUpdate(sql);
	System.out.println("Registro insertado");
	
	}
}catch (SQLException e) {
	
}
Principal.close();
	}

}

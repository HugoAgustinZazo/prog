package basedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {
	// Conexión a la base de datos
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dbmanager.loadDriver();
		
		Dbmanager.connect();
		
		try {
			Statement stmt = Dbmanager.conn.createStatement();
		/*	String nombre="'Pedro Gil";
			for (int i=0;i<10;i++) {
				
				nombre = nombre + i;	
				String sql = "INSERT INTO clientes(nombre,direccion) VALUES ("+nombre+"', 'Leganés')";
				
				System.out.println(sql);
				
				int nr = stmt.executeUpdate(sql);
				System.out.println("REGISTRO INSERTADO CORRECTAMENTE " + nr);
				nombre="'Pedro Gil";
			}*/
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("INTRODUCE UN NÚMERO ENTERO:");
			int num = teclado.nextInt();
			
			String sqlSelect = "SELECT NOMBRE,ID FROM clientes where id < " + num + " ORDER BY id DESC";  
			
			
			
			
			ResultSet rs = stmt.executeQuery(sqlSelect);
			rs.last();
			System.out.println(rs.getString(2)+" - " + rs.getString("nombre") );
			
			
			String nombre;
			String direccion;
			String id;
			int cont=1;
			while (rs.next()) {
			//	System.out.println("Registro de la BBDD: " + cont);
				System.out.println(rs.getString(2)+" - " + rs.getString("nombre") );
				cont++;
				
			}
			
			System.out.println("INTRODUCE EL ID DE UN CLIENTE PARA BORRAR:");
			num = teclado.nextInt();
			String sqlDelete = "DELETE FROM clientes WHERE id < " + num;
			
			int reg = stmt.executeUpdate(sqlDelete);
			System.out.println("SE HAN ELIMINADO " + reg + " REGISTROS ");
			
			
			System.out.println("INTRODUCE EL ID DE UN CLIENTE PARA ACTUALIZAR:");
			num = teclado.nextInt();
			teclado.nextLine();
			System.out.println("INTRODUCE EL NUEVO NOMBRE PARA EL CLIENTE:");
			String nuevoNombre = teclado.nextLine();
			String sqlUpdate = "UPDATE clientes SET nombre='" + nuevoNombre + "' WHERE id=" + num;
			
			reg = stmt.executeUpdate(sqlUpdate);
			System.out.println("SE HAN ACTUALIZADO " + reg + " REGISTROS ");
			
			
			sqlSelect = "SELECT NOMBRE,ID FROM clientes";  
			rs = stmt.executeQuery(sqlSelect);
			
			
			while (rs.next()) {
			//	System.out.println("Registro de la BBDD: " + cont);
				System.out.println(rs.getString(2)+" - " + rs.getString("nombre") );
				
			}
			
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Dbmanager.close();
	}
    
}

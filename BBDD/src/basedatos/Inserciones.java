package basedatos;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Inserciones {
	
	public static void insertarCliente() throws SQLException {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Cuantos clientes deseas insertar");
		int clientes = teclado.nextInt();
		Statement stm = Dbmanager.conn.createStatement();
		
		try{
			for(int i=0;i<clientes;i++) {
		System.out.println("Dime un nombre");
		String nombre=teclado.next();
		System.out.println("Dime una direccion");
		String direccion = teclado.next();
		System.out.println("Dime un telefono");
		int telefono=teclado.nextInt();
		String sqlInsert="INSERT INTO clientes(nombre,direccion,telefono) VALUES ('"+ nombre +"','"+ direccion +"',"+ telefono +")";	
		stm.executeUpdate(sqlInsert);	
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
	}
	public static void insertarProducto() throws SQLException {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Cuantos productos deseas insertar");
		int productos = teclado.nextInt();
		Statement stm = Dbmanager.conn.createStatement();
		
		try{
			for(int i=0;i<productos;i++) {
		System.out.println("Dime un nombre");
		String nombre=teclado.next();
		System.out.println("Dime una descripcion");
		teclado.nextLine();
		String descripcion = teclado.nextLine();
		System.out.println("Dime un precio");
		int precio=teclado.nextInt();
		String sqlInsert="INSERT INTO Productos(nombre,descripcion,precio) VALUES ('"+ nombre +"','"+ descripcion +"',"+ precio +")";	
		stm.executeUpdate(sqlInsert);	
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	teclado.close();
	Dbmanager.close();
	}
	public static void insertarVenta() throws SQLException {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		
		Scanner teclado=new Scanner(System.in);
		System.out.println("Cuantas ventas deseas insertar");
		int ventas = teclado.nextInt();
		Statement stm = Dbmanager.conn.createStatement();
		
		try{
			for(int i=0;i<ventas;i++) {
		System.out.println("Dime el id de un cliente");
		int idcliente=teclado.nextInt();
		System.out.println("Dime el id de un producto");
		int idproducto = teclado.nextInt();
		System.out.println("Dime una cantidad");
		int cantidad=teclado.nextInt();
		String sqlInsert="INSERT INTO Ventas(cliente_id,producto_id,cantidad,fecha_ventas) VALUES ('"+ idcliente +"','"+ idproducto +"',"+ cantidad +","+ LocalDate.now()+")";	
		stm.executeUpdate(sqlInsert);	
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
	}
}

package basedatos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actualizaciones {
	public static void actualizarDatosCli() {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Scanner teclado = new Scanner(System.in);
		Statement stmt;
		try {
		stmt = Dbmanager.conn.createStatement();
		System.out.println("INTRODUCE EL ID DE UN CLIENTE PARA ACTUALIZAR:");
		int num = teclado.nextInt();
		teclado.nextLine();
		System.out.println("INTRODUCE EL NUEVO NOMBRE PARA EL CLIENTE:");
		String nuevoNombre = teclado.nextLine();
		String sqlUpdate = "UPDATE clientes SET nombre='" + nuevoNombre + "' WHERE id=" + num;
		stmt.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
		}
	public static void actualizarPrecioProd() {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Scanner teclado = new Scanner(System.in);
		Statement stmt;
		try {
		stmt = Dbmanager.conn.createStatement();
		System.out.println("INTRODUCE EL ID DE UN PRODUCTO PARA ACTUALIZAR SU PRECIO:");
		int num = teclado.nextInt();
		System.out.println("INTRODUCE EL NUEVO PRECIO PARA EL PRODUCTO:");
		int nuevoprecio = teclado.nextInt();
		String sqlUpdate = "UPDATE Productos SET precio='" + nuevoprecio + "' WHERE id=" + num;
		stmt.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
		}
	public static void actualizarCantidadVenta() {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Scanner teclado = new Scanner(System.in);
		Statement stmt;
		try {
		stmt = Dbmanager.conn.createStatement();
		System.out.println("INTRODUCE EL ID DE UNA VENTA PARA ACTUALIZAR SU CANTIDAD:");
		int num = teclado.nextInt();
		System.out.println("INTRODUCE LA NUEVA CANTIDAD PARA LA VENTA:");
		int nuevacantidad = teclado.nextInt();
		String sqlUpdate = "UPDATE Ventas SET cantidad='" + nuevacantidad + "' WHERE id=" + num;
		stmt.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
		}
	public static void actualizarFechaVenta() {
		Dbmanager.loadDriver();
		Dbmanager.connect();
		Scanner teclado = new Scanner(System.in);
		Statement stmt;
		try {
		stmt = Dbmanager.conn.createStatement();
		System.out.println("INTRODUCE EL ID DE UNA VENTA PARA ACTUALIZAR SU FECHA:");
		int num = teclado.nextInt();
		System.out.println("INTRODUCE LA NUEVA FECHA:");
		String nuevafecha = teclado.next();
		String sqlUpdate = "UPDATE Ventas SET fecha_ventas='" + nuevafecha + "' WHERE id=" + num;
		stmt.executeUpdate(sqlUpdate);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		teclado.close();
		Dbmanager.close();
		}
}

package basedatos;

public class PintaMenus {
	public static void pintaMenu() {
		System.out.println("*****************");
		System.out.println("1.- Seleccionar");
		System.out.println("2.- Insertar");
		System.out.println("3.- Actualizar");
		System.out.println("4.- Borrar");
		System.out.println("5.- Salir");
		System.out.println("*****************");
		System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES");
	}

	public static void pintaMenuSelect() {
		System.out.println("*****************");
		System.out.println("1.- Buscar clientes por nombre");
		System.out.println("2.- Buscar productos por descripcion");
		System.out.println("3.- Buscar productos por precio");
		System.out.println("4.- Buscar ventas por cliente");
		System.out.println("5.- Buscar ventas por fecha de venta");
		System.out.println("*****************");
		System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES");
	}
	
	public static void pintaMenuInsert() {
		System.out.println("*****************");
		System.out.println("1.- Insertar cliente");
		System.out.println("2.- Insertar producto");
		System.out.println("3.- Insertart Venta");
		System.out.println("*****************");
		System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES");
	}
	
	public static void pintaMenuUpdate() {
		System.out.println("*****************");
		System.out.println("1.- Actualizar datos cliente");
		System.out.println("2.- Actualizar precio producto");
		System.out.println("3.- Actualizar cantidad venta");
		System.out.println("4.- Actualizar fecha venta");
		System.out.println("*****************");
		System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES");
	}
	
	public static void pintaMenuDelete() {
		System.out.println("*****************");
		System.out.println("1.- Borrar cliente por nombre");
		System.out.println("2.- Borrar producto por nombre");
		System.out.println("3.- Borrar ventas por cliente");
		System.out.println("4.- Borrar ventas por producto");
		System.out.println("5.- Borrar ventas");
		System.out.println("*****************");
		System.out.println("ELIGE UNA DE LAS OPCIONES ANTERIORES");
	}
}

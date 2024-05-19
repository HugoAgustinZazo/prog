package basedatos;

import java.util.Scanner;

public class GestionBBDD {

	
	public static void seleccion(int opcion) {
		Scanner teclado = new Scanner(System.in);
		
		switch (opcion) {
		case 1:
			System.out.println("INTRODUCE EL NOMBRE DE UN CLIENTE");
			String nombre = teclado.nextLine();
			Consultas.clientePorNombre(nombre);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		default: 
			System.out.println("NO HAS ELEGIDO UNA OPCIÓN VÁLIDA");
		}
		
		
	}
	
}

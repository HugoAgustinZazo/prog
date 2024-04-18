package Tema8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGato {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner teclado= new Scanner(System.in);
		System.out.println("Dime un numero de gatos");
		int gatos = teclado.nextInt();
		
		try {
			for(int i=0;i<gatos;i++) {
				System.out.println("Dime su nombre");
				String nombre = teclado.next();
				System.out.println("Dime su edad");
				int edad = teclado.nextInt();
			Gato g = new Gato(nombre,edad);
			System.out.println("Quiere cambiar el nombre y la edad");
			 String si=teclado.next();
			if( si.equalsIgnoreCase("si")) {
				System.out.println("Dime el nuevo nombre");
				String nombre2=teclado.next();
				g.setNombre(nombre2);
				System.out.println("Dime su nueva edad");
				int edad2 = teclado.nextInt();
				g.setEdad(edad2);
			}
			}
		}catch(InputMismatchException e) {
			System.out.println("Ese tipo de dato no esta permitido");
		}
	}

}

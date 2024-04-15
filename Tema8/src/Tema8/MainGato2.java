package Tema8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGato2 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ArrayList <Gato> gatoss= new ArrayList();
		Scanner teclado= new Scanner(System.in);
		try {
			for(int i=0;i<5;i++) {
				System.out.println("Dime su nombre");
				String nombre = teclado.next();
				System.out.println("Dime su edad");
				int edad = teclado.nextInt();
			 gatoss.add(new Gato(nombre,edad));
			System.out.println("Quiere cambiar el nombre y la edad");
			 String si=teclado.next();
			if( si.equalsIgnoreCase("si")) {
				
				for(Gato g:gatoss) {
				System.out.println("Dime el nuevo nombre");
				String nombre2=teclado.next();
				g.setNombre(nombre2);
				System.out.println("Dime su nueva edad");
				int edad2 = teclado.nextInt();
				g.setEdad(edad2);
				}
			}
			}
		}catch(InputMismatchException e) {
			System.out.println("Ese tipo de dato no esta permitido");
		}
	}

}

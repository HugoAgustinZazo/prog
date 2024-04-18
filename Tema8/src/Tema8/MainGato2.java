package Tema8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGato2 {

	public static void main(String[] args)throws ExcepcionNombre,ExcepcionEdad {
		// TODO Auto-generated method stub
		 ArrayList <Gato> gatoss= new ArrayList();
		 Scanner teclado= new Scanner(System.in);
		
		int gatosvalidos=0;
		while(gatosvalidos<5) {
		
		try {
			System.out.println("Dime su nombre");
			String nombre = teclado.next();
			if(nombre.length()<3) {
				throw new ExcepcionNombre(nombre);
			}
			System.out.println("Dime su edad");
			int edad = teclado.nextInt();		
			if (edad<0) {
				throw new ExcepcionEdad(edad);
			}
			gatoss.add(new Gato(nombre,edad));
				gatosvalidos++;
			
		
		}catch(ExcepcionNombre e) {
			System.out.println("El nombre no puede tener menos de tres letras");
			e.printStackTrace();
		}catch (ExcepcionEdad e) {
			System.out.println("La edad no puede ser negativa");
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("Datos no validos");
		}
	  }
		for(Gato g:gatoss) {
			g.imprimir();
		}
	}
	
}


package Tema8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eje5 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
	try {
		System.out.println("Cuantas veces quieres que se repita el bucle");
		int numero = teclado.nextInt();
		for(int i=0;i<numero;i++) {	
		System.out.println("Dime un numero");
			int num=teclado.nextInt();
		imprimePositivo(num);
		imprimeNegativo(num);
		
		}
	}catch(InputMismatchException e){
		System.out.println("El valor debe ser numerico");
	e.printStackTrace();
	}
	
	System.out.println("Termina el programa");
	
	
	
	}public static void imprimePositivo(int num)throws Exception {
		if(num < 0) {
			throw new Exception("Numero negativo no valido");
		}else 
			System.out.println(num);
	}public static void imprimeNegativo(int num)throws Exception {
		if(num >= 0) {
			throw new Exception("Numero negativo no valido");
		}else 
			System.out.println(num);
	}
	
	
	

}

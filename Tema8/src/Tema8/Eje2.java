package Tema8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eje2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		try {
			System.out.println("Dime un numero");
			int x = teclado.nextInt();
			System.out.println("Dime otro numero");
			int y = teclado.nextInt();
			int res=x/y;
			System.out.println("El resultado es:"+res);
		}catch (InputMismatchException e){
			System.out.println("El valor tiene que ser un numero");
			e.printStackTrace();
		}catch(ArithmeticException e){
			System.out.println("error");
			e.printStackTrace();
		}
		System.out.println("Continua el programa");
	}

}

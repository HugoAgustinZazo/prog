package Tema8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eje1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		
		try {
			System.out.println("Dime un numero");
			int x = teclado.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Valor no valido");
			e.printStackTrace();
		}
		System.out.println("Continua el programa");
	}

}

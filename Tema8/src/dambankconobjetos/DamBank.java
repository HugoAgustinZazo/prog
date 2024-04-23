package dambankconobjetos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DamBank {

	public static void main(String[] args) throws Avisarhacienda, CuentaException {
		// TODO Auto-generated method stub
	
		
	
		Scanner teclado = new Scanner(System.in);
		int opcion=0;
		
				
	
		//CuentaBancaria cb3 = new CuentaBancaria("ES99999");
		//Movimientos m1 = new Movimientos("ES12345",getFechaActual(),100.0f,"Cena");
		//Movimientos m2 = new Movimientos("ES12345",getFechaActual(),-20.0f,"Comida");

		boolean estado=false;
		String iban;
		String conc;
		Float cant;
		while(!estado) {
		try {
		while (opcion != 8) {
			pintaMenu();
			System.out.println("INTRODUCE UNA OPCIÓN: ");
			opcion=teclado.nextInt();
			switch (opcion) {
			
			case 1:
				CuentaBancaria.mostrarCuentaBancaria();
				break;
			case 2: 
				CuentaBancaria.mostrarIban();
				break;
			case 3:
				CuentaBancaria.mostrarTitular();
				break;
			case 4:
				CuentaBancaria.mostrarSaldo();
				break;
			case 5:
				CuentaBancaria.ingresarDef();
				break;
			case 6: 
				CuentaBancaria.retirarDef();
				break; 
			case 7:
				CuentaBancaria.mostrarMovimientos();
				break;
			case 8: 
				System.out.println("GRACIAS POR USAR ESTA APLICACIÓN");
				System.out.println("TODOS LOS DATOS SE PERDERÁN");
				estado=true;
				break;
			case 9:
				CuentaBancaria.añadirCuenta();
				break;
				
			default:
				System.out.println("NO HAS ELEGIDO UNA OPCIÓN CORRECTA");
				System.out.println("¡ELIGE BIEN!");
			}
		}
			
		}catch(InputMismatchException e) {
			System.out.println("Tipo de dato incorrecto");
			e.printStackTrace();
		}
	}
}


	public static void pintaMenu() {
		
		System.out.println("***********MENÚ DAMBANK************ ");
		System.out.println("1. Datos de la cuenta. ");
		System.out.println("2. IBAN.  ");
		System.out.println("3. Titular.");
		System.out.println("4. Saldo.  ");
		System.out.println("5. Ingreso. ");
		System.out.println("6. Retirada.");
		System.out.println("7. Movimientos.");
		System.out.println("9. Crear Cuenta Bancaria.");
		System.out.println("8. Salir.");
		System.out.println("************************************ ");
		
	}
}

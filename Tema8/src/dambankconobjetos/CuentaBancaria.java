package dambankconobjetos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria {
	String iban; 
	Persona titular;
	float saldo;
	static ArrayList <Movimientos> mv = new ArrayList();

	
	
	static Scanner teclado = new Scanner(System.in);
	public CuentaBancaria(String iban) {
		this.iban = iban;
		System.out.println("Dime su dni");
		String dni = teclado.next();
		System.out.println("Dime su nombre");
		String nombre = teclado.next();
		System.out.println("Dime su apellido");
		String apellido = teclado.next();
		System.out.println("Dime sudomicilio");
		String domicilio = teclado.next();
		this.titular = new Persona(dni,nombre,apellido,domicilio);
		this.saldo = 0;
		this.mv = new ArrayList<Movimientos>();
	}
	/*
	public CuentaBancaria(String iban, Persona titular) {
		this.iban = iban;
		this.titular = titular;
		this.saldo = 0;
		this.movimientos = new Movimientos[maxMovimientos];
	}
	*/
	static ArrayList <CuentaBancaria> cb = new ArrayList();
	
	public void mostrarInfo() {
		System.out.println("***************************");
		System.out.println("DATOS DE LA CUENTA BANCARIA");
		System.out.println("***************************");
		this.titular.mostrarInfoPersona();
		System.out.println();
		System.out.println("IBAN:" + this.getIban());
		System.out.println("Saldo:" + this.getSaldo());
		System.out.println("***************************");
	}
	
	public void mostrarIban() {
		System.out.println("###############################");
		System.out.println("IBAN: " + this.iban);
		System.out.println("###############################");
	}
	
	public void mostrarTitular() {
		System.out.println("####### TITULAR DE LA CUENTA #####");
		this.titular.mostrarInfoPersona();
		System.out.println();
		System.out.println("###############################");
		
	}
	public void mostrarSaldo() {
		System.out.println("###############################");
		System.out.println("Saldo: " + this.saldo);
		System.out.println("###############################");
	}
	
	public static void ingresar(String iban,Movimientos m) {
		for(CuentaBancaria cbb:cb) {
		if(cbb.getIban().equalsIgnoreCase(iban)) {
			cbb.saldo = cbb.saldo + m.getCantidad();
			System.out.println("Ingreso hecho");
			}
		}
	}
	

	public static void retirar(String iban, Movimientos m) {
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {
				cbb.saldo = cbb.saldo - m.getCantidad();
				System.out.println("Ingreso hecho");
				}
			}	
	}
		
		
	
	
	
	
	public static void mostrarMovimientos(String iban) {
	for(CuentaBancaria cbb:cb) {	
		if(cbb.getIban().equalsIgnoreCase(iban)) {
		System.out.println("***************************");
		System.out.println("LISTADO DE MOVIMIENTOS");
		System.out.println("***************************");
		for(Movimientos mov:cbb.mv) {
			mov.toString();
		}
		}
	}
	}
	public static void movimientos() {
		for(Movimientos mov:mv) {
			mov.toString();
		}
	}
	public static void mostrarCuentaBancaria(String iban) {
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {
				cbb.mostrarInfo();
			}
				
		}
	}
	public static void mostrarIban(String iban) {
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {
				cbb.mostrarIban();
			}
				
		}
	}
	public static void mostrarTitular(String iban) {
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {
				cbb.mostrarTitular();
			}
				
		}
	}
	public static void mostrarSaldo(String iban) {
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {
				cbb.mostrarSaldo();
			}
				
		}
	}public static void ingresarDef() {
		System.out.println("INTRODUCE IBAN:");
		String iban1=teclado.next();
		System.out.println("INTRODUCE CANTIDAD:");
		float cant=teclado.nextFloat();
	teclado.nextLine();
	System.out.println("INTRODUCE CONCEPTO:");
	String conc=teclado.nextLine();
	for(CuentaBancaria cbb:cb) {
	if(cbb.getIban().equalsIgnoreCase(iban1)) {	
		cbb.mv.add(new Movimientos(iban1,getFechaActual(),cant,conc));
		for(Movimientos m:cbb.mv) {
	if (m.getCantidad()<=0) {
		System.out.println("ERROR, NO SE PUEDE INGRESAR UNA CANTIDAD INFERIOR A 1");
		
	} 
	if (m.getCantidad() > 3000) {
		System.out.println("¡¡¡AVISA A HACIENDA!!!");
	}
	cbb.saldo = cbb.saldo + m.getCantidad();
	System.out.println("Ingreso hecho");
	
	}
	}
	}
	}
	public static void retirarDef() {
		System.out.println("INTRODUCE IBAN:");
		String iban=teclado.next();
		System.out.println("INTRODUCE CANTIDAD:");
		float cant=teclado.nextFloat();
		teclado.nextLine();
		System.out.println("INTRODUCE CONCEPTO:");
		String conc=teclado.nextLine();
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {	
				cbb.mv.add(new Movimientos(iban,getFechaActual(),cant,conc));
				
			for(Movimientos m:cbb.mv) {
		if (m.getCantidad() <=0) {
			System.out.println("ERROR, NO SE PUEDE RETIRAR UNA CANTIDAD INFERIOR A 1");
			
		}if (cbb.getSaldo() - m.getCantidad() < -50) {
			System.out.println("NO PUEDES DEJAR LA CUENTA PELADA");
			
		}
		
		if (cbb.saldo < 0) {
			System.out.println("HAS DEJANDO LA CUENTA EN NEGATIVO");
		}
		cbb.saldo = cbb.saldo - m.getCantidad();
			}
			}
		}
			}
	public static void añadirCuenta() {
		System.out.println("Dime un iban");
		String iban2=teclado.next();
		System.out.println("Ahora dime una persona");
		cb.add(new CuentaBancaria(iban2));
		
	}
	
	
	public String getIban() {
		return iban;
	}



	public void setIban(String iban) {
		this.iban = iban;
	}



	public Persona getTitular() {
		return titular;
	}



	public void setTitular(Persona titular) {
		this.titular = titular;
	}



	public float getSaldo() {
		return saldo;
	}



	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public ArrayList<Movimientos> getMv() {
		return mv;
	}
	public void setMv(ArrayList<Movimientos> mv) {
		this.mv = mv;
	}


	public static String getFechaActual() {
		LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fecha.format(fechaFormateada);
	}

	
	
}

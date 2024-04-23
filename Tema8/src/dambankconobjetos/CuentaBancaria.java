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
 ArrayList <Movimientos> mv = new ArrayList();

	
	
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
	
	public static void mostrarMovimientos(String iban) {
	for(CuentaBancaria cbb:cb) {	
		if(cbb.getIban().equalsIgnoreCase(iban)) {
		System.out.println("***************************");
		System.out.println("LISTADO DE MOVIMIENTOS");
		System.out.println("***************************");
		for(Movimientos mov:cbb.mv) {
			System.out.println("********************");
				System.out.println("Fecha:"+mov.getFechaIngreso()+"\nCantidad:"+mov.getCantidad()+"\nConcepto:"+mov.getConcepto());
				System.out.println("********************");
		}
		}
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
	}public static void ingresarDef()throws AvisarHacienda,Cuentaexception {
		boolean estado = false;
		while(estado) {
		try {
			System.out.println("INTRODUCE IBAN:");
		String iban1=teclado.next();
		System.out.println("INTRODUCE CANTIDAD:");
		float cant=teclado.nextFloat();
	teclado.nextLine();
	System.out.println("INTRODUCE CONCEPTO:");
	String conc=teclado.nextLine();
	for(CuentaBancaria cbb:cb) {
	if(cbb.getIban().equalsIgnoreCase(iban1)) {	
<<<<<<< HEAD
		cbb.mv.add(new Movimientos(iban1,getFechaActual(),cant,conc));
		for(Movimientos m:cbb.mv) {
	if (m.getCantidad()<=0) {
		System.out.println("ERROR, NO SE PUEDE INGRESAR UNA CANTIDAD INFERIOR A 1");
		
=======
	if (cant<=0) {
		throw new Cuentaexception("No se puede ingresar una cantidad negativa:"+cant);
>>>>>>> 9d72020096bf65bdeaf89e32af2ba13cdba1a747
	} 
	if (cant > 3000) {
	throw new AvisarHacienda(iban1,cbb.getTitular());
	}
<<<<<<< HEAD
	cbb.saldo = cbb.saldo + m.getCantidad();
=======
	cbb.saldo = cbb.saldo + cant;
	cbb.mv.add(new Movimientos(iban1,getFechaActual(),cant,conc));
>>>>>>> 9d72020096bf65bdeaf89e32af2ba13cdba1a747
	System.out.println("Ingreso hecho");
	estado = true;
	}
	}
	}catch(Cuentaexception e){
		e.printStackTrace();
	}catch(AvisarHacienda e) {
		System.out.println("Debes avisar a hacienda");
		e.printStackTrace();
	}
		}
	}
	public static void retirarDef()throws Cuentaexception {
	boolean estado = false;
		while (estado) {
		try {
			System.out.println("INTRODUCE IBAN:");
		String iban=teclado.next();
		System.out.println("INTRODUCE CANTIDAD:");
		float cant=teclado.nextFloat();
		teclado.nextLine();
		System.out.println("INTRODUCE CONCEPTO:");
		String conc=teclado.nextLine();
		for(CuentaBancaria cbb:cb) {
			if(cbb.getIban().equalsIgnoreCase(iban)) {	
<<<<<<< HEAD
				cbb.mv.add(new Movimientos(iban,getFechaActual(),cant,conc));
				
			for(Movimientos m:cbb.mv) {
		if (m.getCantidad() <=0) {
			System.out.println("ERROR, NO SE PUEDE RETIRAR UNA CANTIDAD INFERIOR A 1");
			
		}if (cbb.getSaldo() - m.getCantidad() < -50) {
			System.out.println("NO PUEDES DEJAR LA CUENTA PELADA");
			
		}
		
=======
		if (cant <=0) {
			throw new Cuentaexception("No se puede retirar una cantidad negativa:"+cant);
		}if (cbb.getSaldo() -cant < -50) {
			throw new Cuentaexception("No se puede dejar la cuenta en negativo");			
		}
		cbb.saldo = cbb.saldo + (-cant);
		cbb.mv.add(new Movimientos(iban,getFechaActual(),-cant,conc));
		System.out.println("Retiro hecho");
>>>>>>> 9d72020096bf65bdeaf89e32af2ba13cdba1a747
		if (cbb.saldo < 0) {
			throw new Cuentaexception("No se puede dejar la cuenta en negativo+");
		}
<<<<<<< HEAD
		cbb.saldo = cbb.saldo - m.getCantidad();
=======
		estado = true;
>>>>>>> 9d72020096bf65bdeaf89e32af2ba13cdba1a747
			}
			}
		}catch(Cuentaexception e) {
			e.printStackTrace();
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

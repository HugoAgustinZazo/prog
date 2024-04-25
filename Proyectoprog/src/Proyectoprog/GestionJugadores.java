package Proyectoprog;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionJugadores {
	static ArrayList <Jugadores> jug = new ArrayList();
	static Scanner teclado = new Scanner(System.in);
	static ArrayList <Humanos> jugsis = new ArrayList();
	
	public static void añadirJugadores() throws JugadoresException{
		int jugadores =0;
		String respuesta;
		boolean añadir = false;
		System.out.println("Cuantos jugadores van a jugar?");
		int jugadoress = teclado.nextInt();
		while(jugadores <jugadoress && añadir==false) {
		try{
			System.out.println("¿Quiere añadir algun jugador?");
			respuesta = teclado.next();
			if(!respuesta.equalsIgnoreCase("si")) {
				añadir = true;
			}else {
			System.out.println("Dime un nombre");
			String nombre = teclado.next();
			for(Jugadores jg:jug) {
			if(jg instanceof Humanos) {
				if(((Humanos) jg).getNombre().equalsIgnoreCase(nombre)) {
					throw new JugadoresException(nombre);
				}
			}
		}
		jug.add(new Humanos(nombre));
		jugadores ++;
		System.out.println();
			}
	}catch(JugadoresException e) {
		e.printStackTrace();
		}
	}
		System.out.println("BUENA PARTIDA");
		for(int i=0;i<jugadoress-jugadores;i++) {
			jug.add(new Cpu("CPU"+(i+1)));
		}
	}
	public static void menuJugadores() {
		System.out.println("**********MENÚ**********");
		System.out.println("1- Ver jugadores");
		System.out.println("2- Añadir jugador");
		System.out.println("3- Eliminar jugador");
		System.out.println("4- Volver");
		System.out.println("************************");
		
	}
	public static void añadirJugadoresSistema() throws JugadoresException{
		boolean añadir = false;
		while (añadir==false) {
		try{
		System.out.println("Quieres añadir un jugador al sistema");
		String respuesta = teclado.next();
		if(respuesta.equalsIgnoreCase("si")) {
		System.out.println("Dime un nombre");
		String nombre = teclado.next();
		for(Humanos hu:jugsis) {
			if(hu.getNombre().equalsIgnoreCase(nombre)) {
				throw new JugadoresException(nombre);
				}
			}
		jugsis.add(new Humanos(nombre));
		}else {
			añadir = true;
		}
		}catch(JugadoresException e) {
			e.printStackTrace();
		}
	}
		System.out.println("Vuelva cuando necesite más jugadores :)");
	}
	public static void mostrarArray() {
		for(Jugadores jg:jug) {
			jg.mostrarInformacion();
		}
	}
	
}

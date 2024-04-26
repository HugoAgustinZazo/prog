package Proyectoprog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
		jug.add(new Humanos(nombre,0));
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
		GestionRanking.leerRanking("src/Ficheros/Ranking.txt");
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
		jugsis.add(new Humanos(nombre,0));
		}else {
			añadir = true;
		}
		}catch(JugadoresException e) {
			e.printStackTrace();
		}
	}
		GestionRanking.escribirRanking();
		System.out.println("Vuelva cuando necesite más jugadores :)");
	}
	public static void subMenuJugadores() throws JugadoresException {
		boolean salir=false;
		while(!salir){
			menuJugadores();
			int opcion = teclado.nextInt();
			switch(opcion){
				case 1:
					GestionRanking.leerRanking("src/Ficheros/Ranking.txt");
					System.out.println("************Jugadores del sistema************");
					for(Humanos hu:jugsis) {
						System.out.println(hu);
					}
					break;
				case 2:
					añadirJugadoresSistema(); 
					break;
				case 3:
					System.out.println("Dime el nombre del jugador que quieras eliminar o dar de baja del sistema");
					String nombre = teclado.next();
					eliminarJugadores(nombre);
					break;
				case 4:
					salir=true;
					break;
				default:
					System.out.println("Esa opcion no existe");
					break;
				
			}
			
		}
	}
	public static void eliminarJugadores(String nombre) throws JugadoresException{
		try {
		Path path = Paths.get("src/Ficheros/Ranking.txt");
		GestionRanking.leerRanking("src/Ficheros/Ranking.txt");
		for(Humanos hu:jugsis) {
			if(hu.getNombre().equalsIgnoreCase(nombre)) {
				jugsis.remove(hu);
			}else
				throw new JugadoresException("Ese jugador no esta en el sistema");
		}
			Files.delete(path);
			Files.createFile(path);
			GestionRanking.escribirRanking();
		}catch(IOException e) {
			System.err.println("");
		}catch(JugadoresException e) {
			System.err.println("");
		}
	}
	public static void mostrarArray() {
		for(Jugadores jg:jug) {
			jg.mostrarInformacion();
		}
	}
	
}

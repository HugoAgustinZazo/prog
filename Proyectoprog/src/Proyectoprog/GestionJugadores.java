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
		
			System.out.println("¿Quiere añadir algun jugador?");
			respuesta = teclado.next();
			if(!respuesta.equalsIgnoreCase("si")) {
				añadir = true;
			}else 
			try {	
			System.out.println("Dime un nombre");
			String nombre = teclado.next();
			verificarJugadorPartida(nombre);
			verificarSistema(nombre,jugadores);
			jugsis.add(new Humanos(nombre, 0));
			System.out.println("Jugador añadido al sistema");	
		jug.add(new Humanos(nombre,0));
		jugadores ++;
		System.out.println();
			
	}catch(JugadoresException e) {
		e.printStackTrace();
		}
	}
		System.out.println("BUENA PARTIDA");
		añadirCpu(jugadoress,jugadores);
	}
	public static void verificarSistema(String nombre, int jugadores) {
		for(Humanos sis :jugsis) {
			if(sis.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("Este jugador esta registrado en el sistema por lo que si puede jugar");
				jug.add(new Humanos(nombre,0));
				System.out.println("Se ha añadido el jugador a la partida");
				jugadores ++;
			}else 
				System.out.println("Ese jugador no esta registrado en el sistema, por lo que sera registrado automaticamente");
		}
	}
	public static void verificarJugadorPartida(String nombre) throws JugadoresException {
		for(Jugadores jg:jug) {
			if(jg instanceof Humanos) {
				if(((Humanos) jg).getNombre().equalsIgnoreCase(nombre)) {
					throw new JugadoresException(nombre);
				}
			}
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
	public static void añadirCpu(int jugadoress,int jugadores) {
		for(int i=0;i<jugadoress-jugadores;i++) {
			jug.add(new Cpu("CPU"+(i+1)));
		}
	}
	public static void añadirJugadoresSistema() throws JugadoresException{
		boolean añadir = false;
		int contador=0;
		GestionRanking.leerRanking("src/Ficheros/Ranking.txt");
		while (añadir==false) {
		try{
			System.out.println("Cuantos jugadores quieres añadir");
			int jugadores=teclado.nextInt();
			System.out.println("Dime su nombre");
			String nombre = teclado.next(); {
		for(Humanos hu:jugsis) {
			if(hu.getNombre().equalsIgnoreCase(nombre)) {
				throw new JugadoresException(nombre);
				}
			}
		jugsis.add(new Humanos(nombre,0));
		contador++;
		if(contador>=jugadores) {
			añadir=true;
		}
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
					System.out.println("Vas a añadir jugadores al sistema");
					System.out.println();
					añadirJugadoresSistema(); 
					break;
				case 3:
					System.out.println("Dime el nombre del jugador que quieras eliminar o dar de baja del sistema");
					String jugador = teclado.next();
					eliminarJugadores(jugador);
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

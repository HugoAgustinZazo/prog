package Proyectoprog;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class GestionarPartida {
	 static ArrayList <Preguntas> preg = new ArrayList();
	 static Scanner teclado = new Scanner(System.in);
	 
	 public static void Partida() throws JugadoresException, FileSystemException, IOException {
		System.out.println("Va a comenzar la partida, primero añade los jugadores a la partida");
		GestionJugadores.añadirJugadores();
		int opcion=0;
		while(opcion!=5) {
		menu();
		switch(opcion) {
		case 1:
			estructuraRonda(3);
			break;
		case 2:
			estructuraRonda(5);
			break;
		case 3:
			estructuraRonda(10);
			break;
		case 4:
			estructuraRonda(20);
			break;
		case 5:
			break;
		default:
			System.out.println("Esa opción no esta disponible");
			break;
		
		}

		}
	}
	public static void rellenarArrayPreguntas() {
		preg.add(new PreguntasMates(Constantes.enunciadoMates));
		preg.add(new PreguntasIngles(Constantes.enunciadoIngles));
		preg.add(new PreguntasLengua(Constantes.enunciadoLengua));
		 
	}
	public static Preguntas preguntaAleatoria(){
		Random random = new Random();
		int num=random.nextInt(preg.size())+0;
		return preg.get(num);
		
	}
	public static void menu() {
		System.out.println("********MENÚ********");
		System.out.println("1- Partida rapida(3 rondas)");
		System.out.println("2- Partida corta(5 rondas)");
		System.out.println("3- Partida normal(10 rondas)");
		System.out.println("4- Partida larga(20 rondas)");
		System.out.println("5- Salir");
		System.out.println("********************");
		
	}
	public static void estructuraRonda(int numpreguntas) throws FileSystemException, IOException {
		int i=0;
		int contador=0;
		Collections.shuffle(GestionJugadores.jug);
		while(contador<numpreguntas*GestionJugadores.jug.size()) {
		for(Jugadores jg:GestionJugadores.jug) {
		System.out.println("La pregunta número "+(i+1)+" es para "+jg.getNombre());
		preguntaMates(preguntaAleatoria(),jg);
		preguntaLengua(preguntaAleatoria(),jg);
		preguntaIngles(preguntaAleatoria(),jg);
		
		}
		}
	GestionHistorico.escribirHistoricio();
	GestionJugadores.jug.clear();
	
	
	}
	public static void preguntaMates(Preguntas pregunta, Jugadores jugador) {
		if(pregunta instanceof PreguntasMates) {
			String cadena = PreguntasMates.generarCadena();
			System.out.println(Constantes.enunciadoMates+"'"+cadena+"'");
		    int respuesta = teclado.nextInt();
			if(jugador instanceof Cpu) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    }else if(jugador instanceof Humanos) {
		    	
		    	if(respuesta==PreguntasMates.solucionCadena(cadena)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    	sumarPuntosSistema(jugador.getNombre());
		    }else if (jugador instanceof Humanos && respuesta!=PreguntasMates.solucionCadena(cadena)) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasMates.solucionCadena(cadena));
		    }
     }
    }
	}
	public static void preguntaLengua(Preguntas pregunta, Jugadores jugador) throws FileSystemException, IOException {
		if(pregunta instanceof PreguntasLengua) {
			String cadena = PreguntasLengua.taparLetra();
			System.out.println(Constantes.enunciadoLengua+"'"+cadena+"'");
			if(jugador instanceof Cpu) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasLengua.cadena);
		    }else if(jugador instanceof Humanos) {
		    	String respuesta = teclado.next();
		    	if(respuesta.equalsIgnoreCase(PreguntasLengua.cadena)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    	sumarPuntosSistema(jugador.getNombre());
		    }else if (!respuesta.equalsIgnoreCase(PreguntasLengua.cadena)) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasLengua.cadena);
		    }
		    }
		    }
	}
	public static void preguntaIngles(Preguntas pregunta, Jugadores jugador) throws FileSystemException, IOException {
		Random rand = new Random();
		if(pregunta instanceof PreguntasIngles) {
			System.out.println(Constantes.enunciadoIngles);
			PreguntasIngles.leerPreguntaIngles();
			String respuesta = PreguntasIngles.respuesta;
			if(jugador instanceof Cpu) {
				int num = rand.nextInt(0,4);
				System.out.println(Constantes.respuestaCPU+(num+1));
				if(PreguntasIngles.pregunta.get(num).equalsIgnoreCase(respuesta)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
				}else {
					System.out.println(Constantes.mensajeRespFallada+respuesta);
				}
				}else if(jugador instanceof Humanos) {
				teclado.nextLine();
				String solucion = teclado.nextLine();
				if(solucion.equalsIgnoreCase(respuesta)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    	sumarPuntosSistema(jugador.getNombre());
				}else if(!solucion.equalsIgnoreCase(respuesta)) {
		    	System.out.println(Constantes.mensajeRespFallada+respuesta);
		    }
	}
		PreguntasIngles.pregunta.clear();
	}
	}
	public static void sumarPuntosSistema(String nombre) {
		for(Humanos hu:GestionJugadores.jugsis) {
			if(hu.getNombre().equalsIgnoreCase(nombre)) {
				hu.setPuntos(hu.puntos+1);
			}
		}
		
	}
}

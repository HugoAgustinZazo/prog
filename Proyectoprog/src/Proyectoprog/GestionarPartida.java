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
	 public static void Partida() throws JugadoresException {
		
	    
		System.out.println("Va a comenzar la partida, primero añade los jugadores a la partida");
		GestionJugadores.añadirJugadores();
		
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
		System.out.println("********************");
		
	}
	public static void estructuraRonda() throws FileSystemException, IOException {
		int i=0;
		Collections.shuffle(GestionJugadores.jug);
		for(Jugadores jg:GestionJugadores.jug) {
		System.out.println("La pregunta número "+(i+1)+" es para "+jg.getNombre());
		preguntaMates(preguntaAleatoria(),jg);
		preguntaLengua(preguntaAleatoria(),jg);
		preguntaIngles(preguntaAleatoria(),jg);
		
		}
	
	
	
	
	}
	public static void preguntaMates(Preguntas pregunta, Jugadores jugador) {
		if(pregunta instanceof PreguntasMates) {
			String cadena = PreguntasMates.generarCadena();
			System.out.println(Constantes.enunciadoMates+"'"+cadena+"'");
		    int respuesta = teclado.nextInt();
			if(jugador instanceof Cpu) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    }else if(jugador instanceof Humanos && respuesta==PreguntasMates.solucionCadena(cadena)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    	sumarPuntosSistema(jugador.getNombre());
		    }else if (jugador instanceof Humanos && respuesta!=PreguntasMates.solucionCadena(cadena)) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasMates.solucionCadena(cadena));
		    }
	}
	}
	public static void preguntaLengua(Preguntas pregunta, Jugadores jugador) throws FileSystemException, IOException {
		if(pregunta instanceof PreguntasLengua) {
			String cadena = PreguntasLengua.taparLetra();
			System.out.println(Constantes.enunciadoLengua+"'"+cadena+"'");
		    String respuesta = teclado.next();
			if(jugador instanceof Cpu) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasLengua.cadena);
		    }else if(jugador instanceof Humanos && respuesta.equalsIgnoreCase(PreguntasLengua.cadena)) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jugador.setPuntos(jugador.puntos+1);
		    	sumarPuntosSistema(jugador.getNombre());
		    }else if (jugador instanceof Humanos && !respuesta.equalsIgnoreCase(PreguntasLengua.cadena)) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasLengua.cadena);
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
				int num = rand.nextInt(1,5);
				System.out.println(Constantes.respuestaCPU+num);
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

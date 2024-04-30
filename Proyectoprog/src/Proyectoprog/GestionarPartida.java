package Proyectoprog;

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
		System.out.println("1- Partida corta(5 rondas)");
		System.out.println("1- Partida normal(10 rondas)");
		System.out.println("1- Partida larga(20 rondas)");
		System.out.println("********************");
		
	}
	public static void estructuraRonda() {
		int i=0;
		Collections.shuffle(GestionJugadores.jug);
		for(Jugadores jg:GestionJugadores.jug) {
		System.out.println("La pregunta número "+(i+1)+" es para "+jg.getNombre());
		if(preguntaAleatoria() instanceof PreguntasMates) {
			String cadena = PreguntasMates.generarCadena();
			System.out.println(Constantes.enunciadoMates+"'"+cadena+"'");
		    int respuesta = teclado.nextInt();
			if(jg instanceof Cpu) {
		    	System.out.println(Constantes.mensajeRespAcertada);
		    	jg.setPuntos(jg.puntos+1);
		    }else if(jg instanceof Humanos && respuesta==PreguntasMates.solucionCadena(cadena)) {
		    	jg.setPuntos(jg.puntos+1);
		    	sumarPuntosSistema(jg.getNombre());
		    }else if (jg instanceof Humanos && respuesta!=PreguntasMates.solucionCadena(cadena)) {
		    	System.out.println(Constantes.mensajeRespFallada+PreguntasMates.solucionCadena(cadena));
		    }
		    
		}if(preguntaAleatoria() instanceof PreguntasLengua) {
			System.out.println(Constantes.enunciadoLengua);
		    
		}if(preguntaAleatoria() instanceof PreguntasIngles) {
			System.out.println(Constantes.enunciadoIngles);
		    
		}
		
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

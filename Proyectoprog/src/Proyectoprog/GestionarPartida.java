package Proyectoprog;

import java.util.ArrayList;
import java.util.Random;

public class GestionarPartida {
	 static ArrayList <Preguntas> preg = new ArrayList();
	public static void Partida() throws JugadoresException {
		
	    /*
		System.out.println("Va a comenzar la partida, primero añade los jugadores a la partida");
		GestionJugadores.añadirJugadores();*/
		
		preg.add(new PreguntasMates(Constantes.enunciadoMates));
		preg.add(new PreguntasIngles(Constantes.enunciadoIngles));
		preg.add(new PreguntasLengua(Constantes.enunciadoLengua));
		

		if(preguntaAleatoria() instanceof PreguntasMates) {
			System.out.println(Constantes.enunciadoMates+"'"+PreguntasMates.generarCadena()+"'");
		    
		}
	}
	
	public static Preguntas preguntaAleatoria(){
		Random random = new Random();
		int num=random.nextInt(preg.size())+0;
		return preg.get(num);
		
	}
	
}

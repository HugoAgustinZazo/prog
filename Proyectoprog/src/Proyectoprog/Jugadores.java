package Proyectoprog;

public abstract class Jugadores {
int puntos;

public Jugadores(int puntos) {
	super();
	this.puntos = 0;
}
public abstract void mostrarInformacion();

public String toStringg() {
	String jugadores="";
	for(Jugadores jg:GestionJugadores.jug) {
		 jugadores = jg+" ";
	}
	return jugadores;
	
	}

}

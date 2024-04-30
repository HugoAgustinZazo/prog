package Proyectoprog;

public abstract class Jugadores {
int puntos;
String nombre;
public Jugadores(String nombre) {
	super();
	this.nombre=nombre;
	this.puntos = 0;
}
public abstract void mostrarInformacion();
public int getPuntos() {
	return puntos;
}
public void setPuntos(int puntos) {
	this.puntos = puntos;
}
public String getNombre() {
	return nombre;
}
}

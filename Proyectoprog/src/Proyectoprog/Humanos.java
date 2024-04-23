package Proyectoprog;

public class Humanos{
	private final String nombre;
	int puntos;
	public Humanos(String nombre) {
		this.nombre=nombre;
		this.puntos=0;
		
	}
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

package Proyectoprog;

public class Humanos extends Jugadores{
	public Humanos(String nombre, int puntos) {
		super(nombre);
		this.nombre = nombre;

	}

	@Override
	public void mostrarInformacion() {
		System.out.println(this.nombre+" "+this.puntos);
	}

	@Override
	public String toString() {
		return this.nombre+" "+this.puntos;
	}

}

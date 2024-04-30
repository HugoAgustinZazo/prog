package Proyectoprog;

public class Cpu extends Jugadores{
	public Cpu( String nombre) {
		super(nombre);
		this.nombre=nombre;

	}

	@Override
	public void mostrarInformacion() {
		System.out.println(this.nombre+" "+this.puntos);
		
	}
	public String toString() {
		return this.nombre+" "+this.puntos;
	}

}

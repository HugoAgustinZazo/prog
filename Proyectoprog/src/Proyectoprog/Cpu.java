package Proyectoprog;

public class Cpu extends Jugadores{
	static int puntos;
	String nombre;
	public Cpu( String nombre) {
		super(puntos);
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

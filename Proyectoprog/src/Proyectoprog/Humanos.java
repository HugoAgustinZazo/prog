package Proyectoprog;

public class Humanos extends Jugadores{
	static int puntos;
	private final String nombre;
	public Humanos(String nombre) {
		super(puntos);
		this.nombre = nombre;

	}

	@Override
	public void mostrarInformacion() {
		System.out.println(this.nombre+" "+this.puntos);
	}

	public static int getPuntos() {
		return puntos;
	}

	public static void setPuntos(int puntos) {
		Humanos.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

}

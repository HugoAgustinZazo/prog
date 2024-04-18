package Tema8;

public class ExcepcionNombre extends Exception{
	private String nombre;
	public ExcepcionNombre(String nombre) {
		this.nombre=nombre;
	}
	@Override
	public String toString() {
		return "ExcepcionNombre [" + nombre + "]";
	}
	
}

package Tema8;

public class ExcepcionEdad extends Exception{
private int edad;
	public ExcepcionEdad(int edad) {
		this.edad=edad;
	}
	@Override
	public String toString() {
		return "ExcepcionEdad [" + edad + "]";
	}
	
}

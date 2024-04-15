package Tema8;

public class Gato {
	String nombre;
	int edad;
	
	public Gato(String gato, int edad)throws Exception {
		if (gato.length()<3) {
			throw new Exception("El nombre no puede tener menos de tres letras");
		}else 
			this.nombre=gato;
		if(edad<0) {
			throw new Exception("La edad no puede ser negativa");
		}else 
			this.edad=edad;
	}
	
	public void imprimir() {
		System.out.println("Nombre:"+nombre+"\nEdad:"+edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre)throws Exception {
		if (nombre.length()<3) {
			throw new Exception("El nombre no puede tener menos de tres letras");
		}else
			this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad)throws Exception{
		if(edad<0) {
			throw new Exception("La edad no puede ser negativa");
		}else 
			this.edad = edad;
	}

}

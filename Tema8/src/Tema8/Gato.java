package Tema8;

public class Gato {
	String nombre;
	int edad;
	
	public Gato(String gato, int edad)throws Exception {

		this.nombre=gato;
		this.edad=edad;
	}
	
	public void imprimir() {
		System.out.println("Nombre:"+nombre+"\nEdad:"+edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre)throws Exception {
		
			this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad)throws Exception{
		 
			this.edad = edad;
	}

}

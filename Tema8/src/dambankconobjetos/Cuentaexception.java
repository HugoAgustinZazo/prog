package dambankconobjetos;

public class Cuentaexception extends Exception{
	private String mensaje;
	public Cuentaexception(String mensaje){
		this.mensaje=mensaje;
	}
	@Override
	public String toString() {
		return "Cuentaexception [mensaje=" + mensaje + "]";
	}
	
	

}

package dambankconobjetos;

public class CuentaException extends Exception{
	private String mensaje;
	public CuentaException(String mensaje){
		this.mensaje=mensaje;
	}
	@Override
	public String toString() {
		return "Cuentaexception [mensaje=" + mensaje + "]";
	}
	
	
}

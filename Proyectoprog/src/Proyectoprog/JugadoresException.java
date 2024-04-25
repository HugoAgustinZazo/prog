package Proyectoprog;

public class JugadoresException extends Exception{
	private String mensaje;

	public JugadoresException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Este nombre esta ya en uso:" + mensaje;
	}
	
}

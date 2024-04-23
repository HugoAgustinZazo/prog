package dambankconobjetos;

public class Avisarhacienda extends Exception{
	private String iban;
	private Persona titular;
	private final String tipo="ingreso";
	public Avisarhacienda(String iban, Persona titular) {
		super();
		this.iban = iban;
		this.titular = titular;

	}
	@Override
	public String toString() {
		return "AvisarHacienda [iban=" + iban + ", titular=" + titular + ", tipo=" + tipo + "]";
	}

}

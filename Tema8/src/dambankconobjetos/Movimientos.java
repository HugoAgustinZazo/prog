package dambankconobjetos;

public class Movimientos {

	String ibanOrigen;
	String fechaIngreso;
	//LocalDateTime fechaIngreso_v1;
	Float cantidad;
	String concepto;
	
	
	public Movimientos(String ibanOrigen, String fechaIngreso, Float cantidad, String concepto) {
		super();
		this.ibanOrigen = ibanOrigen;
		this.fechaIngreso = fechaIngreso;
		this.cantidad = cantidad;
		this.concepto = concepto;
	}

	public String getIbanOrigen() {
		return ibanOrigen;
	}

	public void setIbanOrigen(String ibanOrigen) {
		this.ibanOrigen = ibanOrigen;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	@Override
	public String toString() {
		System.out.println();
		return "Movimientos [ibanOrigen=" + ibanOrigen + ", fechaIngreso=" + fechaIngreso + ", cantidad=" + cantidad
				+ ", concepto=" + concepto + "]";
	}
}

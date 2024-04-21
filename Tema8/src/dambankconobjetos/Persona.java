package dambankconobjetos;

public class Persona {
	private final String dni;
    private String nombre;
    private String apellidos;
    private String domicilio;
     

	public Persona(String dni, String nombre, String apellidos, String domicilio) {
		if (validarDNI(dni)) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.domicilio = domicilio;
		} else {
			System.out.println("ERROR EN EL FORMATO DEL DNI");
			this.dni="00000000A";
			this.nombre = "XYZ";
			this.apellidos = "XYZ";
			this.domicilio = "XYZ";
		}
	}

	private String getNombre() {
        return nombre;
    }

    private String getApellidos() {
        return apellidos;
    }

    private String getDni() {
        return dni;
    }

    private String getDomicilio() {
        return domicilio;
    }

   

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    private void setdomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
 
    
    
    
    public void mostrarInfoPersona() {
    	System.out.print(this.nombre + " " + this.getApellidos()
		+ " CON DNI " + getDni() + " CON DOMICILIO: " + this.getDomicilio());
	 
    }
    
    public static boolean validarDNI(String dni) {
    	
    	if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
			return false;
		}
		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				return false;
			}
		}

		return true;
}
}

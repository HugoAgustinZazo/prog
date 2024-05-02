package Proyectoprog;/*
import net.objecthunter.exp4j.*;*/
import java.util.Random;

public class PreguntasMates extends Preguntas{

	public PreguntasMates(String enunciado) {
		super(enunciado);
		this.pregunta= enunciado;
	}
	static Random random = new Random();
	@Override
	public void mostrarRespuesta() {
		// TODO Auto-generated method stub
	
	}
	public static String generarCadena() {
		StringBuilder sb = new StringBuilder(random.nextInt(9)+7);
	    int contador=0;
		int num = random.nextInt(11)+2;
        Integer.toString(num);
        sb.append(num);
    
		while(contador<=random.nextInt(9)+5) {    
            sb.append(operacionAleatoria());
            contador++;
            int num2 = random.nextInt(11)+2;
            Integer.toString(num2);
            sb.append(num2);
            contador++;
            }
		
		String cadenamates = sb.toString();
		return cadenamates;
	}
	public static char operacionAleatoria() {
		Random random = new Random();
		char[]operacion= {'*','-','+'};
		return operacion[random.nextInt(3)+0];
	}
	public static int solucionCadena(String cadena) {
		int solucion = 0;
	
		
		return 0;
	}
}

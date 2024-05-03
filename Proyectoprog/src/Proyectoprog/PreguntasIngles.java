package Proyectoprog;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PreguntasIngles extends Preguntas{
static String enunciado;	
static String respuesta;
	public PreguntasIngles(String enunciado) {
		super(enunciado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mostrarRespuesta() {
		// TODO Auto-generated method stub
		
	}
	static ArrayList<String> pregunta = new ArrayList();
	public static void leerPreguntaIngles() throws FileSystemException,IOException  {
		String nombrearchivo="src/Ficheros/ingles.txt";
		Path rutafichero=Paths.get(nombrearchivo);
		ArrayList<String> ingles = new ArrayList();		
		long num=0;
		try {
		ingles = (ArrayList<String>)Files.readAllLines(rutafichero);
		Random random = new Random();
		 num = random.nextLong(0,ingles.size()/5);
		 String pregunta1=ingles.get((int)num*5);
		 enunciado=pregunta1; 
		 for(int i=0;i<4;i++) {
			 pregunta.add(ingles.get((int)num*5+(i+1)));
		 }
		 respuesta=pregunta.get(0);
		 Collections.shuffle(pregunta);
		 System.out.println(enunciado);
		 int i=1;
		 for(String pg:pregunta) {	 
		 System.out.println(i+") "+pg);
		 i++;
			}
		 
		}catch (NoSuchFileException e) {
			System.err.println("Ese fichero no existe");
		}catch (FileSystemException e) {
			System.err.println("Excepcion de sistema de ficheros " + e);
		}catch(IOException e) {
			e.printStackTrace();	
}
	
		}
}

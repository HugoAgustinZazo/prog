package Proyectoprog;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class PreguntasLengua extends Preguntas{
static String cadena;
	
	public PreguntasLengua(String enunciado) {
		super(enunciado);
	this.pregunta=enunciado;
	}

	@Override
	public void mostrarRespuesta() {
		// TODO Auto-generated method stub
		
	}
	public static String leerPalabras() throws FileSystemException,IOException  {
		String nombrearchivo="src/Ficheros/diccionario.txt";
		Path rutafichero=Paths.get(nombrearchivo);
		ArrayList<String> palabras = new ArrayList();
		long num=0;
		try {
		palabras = (ArrayList<String>)Files.readAllLines(rutafichero);
		Random random = new Random();
		 num = random.nextLong(0,85220);
		}catch (NoSuchFileException e) {
			System.err.println("Ese fichero no existe");
		}catch (FileSystemException e) {
			System.err.println("Excepcion de sistema de ficheros " + e);
		}catch(IOException e) {
			e.printStackTrace();
		
}
		return palabras.get((int) num);
}
	public static String taparLetra() throws FileSystemException, IOException {
		Random random = new Random();
		String palabra = leerPalabras();
		cadena=palabra;
		int contador=0;
		String palabracambiada="";
		char[]letras=new char[palabra.length()];
		for(int i=0;i<palabra.length();i++) {
			letras[i]=palabra.charAt(i);
		}
		while(contador<palabra.length()/3) {
			int num = random.nextInt(0,palabra.length()-1);
			if(letras[num]!='*') {
			letras[num]='*';
			contador++;
			}
			}
		for(int i=0;i<letras.length;i++) {
		palabracambiada=palabracambiada+letras[i];
		}
		return palabracambiada;
	}
	
}

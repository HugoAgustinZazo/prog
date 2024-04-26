package Proyectoprog;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionHistorico {
	public static void escribirHistoricio() {
		try {
			String humano="";
			for(Jugadores hu:GestionJugadores.jug) {
			 humano = humano+hu.toString()+" ";
			}List<String> linesToAdd = Arrays.asList(humano);
			Files.write(Paths.get("src/Ficheros/Historico.txt"), linesToAdd, StandardOpenOption.APPEND);
		 } catch (IOException e) {
		 System.err.println("Ocurrió un error al escribir en el archivo: " +
		e.getMessage());
		 }
		 
}
	
	public static void leerHistorico() throws FileSystemException,IOException  {
			String nombrearchivo="src/Ficheros/Historico.txt";
			Path rutafichero=Paths.get(nombrearchivo);
			try {
			ArrayList<String> lineas = (ArrayList<String>)Files.readAllLines(rutafichero);
			for(String linea : lineas){
				System.out.println(linea);
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

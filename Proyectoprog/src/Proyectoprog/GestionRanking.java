package Proyectoprog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class GestionRanking {
	
	public static List<Humanos> leerRanking(String nombreArchivo) {
		 Path path = Paths.get(nombreArchivo);
		 
		 try {
		 List<String> lineas = Files.readAllLines(path);
		 for (String linea : lineas) {
		 String[] partes = linea.split(" ");
		 String nombre = partes[0];
		 int puntos = Integer.parseInt(partes[1]);
		 GestionJugadores.jugsis.add(new Humanos(nombre,puntos));
		
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return GestionJugadores.jugsis;
		 }
	public static void escribirRanking() {
			try {
				for(Humanos hu:GestionJugadores.jugsis) {
				String humano = hu.toString();	
				List<String> linesToAdd = Arrays.asList(humano);
				Files.write(Paths.get("src/Ficheros/Ranking.txt"), linesToAdd, StandardOpenOption.APPEND);
			}
			 } catch (IOException e) {
			 System.err.println("Ocurrió un error al escribir en el archivo: " +
			e.getMessage());
			 }
			 
	}
	public static void eliminarJugador() {
		
	}
}

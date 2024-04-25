package Proyectoprog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class GestionHistorico {
	public static void escribirRanking() {
		try {
			
			for(Jugadores hu:GestionJugadores.jug) {
			 String humano = hu.toString();
			 List<String> linesToAdd = Arrays.asList(humano);
			Files.write(Paths.get("src/Ficheros/Historico.txt"), linesToAdd, StandardOpenOption.APPEND);
			}
		 } catch (IOException e) {
		 System.err.println("Ocurrió un error al escribir en el archivo: " +
		e.getMessage());
		 }
		 
}
}

package Ficheros;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cancionnn {
public static List <Cancion> leercanciones(String nombrearchivo){
	Path path=Paths.get(nombrearchivo);
	List <Cancion> canciones = new ArrayList<>();
	try {
		List <String> lineas = Files.readAllLines(path);
		for(String linea:lineas) {
			String[] partes = linea.split(":");
			int identificador = Integer.parseInt(partes[0]);
			String nombre=partes[1];
			String nombreartista = partes[2];
			long segundos = Integer.parseInt(partes[3]);
			Cancion cancion = new Cancion(identificador,nombre,nombreartista,segundos);
			canciones.add(cancion);
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return canciones;
}
	public static void main(String[] args) {
		List <Cancion> canciones =  leercanciones("src/Ficheros/canciones.txt");
			for(Cancion cancion:canciones) {
				System.out.println(cancion);
			}

	}
}

package Tema9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EjemploNIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Path path = Paths.get("src/demo.txt");
			Path path1 = Paths.get("src/ficheros/demo.txt");
			
			String contenido = "Hola, este es un ejemplo de escritura!";
			try {
			Files.write(path, contenido.getBytes(),StandardOpenOption.APPEND);
			Files.write(path1, contenido.getBytes(),StandardOpenOption.APPEND);
			
			System.out.println("Archivo creado y escrito satisfactoriamente.");
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
	}



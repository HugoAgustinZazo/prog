package Proyectoprog;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.Scanner;

public class Mainproyecto {

	public static void main(String[] args) throws JugadoresException, FileSystemException, IOException {
		// TODO Auto-generated method stub	
		Scanner teclado = new Scanner(System.in);
		boolean salir = false;
		int opcion=999;
		while(!salir) {
			menu();
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				GestionarPartida.rellenarArrayPreguntas();
				GestionarPartida.Partida();
				GestionarPartida.preg.clear();
				break;
			case 2:
				GestionRanking.leerRanking(Constantes.rutaRanking);
				for (Humanos hu: GestionJugadores.jugsis) {
					System.out.println(hu);
				}
				break;
			case 3:
				GestionHistorico.leerHistorico();
				break;
			case 4:
				GestionJugadores.subMenuJugadores();
				break;
			case 5:
				salir = true;
				break;
			default:
				System.out.println("Esa opción no existe");
				break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("********MENU********");
		System.out.println("1- Jugar partida");
		System.out.println("2- Ranking");
		System.out.println("3- Historico");
		System.out.println("4- Jugadores");
		System.out.println("5- Salir");
		System.out.println("********************");
	}

}

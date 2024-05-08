package Proyectoprog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GestionLog {
	static final String jugadorañadido="Jugador añadido a la partida: ";
	static final String jugadoreliminado="Jugador eliminado del sistema: ";
	static final String error="Se ha producido un error en la aplicación";
	static final String  jugsistema="Se ha añadido un jugador al sistema: ";
	static final String ganador=" ha ganado la partida !!Enhorabuena";
	
	public static void escribirLogInicioPartida(int numjugadores, int numcpu) throws IOException {
		String c_partida = getFechaActual()+" Comienza la partida con "+numjugadores+" jugador/es humanos y "+numcpu+" CPU";
		Files.write(Paths.get(Constantes.rutaLog),c_partida.getBytes(), StandardOpenOption.APPEND);
	}
	
	public static void escribirMensajesSencillos(String mensajesencillo) throws IOException {
		String mensaje=getFechaActual()+" "+mensajesencillo;
		Files.write(Paths.get(Constantes.rutaLog),mensaje.getBytes(), StandardOpenOption.APPEND);	
	}
	
	public static String getFechaActual() {
		LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fecha.format(fechaFormateada);
	}
}

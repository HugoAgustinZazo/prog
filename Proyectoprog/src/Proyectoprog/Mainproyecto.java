package Proyectoprog;

public class Mainproyecto {

	public static void main(String[] args) throws JugadoresException {
		// TODO Auto-generated method stub

/*GestionJugadores.añadirJugadores();
GestionHistorico.escribirRanking();

GestionJugadores.mostrarArray();
*/
GestionJugadores.añadirJugadoresSistema();
GestionRanking.escribirRanking();
GestionJugadores.añadirJugadoresSistema();

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

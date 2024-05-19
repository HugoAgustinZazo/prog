package basedatos;

import java.util.Scanner;

public class MainBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		PintaMenus.pintaMenu();
		int opc = teclado.nextInt();
		while (opc != 5) {
				
			switch (opc) {
			case 1:
				PintaMenus.pintaMenuSelect();
				opc=teclado.nextInt();
				GestionBBDD.seleccion(opc);
				break;
			case 2:
				PintaMenus.pintaMenuInsert();
				opc=teclado.nextInt();
				break;
			case 3:
				PintaMenus.pintaMenuUpdate();
				opc=teclado.nextInt();
				break;	
			case 4:
				PintaMenus.pintaMenuDelete();
				opc=teclado.nextInt();
				break;
			
			}
			PintaMenus.pintaMenu();
			opc=teclado.nextInt();
			
		} 	
		
		
		System.out.println("FIN DEL PROGRAMA");
		
/*		Dbmanager.loadDriver();
		Dbmanager.connect();
		Dbmanager.close();
	*/	
	}

	
}

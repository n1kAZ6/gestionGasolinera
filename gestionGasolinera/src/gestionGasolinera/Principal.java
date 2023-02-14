package gestionGasolinera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Repostaje>baseDatosNormal = new ArrayList<>();
		List<Repostaje>baseDatosFactura = new ArrayList<>();

		Repostaje reposFactura = new Repostaje();
		Repostaje reposNormal = new Repostaje();

		Scanner scan = new Scanner(System.in);
		boolean cerrarMenu=false;
		int opcion;
		do {
			mostrarMenu();
			System.out.println("Introduza la opción deseada: ");
			opcion=scan.nextInt();
			System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

			switch(opcion) {
				case 1:
					baseDatosNormal=reposNormal.repostajeNormal(baseDatosNormal);
					break;
				case 2:
					baseDatosFactura=reposFactura.repostajeFactura(baseDatosFactura);
					break;
				case 3:
					reposFactura.verRepostajes(baseDatosNormal,baseDatosFactura);
					break;
				case 4:
					String eliminarRepostaje=JOptionPane.showInputDialog("Cual repostaje quiere eliminar normal o con factura (n/f): ");
					if(eliminarRepostaje.equalsIgnoreCase("n")) 
						baseDatosNormal = reposNormal.eliminarRepostajeNormal(baseDatosNormal);
					else if(eliminarRepostaje.equalsIgnoreCase("f")) 
						baseDatosFactura = reposFactura.eliminarRepostajeFactura(baseDatosNormal);
					else
						System.err.println("No ha introducido repostaje con factura o normal (f/n)");
					break;
				case 5:
					break;
				case 6:
					cerrarMenu=true;
					break;
				default:
					System.err.println("**Error: opción elegida no disponible");
					break;
			}
					
		}while(!cerrarMenu);
		System.out.println("Desconectando, Gracias por su confianza en nuestra gasolinera!");
	}
	static void mostrarMenu() {
		System.out.println("\n1. Repostaje normal");
		System.out.println("2. Repostaje factura");
		System.out.println("3. Ver todos los repostajes");
		System.out.println("4. Eliminar los repostajes");
		System.out.println("5. Modificar un repostaje");
		System.out.println("6. Salir");
	}

}

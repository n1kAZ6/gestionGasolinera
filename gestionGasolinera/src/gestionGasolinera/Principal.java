package gestionGasolinera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Repostaje>listaBaseDatos = new ArrayList<>();
		Repostaje reposFactura = new Repostaje();
		Repostaje reposNormal = new Repostaje();

		Scanner scan = new Scanner(System.in);
		boolean cerrarMenu=false;
		int opcion;
		do {
			mostrarMenu();
			opcion=scan.nextInt();
			System.out.println("Introduza la opción deseada: ");
			System.out.println("[INFO] - Has seleccionado la opcion " + opcion);

			switch(opcion) {
				case 1:
					listaBaseDatos=reposNormal.repostajeNormal(listaBaseDatos);
					break;
				case 2:
					listaBaseDatos=reposFactura.repostajeFactura(listaBaseDatos);
					break;
				case 3:
					reposFactura.verRepostajes(listaBaseDatos);
					break;
				case 4:
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
		System.out.println("\n2. Repostaje factura");
		System.out.println("\n3. Ver todos los repostajes");
		System.out.println("\n4. Salir");
	}

}

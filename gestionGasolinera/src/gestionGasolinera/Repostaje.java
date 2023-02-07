package gestionGasolinera;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Repostaje {

	//Constructor
	public Repostaje(double importeTotal, String dniCliente, String matriculaVehiculoCliente,double litrosRepostados, LocalDate fechaActual) {
		super();
		this.importeTotal = importeTotal;
		this.dniCliente = dniCliente;
		this.matriculaVehiculoCliente = matriculaVehiculoCliente;
		this.fechaRepostaje = fechaActual;
		this.litrosRepostados = litrosRepostados;
	}

	public Repostaje() {
		super();
	}


	//Atributos
	private double litrosRepostados;	
	private double importeTotal;
	private String dniCliente; 
	private String matriculaVehiculoCliente;
	private LocalDate fechaRepostaje =  LocalDate.now();
	
	//Getter and setter
	public LocalDate getFechaActual() {
		return fechaRepostaje;
	}
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getMatriculaVehiculoCliente() {
		return matriculaVehiculoCliente;
	}
	public void setMatriculaVehiculoCliente(String matriculaVehiculoCliente) {
		this.matriculaVehiculoCliente = matriculaVehiculoCliente;
	}
	public double getLitrosRepostados() {
		return litrosRepostados;
	}

	public void setLitrosRepostados(double litros) {
		this.litrosRepostados = litros;
	}
	public void setFechaActual(LocalDate fechaActual) {
		this.fechaRepostaje = fechaActual;
	}

	//Sobre escritura toString
	@Override
	public String toString() {
		return "Repostaje [litrosRepostados=" + litrosRepostados + ", importeTotal=" + importeTotal + ", dniCliente="
				+ dniCliente + ", matriculaVehiculoCliente=" + matriculaVehiculoCliente + ", fechaActual=" + fechaRepostaje
				+ "]";
	}
	
	//Métodos
	
	public List<Repostaje> repostajeNormal(List<Repostaje>listaBaseDatos) {
		
		double litrosArepostar, importe;
		Scanner scan = new Scanner(System.in);
		int tipoGasolina;
		

		tipoGasolina=elegirTipoGasolina();
		if(tipoGasolina==1) {
			System.out.println("El precio del litro sin plomo 95 es 1.65€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.65;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("El precio del litro sin plomo 98 es 1.85€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.85;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f",importe);
		} else {
			System.out.println("El precio del litro de diesel es 1.70€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.65;
			System.out.print("El importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f",importe);
		}
		System.out.println("\nGracias, repostaje finalizado.");

		Repostaje repostajeNormal = new Repostaje();
		
		repostajeNormal.setFechaActual(fechaRepostaje);
		repostajeNormal.setLitrosRepostados(litrosArepostar);
		repostajeNormal.setImporteTotal(importe);
		
		listaBaseDatos.add(repostajeNormal);
		return listaBaseDatos;
	}
	

	public List<Repostaje> repostajeFactura(List<Repostaje>listaBaseDatos) {
		String dniCliente, matricula;
		double litrosArepostar, importe;
		Scanner scan = new Scanner(System.in);
		int tipoGasolina;
		
		
		System.out.println("Introduzca su DNI: ");
		dniCliente=scan.nextLine();
		System.out.println("Introduzca la matricula del vehículo: ");
		matricula=scan.nextLine();
		
		tipoGasolina=elegirTipoGasolina();
		if(tipoGasolina==1) {
			System.out.println("El precio del litro sin plomo 95 es 1.65€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.65;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("El precio del litro sin plomo 98 es 1.85€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.85;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f",importe);
		} else {
			System.out.println("El precio del litro de diesel es 1.70€");
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*1.65;
			System.out.print("El importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f",importe);
		}
		
		System.out.println("\nGracias, repostaje finalizado.");
		Repostaje repostajeConFactura = new Repostaje();
		repostajeConFactura.setDniCliente(dniCliente);
		repostajeConFactura.setImporteTotal(importe);
		repostajeConFactura.setMatriculaVehiculoCliente(matricula);
		repostajeConFactura.setLitrosRepostados(litrosArepostar);
		repostajeConFactura.setFechaActual(fechaRepostaje);
		
		listaBaseDatos.add(repostajeConFactura);
		
		return listaBaseDatos;
	
	}
	public void verRepostajes(List<Repostaje>baseDatosRepostaje) {
		for(Repostaje bd: baseDatosRepostaje) {
			System.out.println(bd);
		}
		
	}
	public int elegirTipoGasolina() {
			
			Scanner scan = new Scanner(System.in);
			int tipoGasolina;
			do {
				System.out.println("\nQue tipo de gasolina desea repostar?");
				System.out.println("\n1. sin plomo 95");
				System.out.println("\n2. sin plomo 98");
				System.out.println("\n3. Diesel");
				tipoGasolina=scan.nextInt();
				
				if(tipoGasolina<1||tipoGasolina>3)
					System.err.println("**Error: no se reconoce la gasolina seleccionada **");
			}while(tipoGasolina<1||tipoGasolina>3);
			
			return tipoGasolina;
	
	}
	
	
}

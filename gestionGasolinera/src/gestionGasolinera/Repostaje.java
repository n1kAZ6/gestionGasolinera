package gestionGasolinera;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Repostaje {


	//Atributos
	private double litrosRepostados;	
	private double importeTotal;
	private String dniCliente; 
	private String matriculaVehiculoCliente;
	private LocalDate fechaRepostaje =  LocalDate.now();
	private double precioLitro95=1.65;
	private double precioLitro98=1.85;
	private double precioLitroDiesel=1.70;
	private int identificador;

	//Constructores
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
	public double getPrecioLitro95() {
		return precioLitro95;
	}

	public void setPrecioLitro95(double precioLitro95) {
		this.precioLitro95 = precioLitro95;
	}

	public double getPrecioLitro98() {
		return precioLitro98;
	}

	public void setPrecioLitro98(double precioLitro98) {
		this.precioLitro98 = precioLitro98;
	}

	public double getPrecioLitroDiesel() {
		return precioLitroDiesel;
	}

	public void setPrecioLitroDiesel(double precioLitroDiesel) {
		this.precioLitroDiesel = precioLitroDiesel;
	}
	public int getIdentidicador() {
		return identificador;
	}
	public void SetIdentidicador(int id) {
		this.identificador=id;
	}

	//Sobre escritura toString
	@Override
	public String toString() {
		return "Repostaje [ id="+ identificador+", litrosRepostados=" + litrosRepostados + ", importeTotal=" + importeTotal + ", dniCliente="
				+ dniCliente + ", matriculaVehiculoCliente=" + matriculaVehiculoCliente + ", fechaActual=" + fechaRepostaje
				+ "]";
	}
	
	//Métodos
	
	public List<Repostaje> repostajeNormal(List<Repostaje>baseDatosNormal) {
		
		double litrosArepostar, importe;
		Scanner scan = new Scanner(System.in);
		int tipoGasolina;
		

		tipoGasolina=elegirTipoGasolina();
		if(tipoGasolina==1) {
			System.out.println("El precio del litro sin plomo 95 es "+precioLitro95);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro95;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("El precio del litro sin plomo 98 es "+ precioLitro98);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro98;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f",importe);
		} else {
			System.out.println("El precio del litro de diesel es "+precioLitroDiesel);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitroDiesel;
			System.out.print("El importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f",importe);
		}
		System.out.println("\nGracias, repostaje finalizado.");

		Repostaje repostajeNormal = new Repostaje();
		
		if(baseDatosNormal.size()==0)
			repostajeNormal.SetIdentidicador(1);
		else {
			repostajeNormal.SetIdentidicador(baseDatosNormal.size()+1);;
		}
		repostajeNormal.setFechaActual(fechaRepostaje);
		repostajeNormal.setLitrosRepostados(litrosArepostar);
		repostajeNormal.setImporteTotal(importe);
		
		baseDatosNormal.add(repostajeNormal);
		return baseDatosNormal;
	}
	

	public List<Repostaje> repostajeFactura(List<Repostaje>baseDatosFactura) {
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
			System.out.println("El precio del litro sin plomo 95 es "+precioLitro95);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro95;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 95 es ");
			System.out.printf("%1.2f",importe);
			
		}else if(tipoGasolina==2) {
			System.out.println("El precio del litro sin plomo 98 es "+precioLitro98);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*precioLitro98;
			System.out.print("El importe total de "+litrosArepostar+" litros de sin plomo 98 es ");
			System.out.printf("%1.2f",importe);
		} else {
			System.out.println("El precio del litro de diesel es "+precioLitroDiesel);
			System.out.println("¿Cuantos litros quiere repostar?");
			litrosArepostar=scan.nextDouble();
			importe=litrosArepostar*+precioLitroDiesel;
			System.out.print("El importe total de "+litrosArepostar+" litros de diesel es ");
			System.out.printf("%1.2f",importe);
		}
		
		System.out.println("\nGracias, repostaje finalizado.");
		Repostaje repostajeConFactura = new Repostaje();
		if(baseDatosFactura.size()==0)
			repostajeConFactura.SetIdentidicador(1);
		else {
			repostajeConFactura.SetIdentidicador(baseDatosFactura.size()+1);;
		}
		repostajeConFactura.setDniCliente(dniCliente);
		repostajeConFactura.setImporteTotal(importe);
		repostajeConFactura.setMatriculaVehiculoCliente(matricula);
		repostajeConFactura.setLitrosRepostados(litrosArepostar);
		repostajeConFactura.setFechaActual(fechaRepostaje);
		
		baseDatosFactura.add(repostajeConFactura);
		
		return baseDatosFactura;
	
	}
	public void verRepostajes(List<Repostaje>baseDatosNormal,List<Repostaje>baseDatosFactura) {
		String opcionRepostaje=JOptionPane.showInputDialog("Ver repostaje normal o con factura (n/f): ");
		if(opcionRepostaje.equalsIgnoreCase("n")) {
			if(baseDatosNormal.size()>0) {
				for(int i=0;i<baseDatosNormal.size();i++) 
					System.out.println(baseDatosNormal.get(i));			
			}
			else 
				System.out.println("No hay datos de repostajes que mostrar");
		}
		else if(opcionRepostaje.equalsIgnoreCase("f")) {
			if(baseDatosNormal.size()>0) {
				for(int i=0;i<baseDatosNormal.size();i++) 
					System.out.println(baseDatosFactura.get(i));			
			}
			else 
				System.out.println("No hay datos de repostajes que mostrar");
		}
		else
			System.err.println("No ha introducido repostaje con factura o normal (f/n)");
		
	}
	private int elegirTipoGasolina() {
			
			Scanner scan = new Scanner(System.in);
			int tipoGasolina;
			do {
				System.out.println("\nQue tipo de gasolina desea repostar?");
				System.out.println("1. sin plomo 95");
				System.out.println("2. sin plomo 98");
				System.out.println("3. Diesel");
				tipoGasolina=scan.nextInt();
				
				if(tipoGasolina<1||tipoGasolina>3)
					System.err.println("**Error: no se reconoce la gasolina seleccionada **");
			}while(tipoGasolina<1||tipoGasolina>3);
			
			return tipoGasolina;	
	}
	public List<Repostaje> eliminarRepostajeNormal (List<Repostaje>baseDatosNormal){
		
		int idAeliminar, contadorPosicion=0;
		boolean idExiste=false;
		System.out.println("--- Mostrando base de datos Repostaje normal ---");
		for(Repostaje registro:baseDatosNormal) {
			System.out.println(registro);
		}
		idAeliminar=Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del repostaje a eliminar: "));
		
		for(Repostaje registro:baseDatosNormal) {
			int idBaseDato = registro.getIdentidicador();
			if(idBaseDato==idAeliminar) {
				idExiste=true;
				break;
			}
			contadorPosicion++;
		}
		if(!idExiste)
			System.out.println("El registro con id "+ idAeliminar +" no se encuentra en la base de datos ");
		else {
			System.out.println("Repostaje elimnado correctamente");
			baseDatosNormal.remove(contadorPosicion);			
		}
		return baseDatosNormal;
	}
	public List<Repostaje> eliminarRepostajeFactura (List<Repostaje>baseDatosFactura){
		int idAborrar, contadorPosicion=0;
		boolean idExiste=false;
		System.out.println("--- Mostrando los Repostaje con factura  ---");
		for(Repostaje registro:baseDatosFactura) {
			System.out.println(registro);
		}		
		idAborrar=Integer.parseInt(JOptionPane.showInputDialog("Introduce el id del repostaje a eliminar: "));

		for(Repostaje registro:baseDatosFactura) {
			int idBaseDato = registro.getIdentidicador();
			if(idBaseDato==idAborrar) {
				idExiste=true;
				break;
			}
			contadorPosicion++;
		}
		if(!idExiste)
			System.out.println("El registro con id "+ idAborrar +" no se encuentra en la base de datos ");
		else {
			System.out.println("Repostaje elimnado correctamente");
			baseDatosFactura.remove(contadorPosicion);
		}
			
		
		return baseDatosFactura;
	}
	
	
}

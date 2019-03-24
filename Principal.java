package planificador;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal{
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);    		//Lectura de datos
		ArrayList<Integer> ids = new ArrayList<Integer>(0); //arreglo de IDS 
		Menu menu1 = new Menu();
		Cola colaProcesosListos = new Cola();
		int pid = 30980,masProcesos=1;						//pid corresponde al ID que le damos por defecto
		System.out.println("SYSTEMA DE PROCESOS");

		do{
			masProcesos = menu1.menu("1.-Crear Proceso\n2.-Calcular\n3.-Imprimir procesos \n4.-Salir",4);
			switch(masProcesos){
				case 1: 
					Proceso proceso = new Proceso (pid);
					System.out.println("\nCola de procesos listos");
					System.out.println("=======================================================================================================================");
					colaProcesosListos.addCola(proceso);
                                        colaProcesosListos.printCola();
					System.out.println("=======================================================================================================================");
					ids.add(pid);      //lista de Keys con los IDs
					pid++;
					break;
				case 2:
					if (colaProcesosListos.statusCola()>0){ //si ya se ingreso algun proceso
						RoundRobin.startCPU(colaProcesosListos); 
					}else{
						System.out.println("No hay procesos aun...");
					}
					break;
				case 3:
					//solo imprime las entradas
					System.out.println("=======================================================================================================================");
					colaProcesosListos.printCola();
					System.out.println("=======================================================================================================================");
					ColaRAM prueba =new ColaRAM();
					prueba.printMemory();
					break;
				case 4:
					System.out.println("system closed...");
					break;
				default:
					System.out.println("Entrada no valida");
					break;
			}
		}while(masProcesos != 4);


		//proceso.printData(ids);

	}
}
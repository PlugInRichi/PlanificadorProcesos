package planificador;
import java.util.ArrayList;
import java.util.Collections;


public class ColaRAM extends Cola{ //esta clase es hija de Cola, por lo tanto herada todos sus metodos
	private int tamanioRAM = 1000;
	private int espacioRAM = tamanioRAM; //espacio asignado por nosotros
	//espacioMemoria corresponde a la memoria ocupada por un proceso

	public boolean reSizeMemoryRAM(int espacioMemoria){
		if ((espacioRAM-espacioMemoria)>=0) { //si la ram aun tiene espacio para almacenar
			espacioRAM -= espacioMemoria;
			System.out.println("Proceso agregado a la Ram con exito");
			printMemory();
			return true;                     //regresa verdadero en caso de que si
		}else{
			System.out.println("__________________________WARNING!!!___________________________________");
			System.out.println("Memoria de la RAM llena o espacio insuficiente para ingresar el proceso");
			System.out.println("__________________________WARNING!!____________________________________");
			return false;                   //Falso si esta llena o no cabe el siguiente proceso en la ram
		}
	} 
        
        public void freeMemory(int tamanioProcesoTermina)
        {
            espacioRAM = getSizeMemoryRAM() + tamanioProcesoTermina;
        }

	public int getSizeMemoryRAM(){//regresa el espacio de memoria que tiene la ram
		return espacioRAM;
	}

	public void printMemory(){//imprime el estado de la memoria
		System.out.println("Memoria total de la RAM: "+ Integer.toString(tamanioRAM)+ "[kilobytes]");
		System.out.println("Memoria disponible: "+Integer.toString(espacioRAM)+ "[kilobytes]");
		System.out.print("RAM: [");
		for (int i=0; i<Math.floor(espacioRAM/10); i++){
			System.out.print("|");
		}
		System.out.print("]"+Float.toString((espacioRAM*100)/tamanioRAM)+"%"); //mostrar el porcentaje disponible de la ram
		System.out.println(" ");
                System.out.println();
                
	}


}
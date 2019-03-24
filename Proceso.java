package planificador;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Proceso implements Comparable<Proceso>{
	private String nombreProceso;
	private int espacioMemoria,prioridad,tiempoLlegada;
	private float tiempoProceso;
	private int pid;

//===========================================
//este constructor solo es para pruebas
	public Proceso(){
		System.out.println("Funciona creacion proceso");
	}
//=============================================


	//constructor del proceso poniendo el ID y el nombre del proceso por defecto en el objeto

	public Proceso(int pid){
    	Scanner scaner = new Scanner(System.in);
		this.pid = pid;
		
		System.out.println("Ingresa el Nombre del proceso: ");
		setProcessName(scaner.nextLine()); //el usuario le da un nombre al proceso
														  //se mandan los parametros de ID y nombre al constructor
		System.out.println("Ingresa el tamanio del proceso en kilobytes: ");
		setSizeMemory(scaner.nextInt()); //asignacion de la espacioMemoria

		System.out.println("Tiempo de ejecucion del proceso:");
		setProcessTime(scaner.nextFloat()); //Asignacion de el tiempo de ejecucion

		System.out.println("prioridad del proceso:");
		setPriority(scaner.nextInt());      //asignacion de la prioridad

		System.out.println("Tiempo de llegada del proceso:");
		setTimeArrive(scaner.nextInt());
		scaner.nextLine();       //limpiar buffer despues de leer algun entero
		
	}
	//sets
	public void setProcessName(String nombreProceso){
		this.nombreProceso = nombreProceso;
	}

	public void setSizeMemory(int espacioMemoria){
		this.espacioMemoria = espacioMemoria;
	}

	public void setPriority(int prioridad){
		this.prioridad = prioridad;
	}

	public void setTimeArrive(int tiempoLlegada){
		this.tiempoLlegada = tiempoLlegada;
	}

	public void setProcessTime(float tiempoProceso){
		this.tiempoProceso = tiempoProceso;
	}
//gets
	public String getProcessName(){
		return nombreProceso;
	}

	public int getSizeMemory(){
		return espacioMemoria;
	}

	public int getPriority(){
		return prioridad;
	}
	public int getTimeArrive(){
		return tiempoLlegada;
	}

	public float getProcessTime(){
		return tiempoProceso;
	}

	public String toString(){
		String impresion ="ID: "+Integer.toString(this.pid);
		impresion += "| Nombre Proceso: "+nombreProceso;
		impresion += "| Tamanio de rafaga: "+Integer.toString(espacioMemoria);
		impresion += "| Tiempo proceso: "+Float.toString(tiempoProceso);
		impresion += "| Prioridad proceso: "+Integer.toString(prioridad);
		impresion += "| Tiempo llegada: " +Integer.toString(tiempoLlegada);
		return impresion;
	}

	//No llogre que jalara
	@Override
    public int compareTo(Proceso o) {
        if(tiempoLlegada < o.tiempoLlegada)
        {
            return -1;
        }
        if(tiempoLlegada > o.tiempoLlegada)
        {
            return 1;
        }
        return 0;
    }



}
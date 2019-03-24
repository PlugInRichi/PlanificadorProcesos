package planificador;
import java.util.ArrayList;
import java.util.Collections;


public class Cola{
	ArrayList<Proceso> colaPL = new ArrayList<Proceso>(0);
	//Arraylist de objetos Proceso
	public void addCola(Proceso proceso){  //añadimos el proceso que nos manden a la cola 
		colaPL.add(proceso); 
		Collections.sort(colaPL);
                //System.out.println("Nuevo Proceso");
                //printCola();
	} 

	public Proceso delCola(){
		Proceso p = colaPL.get(0); 	//guardamos el objeto que hay en la primera posicion
		colaPL.remove(0);			//elimina el primer elemento de la cola
		
                //printCola();
		return p;					//regresamos el objeto que sacamos de la cola de procesos
	}
	//remueve un Proceso en especifico
	public void removeCola(int pos){
		colaPL.remove(pos);
	}

	//tamaño de la cola
	public int statusCola(){
		return colaPL.size();
	}

	//regresa un proceso de la cola
	public Proceso getProcesoInCola(int pos){
		Proceso p = colaPL.get(pos);
		return p;
	}


	public void printCola(){
		if (colaPL.size()>0){
			for (int i=0; i<colaPL.size(); i++){
				System.out.println(colaPL.get(i));
			}
		}else{
			System.out.println("La cola de procesos esta vacia");
		}
	}
}
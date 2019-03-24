package planificador;
import java.io.*;
import java.util.*;

public class CPU{
	public boolean ejecutaProceso(ColaRAM ram, int quantum)
	{
            Proceso procesoEnEjecucion = new Proceso();
            procesoEnEjecucion = ram.getProcesoInCola(0); //para no perder al proceso
            float time=0;
            float tiempo = procesoEnEjecucion.getProcessTime();
            
            if(procesoEnEjecucion.getProcessTime() > quantum)
            {
                for (int i = 0; i < quantum; i++) 
                {
                    time = procesoEnEjecucion.getProcessTime() - i;
                    System.out.println(procesoEnEjecucion.getProcessName()+" en ejecucion "+time+" ms");
                }
                //procesoEnEjecucion.setProcessTime(time); //para que se modifique en el objeto
            }
            else
            {
                for (int i = 0; i < tiempo; i++) 
                {
                    time = procesoEnEjecucion.getProcessTime() - i;
                    System.out.println(procesoEnEjecucion.getProcessName()+" en ejecucion "+time+" ms");
                }
            }
            procesoEnEjecucion.setProcessTime(time-1); //para que se modifique en el objeto
          
            if(procesoEnEjecucion.getProcessTime() > 0)
            {
                return true; //si es verdad, el proceso se tiene que formar en la cola de procesos listos
            }
            return false; //sino, el proceso ya ha terminado su ejecucion
	}
}

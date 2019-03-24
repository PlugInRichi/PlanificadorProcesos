package planificador;
public class RoundRobin{
	int entro,salio;
	static int quantum = 4;
        

	public static void startCPU(Cola colaProcesosListos){
		ColaRAM colaRAM = new ColaRAM(); //cola de procesos listos
		CPU cpu = new CPU();            //cola que funciona como RAM o CPU
		int i=0, tamUltimoProcess; //variable que simula los milisegundos
		Proceso proceso = new Proceso(); //Esta linea está ciclando
                colaProcesosListos.printCola();

                while(colaProcesosListos.statusCola() != 0 || colaRAM.statusCola() != 0)
                {
                    if(colaProcesosListos.statusCola() != 0)
                    {
                        for (int k=0; k<colaProcesosListos.statusCola(); k++)
                        {
                            if(colaRAM.reSizeMemoryRAM(colaProcesosListos.getProcesoInCola(0).getSizeMemory()))
                            {
                                colaRAM.addCola(colaProcesosListos.getProcesoInCola(0)); //lo agrega a la RAM
                                colaProcesosListos.delCola(); //lo borra de CPL
                                colaProcesosListos.printCola(); //imprime el estado de la CPL
                            }
                            else
                            {
                                break;//salir del ciclo for
                            }
                        }             
                    }
                    
                    tamUltimoProcess = proceso.getSizeMemory();
                    if(cpu.ejecutaProceso(colaRAM, quantum)) //esto se hace si el proceso no ha terminado su rafaga
                                                            //si ya la termino entonces ya no se forma, no hacemos nada
                    {
                        System.out.println("CPU regresa VERDAD");
                        proceso = colaRAM.getProcesoInCola(0);
                        tamUltimoProcess = proceso.getSizeMemory();
                        colaProcesosListos.addCola(proceso);
                        //colaRAM.delCola();
                    }
                    colaRAM.freeMemory(tamUltimoProcess); //se tiene que liberar la memoria porque ahora pasa a CPL
                    //colaRAM.delCola();
                    
                }                
	}
	//regresa el tiempo de rafaga que le queda al proceso
	public static int statusRafagaProceso(Proceso proceso){
		System.out.println("por hacer");
		return 0;
	}

}
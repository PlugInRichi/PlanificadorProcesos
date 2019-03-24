package planificador;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu{
	public int menu(String cadena, int n){

		Scanner scaner = new Scanner(System.in);
		int opcion;
		try{
			do{
				System.out.println("\nElije una opcion\n");
				System.out.println(cadena);
				opcion = scaner.nextInt();
				if (opcion < 1 || opcion >n){
					System.out.println("Error, Elije una opcion valida!");
				}
			}while(opcion < 1 || opcion >n);
			return opcion;
		}catch(InputMismatchException excepcion){
			System.out.println("Input rejected...");
			return -1;
		}
	}

}
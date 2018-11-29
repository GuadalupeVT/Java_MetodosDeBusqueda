import java.util.Random;
import java.util.Scanner;

class MetodosDeBusqueda{
	public static void BusquedaSecuencial (int []numeros) {
		Scanner leer= new Scanner(System.in);
		boolean existe=false;
		
		System.out.println("Ingrese el numero a buscar! ");
		int numBuscado=leer.nextInt();
		
		for(int b=0; b<numeros.length;b++) {
			if(numeros[b]==numBuscado) {
				System.out.println("El numero si existe, en la posicion "+(b+1));
				break;
			}else 
				existe=true;
			}
		     if(existe==true) {
				System.out.println("El numero no existe");
		     }
	}
}

public class PruebaMetodosDeBusqueda {

	public static void main(String[] args) {
		byte menu=0;
		Scanner entrada= new Scanner(System.in);
		int [] arregloDesordenado= new int [100];
		Random numeroAleatorio =new Random();
		for(int i=0; i<arregloDesordenado.length; i++) {
			arregloDesordenado[i]=numeroAleatorio.nextInt(100);
		}
		do {
			System.out.println("________MENU________");
			System.out.println("1. Busqueda Secuencial");
			System.out.println("2. Salir");
			menu=entrada.nextByte();
			switch(menu) {
			case 1: 
				System.out.println(" ~~~~~~~~~Busqueda Secuencial~~~~~~~~~");
				MetodosDeBusqueda.BusquedaSecuencial(arregloDesordenado.clone());
			}
			
		}while(menu!=2);

	}

}

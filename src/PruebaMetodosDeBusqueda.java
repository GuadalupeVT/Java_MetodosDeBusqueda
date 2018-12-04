import java.util.Random;
import java.util.Scanner;

class MetodosDeBusqueda{
	public static void ordenamientoQuickSort(int numeros[], int primero, int ultimo) {
		int i,j,pivote,aux;
		i=primero;
		j=ultimo;
		pivote=numeros[primero];
		while(i<j) {
			while(numeros[i]<=pivote && i<j) {
				i++;
			}
			while(numeros[j]>pivote) {
				j--;
			}
			if(i<j) {
				aux=numeros[i];
				numeros[i]=numeros[j];
				numeros[j]=aux;
			}
		}
		numeros[primero]=numeros[j];
		numeros[j]=pivote;
		if(primero<j-1) {
			ordenamientoQuickSort(numeros, primero, j-1);
		}
		if(j+1<ultimo) {
			ordenamientoQuickSort(numeros, j+1, ultimo);
		}
	}//Metodo ordenamientoQuickSort
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
	}//Busqueda secuencial
	
	public static int busquedaBinaria(int numeros[],int elemento) {
		int centro,primero,valorCentro,ultimo;
		primero=0;
		ultimo=numeros.length-1;
		while(primero <=ultimo) {
			centro=(primero+ultimo)/2;
			valorCentro=numeros[centro];
			if (elemento==valorCentro) {
				return centro;
			}else if(elemento<valorCentro) {
				ultimo=centro-1;
			}else {
				primero=centro+1;
			}
		}
		return -1;
	}//BusquedaBinaria
	
}//Class metodos de busqueda
class HashCero{
	int []arreglo;
	int tamanio,contador;
	
	public void HasCero(int tam) {
		tamanio=tam;
		arreglo=new int [tam];
		Arrays.fill(arreglo, -1);
	}
	public void funcionHash(int [] cadenaArreglo,int []arreglo) {
		int i;
		for (i=0; i<cadenaArreglo.length;i++) {
			int elemento =cadenaArreglo[i];
			int indiceArreglo=elemento%7;
		//	System.out.println("el indice es "+indiceArreglo+" para el elemento "+elemento);
			//traslado de colisiones
		    while(arreglo[indiceArreglo]!=-1) {
		    	indiceArreglo++;
			    //System.out.println(" ocurrio una colision para el indice "+(indiceArreglo-1)+
					//"cambiar al indice "+indiceArreglo);
			    indiceArreglo%=tamanio;
		    }
		    arreglo[indiceArreglo]=elemento;
		}
	}//funcionHash
	
	public int buscarClave(int elemento) {
		int indiceArreglo=elemento%7;
		int contador=0;
		
		while (arreglo[indiceArreglo]!=-1) {
			if(arreglo[indiceArreglo]==elemento) {
				System.out.println(" el elemento "+elemento
						+" fue encontrado en la posicion "+indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo%=tamanio;
			contador++;
			if(contador>7) {
				break;
			}
		}
		return -1;
	}//Buscar clave
	
}//class HashCero

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
			System.out.println("2. Busqueda Binaria");
			System.out.println("3. Salir");
			menu=entrada.nextByte();
			switch(menu) {
			case 1: 
				System.out.println(" ~~~~~~~~~Busqueda Secuencial~~~~~~~~~");
				MetodosDeBusqueda.BusquedaSecuencial(arregloDesordenado.clone());
				break;
			case 2:
				System.out.println(" ~~~~~~~~~Busqueda Binaria~~~~~~~~~");
				int [] arr=arregloDesordenado.clone();
				System.out.println("Ingrese el numero a buscar:");
				int elemento=entrada.nextInt();
				MetodosDeBusqueda.ordenamientoQuickSort(arr, 0, arr.length-1);
				int a=MetodosDeBusqueda.busquedaBinaria(arr, elemento);
				if(a!=1) {
					System.out.println("Se encontro el elemento!");
				}else {
					System.out.println("No se encontro el elemento!");
				}
				break;
			}
			
		}while(menu!=3);

	}

}

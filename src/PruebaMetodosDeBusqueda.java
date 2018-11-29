import java.util.Scanner;

class MetodosDeBusqueda{
	public void BusquedaSecuencial (int []numeros) {
		Scanner leer= new Scanner(System.in);
		boolean existe=false;
		
		System.out.println("Ingrese el numero a buscar! ");
		int numBuscado=leer.nextInt();
		
		for(int b=0; b<numeros.length;b++) {
			if(numeros[b]==numBuscado) {
				System.out.println("El numero si existe, en la posicion "+(b+1));
				break;
			}else {
				existe=true;
			}if(existe==true) {
				System.out.println("El numero no existe");
			}
		}
	}
}

public class PruebaMetodosDeBusqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

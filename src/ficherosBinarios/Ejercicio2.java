package ficherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2
{
	File fichero;
	
	public static void main(String[] args)
	{
		Scanner entrada = new Scanner(System.in);
		String ruta = "C:\\Users\\mario\\Desktop\\DAM\\Acceso a Datos\\EjerciciosFicherosBinarios\\puntos.dat";
		
		System.out.println("-- GUARDAR PUNTOS --");
//		System.out.println("\tIndique donde quiere guardar el fichero");
//		System.out.print("\tRuta: ");
//		ruta = entrada.nextLine();
//		System.out.print("\tNombre del fichero: ");
//		ruta += entrada.nextLine();
		
		int nPuntos = 10;
		ArrayList<Punto> puntos = new ArrayList<>();
		Punto punto;
		Random nAleatorio = new Random();
		String colores[] = {"Rojo", "Amarillo" , "Azul", "Verde"};
				
		// Creamos los puntos
		for(int i = 0; i < nPuntos; i++)
		{
			punto = new Punto(colores[nAleatorio.nextInt(4)], nAleatorio.nextInt(100), nAleatorio.nextInt(100));
			puntos.add(punto);
		}
		
		System.out.println("- Guardando puntos...");
		escribir(puntos, ruta);
		System.out.println("- Puntos guardados.");
		
		System.out.println("+ Recuperando puntos...");
		ArrayList<Punto> puntosLeidos = LeerArrayListPuntos(ruta);
		System.out.println("+ Puntos recuperados:");
		for(Punto p : puntosLeidos)
			System.out.println("\t" + p);
	}
	
	public static void escribir(ArrayList<Punto> lista, String rutaFichero) 
	{
		try {
			ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(rutaFichero));
			
			for(Punto p : lista)
				escritor.writeObject(p);
			
			escritor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static ArrayList<Punto> LeerArrayListPuntos(String ruta)
	{
		ArrayList<Punto> p = new ArrayList<>();
		Punto puntoLeido;

		try	{
			ObjectInputStream lector = new ObjectInputStream(new FileInputStream(ruta));

			while((puntoLeido = (Punto) lector.readObject()) != null)
				p.add(puntoLeido);
			
			lector.close();
		} catch (Exception e) {
			// Cuando se termina de leer el fichero se lanza un EOFException que nos indica que el stream
			// a terminado de leer este
		}

		return p;
	}
	public static void guardarArrayListPuntos(ArrayList<Punto> p, String archivo)
	{
		try {
			ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo));
			
			escritor.writeObject(p);
			
			escritor.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
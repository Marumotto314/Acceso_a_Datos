package examenPrimeraEvaluacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class QuerolMarioEx1T
{
	public static void main(String[] args)
	{
		// Variables donde almacenaremos la información pertinente (cada campo estará separado por un tabulador)
		String nombres[] 	= 	{"Diana", "Carmen", "Angela"};
		String apellidos[] 	= 	{"Ruiz"	, "Rey", "Ibañez"};
		int edades[] 		= 	{17, 19, 20};
		double estaturas[] 	=	{1.75, 1.73, 1.69};
		
		String nombreFichero = "QuerolMario.txt";
		crearArchivo(nombreFichero, nombres, apellidos, edades, estaturas);
		mostrarArchivo(nombreFichero);
		ArrayList<String> contenido = leerArchivo(nombreFichero);
		mostrarArray(contenido);
		escribirFicheroBinario(nombreFichero, "QuerolMario.dat");
	}
	
	private static void escribirFicheroBinario(String nombreFichero, String ficheroBinario)
	{
		try {
			Scanner lector = new Scanner(new File(nombreFichero));
			FileOutputStream escritor = new FileOutputStream(new File(ficheroBinario));
			
			while(lector.hasNextLine()) 
			{
				escritor.write(lector.nextLine().getBytes());
			}
			System.out.println("-> Fichero convertido en binario.");
		} catch (Exception e){
			System.out.println("Fallo al convertir a binario el archivo");
		}
	}
	private static void mostrarArray(ArrayList<String> contenido)
	{
		for(String l : contenido)
		{
			System.out.println(l);
		}
		System.out.println("-> Array mostrado.");
	}
	private static ArrayList<String> leerArchivo(String nombreFichero)
	{
		ArrayList<String> c = new ArrayList<>();
		try {
			Scanner lector = new Scanner(new File(nombreFichero));
			while(lector.hasNextLine()) 
			{
				c.add(lector.nextLine());
			}
			System.out.println("-> Fichero leido.");
		} catch (Exception e) {
			System.out.println("Fallo al leer el archivo");
		}
		return c;
	}
	private static void mostrarArchivo(String nombreFichero)
	{
		try{
			Scanner lector = new Scanner(new File(nombreFichero));
			while(lector.hasNextLine()) 
			{
				System.out.println(lector.nextLine());
			}
			System.out.println("-> Fichero mostrado.");
		} catch (FileNotFoundException e) {
			System.out.println("Fallo al mostrar el archivo");
		}
	}
	private static void crearArchivo(String nombreFichero, String[] n, String[] a, int[] ed, double[] est)
	{
		try {
		Formatter formater = new Formatter(new File(nombreFichero));
		
		for(int i = 0; i < n.length; i++)// En este caso todos los array comparten tamaño
		{
			formater.format("%s\t%s\t%d\t%.2f\n",n[i], a[i], ed[i], est[i]);
		}
		System.out.println("-> Fichero creado.");
		
		formater.close();
		} catch (Exception e) {
			System.out.println("Fallo al crear el archivo");
		}
	}
}

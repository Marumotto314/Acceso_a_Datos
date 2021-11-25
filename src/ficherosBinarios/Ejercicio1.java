package ficherosBinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * 
 * @author mario
 */
public class Ejercicio1 
{
	public static void main(String[] args) throws Exception
	{
		Scanner entrada = new Scanner(System.in);
		String ruta = "C:\\Users\\mario\\Desktop\\DAM\\Acceso a Datos\\EjerciciosFicherosBinarios\\foto.jpg";
		
		System.out.println("--- COPIADOR DE FICHEROS ---");
//		System.out.print("Ruta del fichero: ");
//		ruta = entrada.nextLine();
//		System.out.print("Nombre del fichero: ");
//		ruta += entrada.nextLine();
		
		// Creamos objeto File
		File fichero = new File(ruta);
		
		
		if(fichero.exists() == false)
		if(!fichero.exists())
			throw new Exception("El fichero no existe.");
		
		// Creamos la copia
		String rutaCopia = fichero.getParent() + "\\copia_" + fichero.getName();
		File ficheroCopia = new File(rutaCopia);
		FileInputStream lector = new FileInputStream(fichero);
		FileOutputStream escritor = new FileOutputStream(ficheroCopia);
		
		int byteLeido;// Variable donde iremos almacenando los bytes que vayamos leyendo

		System.out.println("Copiando fichero " + fichero.getAbsolutePath());
		// Leemos el fichero y según vamos leyendo lo vamos copiando 
		while((byteLeido = lector.read()) != -1)
			escritor.write(byteLeido);
		
		System.out.println("Fichero copiado");
		System.out.println("Fichero copia: " + ficheroCopia.getAbsolutePath());
	}
}

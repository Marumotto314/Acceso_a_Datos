package ficherosBinarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Esta clase actualizará las transacciones que hayan ocurrido y que estén reflejadas en el fichero de texto
 * @author mario
 */
public class Ejercicio5
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String rutaCuentas = "C:\\Users\\mario\\Desktop\\DAM\\Acceso a Datos\\EjerciciosFicherosBinarios\\Cuentas.txt";
		String rutaMovimientos = "C:\\Users\\mario\\Desktop\\DAM\\Acceso a Datos\\EjerciciosFicherosBinarios\\Movimientos.txt";
		
		File cuentas = new File(rutaCuentas);
		
		Scanner lectorCuentas = new Scanner(new File(rutaCuentas));
		Scanner lectorMovimientos = new Scanner(new File(rutaMovimientos));
		Formatter formateador = new Formatter(new File(cuentas.getParent() + "\\Actualizado_" + cuentas.getName()));
		
		int nCuenta, cantidad, indiceInicio = 0, indiceFinal = 0;
		double movimiento;
		String nombre, lineaLeida, primeraLineaCuentas;
		ArrayList<Cuenta> listaCuentas = new ArrayList<>();

		/* LEEMOS EL FICHERO CUENTAS PARA SUBTRAER CADA CUENTA CON SUS RESPECTIVOS DATOS */
		System.out.print("Leyendo cuentas");
		primeraLineaCuentas = lectorCuentas.nextLine();// Nos saltamos la primera línea que contiene la información de cada columna
		while(lectorCuentas.hasNextLine()) 
		{
			lineaLeida = lectorCuentas.nextLine();

			// Leemos el nCuenta
			indiceFinal = lineaLeida.indexOf("\t", indiceInicio);
			nCuenta = Integer.parseInt(lineaLeida.substring(indiceInicio, indiceFinal));
			
			// Leemos el nombre
			indiceInicio = indiceFinal+1;
			indiceFinal = lineaLeida.indexOf("\t", indiceInicio);
			nombre = lineaLeida.substring(indiceInicio, indiceFinal);

			// Leemos el saldo
			indiceInicio = indiceFinal+1;// No calculamos el índice final porque ya es el final de la línea
			cantidad = Integer.parseInt(lineaLeida.substring(indiceInicio));
			
			indiceInicio = 0;
			indiceFinal = 0;
			listaCuentas.add(new Cuenta(nCuenta, nombre, cantidad));
			
			codigoVisual();
	    }
		System.out.println("\n\t-> Cuentas leídas.");
		
		/* LEEMOS EL FICHERO DE MOVIMIENTOS PARA POSTERIORMENTE ACTUALIZAR LA INFORMACIÓN */
		System.out.print("Leyendo movimientos");
		lectorMovimientos.nextLine();// Nos saltamos la primera línea que contiene la información de cada columna
		while(lectorMovimientos.hasNextLine()) 
		{
			lineaLeida = lectorMovimientos.nextLine();
			
			// Leemos el nCuenta
			indiceFinal = lineaLeida.indexOf("\t", indiceInicio);
			nCuenta = Integer.parseInt(lineaLeida.substring(indiceInicio, indiceFinal));
			
			// Leemos el movimiento
			indiceInicio = indiceFinal+1;// No calculamos el índice final porque ya es el final de la línea
			
			// Antes de guardar la variable hay que comprobar que tenga un signo negativo delante
			if(lineaLeida.charAt(indiceInicio) == '-')
				movimiento = -Double.parseDouble(lineaLeida.substring(indiceInicio+1));
			else
				movimiento = Double.parseDouble(lineaLeida.substring(indiceInicio));
			
			for(Cuenta c : listaCuentas)
			{
				if(c.getnCuenta() == nCuenta)
					c.actualizar(movimiento);
			}
			
			indiceInicio = 0;
			indiceFinal = 0;
			
			codigoVisual();
	    }
		System.out.println("\n\t-> Movimientos leídos.");
				
		/* AHORA VAMOS A AÑADIR LA INFORMACIÓN ACTUALIZA AL NUEVO FICHERO */
		System.out.print("Actualizando cuentas");
		formateador.format("%s\n", primeraLineaCuentas);
		for(Cuenta c : listaCuentas)
		{
			formateador.format("%d\t%s\t%.2f\n", c.getnCuenta(), c.getNombre(), c.getBono());
			
			codigoVisual();
		}
		System.out.println("\n\t-> Cuentas Actualizadas. \n\t-> Revise el fichero.");

		lectorCuentas.close();
		formateador.close();
	}
	private static void codigoVisual()
	{
		System.out.print(".");
		try { Thread.sleep(1000); } catch (Exception e) {}
		// No hacemos nada con la excepción porque solo el visual, si se diese que continue la ejecución
	}
}

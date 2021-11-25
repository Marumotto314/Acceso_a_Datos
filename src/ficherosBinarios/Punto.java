package ficherosBinarios;

import java.io.Serializable;

public class Punto implements Serializable
{
	// Atributos
	private int coordX;
	private int coordY;
	private String color;
	private static final long serialVersionUID = 1L;
	
	// Constructores
	public Punto(String color, int coordX, int coordY)
	{
		this.color = color;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	// Métodos
	@Override
	public String toString()
	{
		return String.format("%s(%d,%d)", color, coordX, coordY);
	}
	public int getCoordX()
	{
		return coordX;
	}
	public int getCoordY()
	{
		return coordY;
	}
	public String getColor()
	{
		return color;
	}
	
}

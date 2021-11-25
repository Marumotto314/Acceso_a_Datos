package ficherosBinarios;

public class Cuenta
{
	// Atributos
	private int nCuenta;
	private String nombre;
	private double bono;
	
	// Constructores
	public Cuenta(int nCuenta, String nombre, double bono)
	{
		this.nCuenta = nCuenta;
		this.nombre = nombre;
		this.bono = bono;
	}

	// Métodos
	public void actualizar(double bono)
	{
		this.bono += bono;
	}
	public int getnCuenta()
	{
		return nCuenta;
	}
	public String getNombre()
	{
		return nombre;
	}
	public double getBono()
	{
		return bono;
	}
}
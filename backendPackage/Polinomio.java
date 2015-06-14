package backendPackage;

import org.apache.commons.math3.analysis.polynomials.*;

public class Polinomio {

	public String nombre;
	public PolynomialFunction poli;
	
	public Polinomio(double[] coefs, String nom)
	{
		this.nombre = nom;
		poli = new PolynomialFunction(coefs);
	}
	
	public String imprimir()
	{
		String S = poli.toString();
		return nombre + " = " + S;
	}
}

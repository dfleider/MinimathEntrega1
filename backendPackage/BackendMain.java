package backendPackage;



public class BackendMain {
	
	//public static Variables variables;
	static Evaluador evaluador = new Evaluador();
	
	public static String main(String exp)
	{		

		// Detecto si el string es una delcaraci�n de variables

		if(exp.startsWith("var"))
		{			
			String nombreVariable = exp.substring(3,exp.indexOf("=")).trim();
			String valorVariable=exp.substring(exp.indexOf("=")+1).trim();
			evaluador.agregarVariable(nombreVariable, valorVariable);
			return "";
		}
		
		

		else if(exp.startsWith("fun"))
		{
			Convertidor con = new Convertidor(exp,2);
			evaluador.agregarFuncion(con.pedazos, con.nombreFunc);
			return "";
		}
		else if(exp.startsWith("eval"))
		{
			String nombreFuncion = exp.substring(5, exp.indexOf("("));
			String valorVar = exp.substring(exp.indexOf("(")+1, exp.indexOf(")"));
			double resultado = evaluador.evaluarFuncion(nombreFuncion, valorVar);
			if (resultado == 0.00000000000239444882931) return "Funcion mal evaluada";
			else return String.valueOf(resultado);
			
		}
		else if (exp.startsWith("pol"))
		{
			String poli = exp.substring(exp.indexOf("(")+1, exp.length()-1);
			poli.replace(" ","");
			String[] cofs = poli.split(",");
			double[] coefsD = new double[cofs.length-1];
			
			try
			{
				for(int i=1; i<cofs.length;i++)
				{
					coefsD[i-1] = Double.parseDouble(cofs[i]);
				}
				evaluador.agregarPolinomio(cofs[0], coefsD);
				return evaluador.ultimoPolinomio();
			}
			catch (Exception e)
			{
				return "polinomio mal entregado. Forma correcta es:"
						+ " pol (a,-b,c...) para a - b*x + c*x^2...";
			}
		}
		else if (exp.startsWith("peval"))
		{
			try
			{
				exp.replace(" ", "");
				String nombre = exp.substring(exp.indexOf("(") + 1, exp.indexOf(","));
				String valorS = exp.substring(exp.indexOf(",") + 1, exp.indexOf(")"));

				double valor = Double.parseDouble(valorS);
				return "" + evaluador.evaluarPolinomio(nombre, valor);
			}
			catch (Exception e)
			{
				return "función peval mal usada. Forma es: peval (p, 5) para evaluar polinomio p con valor 5";
			}
		}
		else if (exp.startsWith("pop"))
		{
			try
			{
				exp.replace(" ","");
				String n1 = exp.substring(exp.indexOf("(") + 1, exp.indexOf(","));
				String n2 = exp.substring(exp.indexOf(",") + 1, exp.indexOf(",", exp.indexOf(",") + 1));
				String operador = exp.substring(exp.indexOf(",", exp.indexOf(",") + 1) + 1, exp.indexOf(")"));
		
				return evaluador.operarPolinomios(n1, n2, operador);
			}
			catch (Exception e)
			{
				return "pop mal utilizado. Forma correcta es pop (p,q,+) para hacer"
						+ " p + q";
			}
		}

		else
		{
		    if (VerificadorParentesis.verificaParentesis(exp))
		    {
		    	Convertidor con = new Convertidor(exp, 1);
		    	evaluador.entregarRPN(con.pedazos);
		    	evaluador.variablesANumeros();
		    	
		    	double resultado = evaluador.evaluarRPN();

		    	if(resultado == 0.00000001)
		    		return "Expresion con error";
		        return ""+resultado;

		    }
		    else
		    {
		        System.out.println("Expresion no tiene misma cantidad de parentesis izquierdos y derechos");
		        return "Expresion con incorrectos ()";
		    }
		}
	}
}
	


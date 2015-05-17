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
			//System.out.print("->"+nombreVariable);
			String valorVariable=exp.substring(exp.indexOf("=")+1).trim();
			//System.out.print("->"+valorVariable);
			//variables.almacena(nombreVariable,valorVariable);
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
			System.out.print("\n ANS: " + resultado);
			return "" + resultado;
		}
		else
		{
		    if (VerificadorParentesis.verificaParentesis(exp))
		    {
		    	Convertidor con = new Convertidor(exp, 1);
		    	evaluador.entregarRPN(con.pedazos);
		    	evaluador.variablesANumeros();
		    	
		    	double resultado = evaluador.evaluarRPN();
		        System.out.println("\n ANS: " + resultado);
		    	
		        return ""+resultado;
		    	/*
		        String[] expresion = Separador.separar(exp); 
		        String[] output = InfixRPN.infixRPN(expresion);
		        
		        for (String token : output) {  
		            System.out.print(token + " ");  
		        }  
		        
		        double resultadoFinal = EvaluarRPN.evaluarRPN(output);
		        
		        System.out.println("\n" + resultadoFinal);
		        return ""+resultadoFinal;
		        */
		    }
		    else
		    {
		        System.out.println("Expresion no tiene misma cantidad de parentesis izquierdos y derechos");
		        return "";
		    }
		}
	}
	
}

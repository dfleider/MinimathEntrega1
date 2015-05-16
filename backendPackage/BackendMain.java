package backendPackage;



public class BackendMain {
	
	public static Variables variables;
	
	
	public static String main(String exp)
	{
		// Detecto si el string es una delcaraci�n de variables
		if(exp.startsWith("var"))
		{			
			String nombreVariable = exp.substring(3,exp.indexOf("=")).trim();
			System.out.print("->"+nombreVariable);
			String valorVariable=exp.substring(exp.indexOf("=")+1).trim();
			System.out.print("->"+valorVariable);
			variables.almacena(nombreVariable,valorVariable);
			return "";
		}
		
		else
		{
		    if (VerificadorParentesis.verificaParentesis(exp))
		    {
		        String[] expresion = Separador.separar(exp); 
		        String[] output = InfixRPN.infixRPN(expresion);
		        
		        for (String token : output) {  
		            System.out.print(token + " ");  
		        }  
		        
		        double resultadoFinal = EvaluarRPN.evaluarRPN(output);
		        
		        System.out.println("\n" + resultadoFinal);
		        return ""+resultadoFinal;
		    }
		    else
		    {
		        System.out.println("Expresion no tiene misma cantidad de parentesis izquierdos y derechos");
		        return "";
		    }
		}
    

	}
	
}

package backendPackage;



public class BackendMain {
	
	public static String main(String exp)
	{
		//if(exp.startsWith(var))
    
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

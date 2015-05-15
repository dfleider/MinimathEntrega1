package backendPackage;



public class BackendMain {
	
	public static void main()
	{
		
		String exp = "1+3";
	    
	    if (VerificadorParentesis.verificaParentesis(exp))
	    {
	        String[] expresion = Separador.separar(exp); 
	        String[] output = InfixRPN.infixRPN(expresion);
	        
	        for (String token : output) {  
	            System.out.print(token + " ");  
	        }  
	        
	        double resultadoFinal = EvaluarRPN.evaluarRPN(output);
	        
	        System.out.println("\n" + resultadoFinal);
	    }
	    else
	    {
	        System.out.println("Expresion no tiene misma cantidad de parentesis izquierdos y derechos");
	    }
	}
	
   
	
}

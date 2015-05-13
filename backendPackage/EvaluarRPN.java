package backendPackage;

import java.util.Stack;

public class EvaluarRPN {

	
    public static double evaluarRPN(String[] pedazos) // Basado en http://www.technical-recipes.com/2011/a-mathematical-expression-parser-in-java-and-cpp/
    {
        Stack<String> stack = new Stack<String>();
        
        for (String pedazo : pedazos)
        {
            if (Identificador.esNumero(pedazo))
            {
                stack.push(pedazo);
            } else if(Identificador.esOperador(pedazo))
            {
                double primero = Double.parseDouble(stack.pop().replace(",", "."));
                double segundo = Double.parseDouble(stack.pop().replace(",", "."));
                
                double resultado = 0;
                
                
                if (pedazo.equals("+"))
                { resultado = primero + segundo; }
                else if (pedazo.equals("-"))
                { resultado = segundo - primero; }
                else if (pedazo.equals("*"))
                { resultado = primero * segundo; }
                else if (pedazo.equals("/"))
                { resultado = segundo / primero; }
                else if (pedazo.equals("^"))
                { resultado = Math.pow(segundo, primero); }
                
                stack.push(String.valueOf(resultado));
            }
        }
        return Double.parseDouble(stack.pop());
    }
	
}

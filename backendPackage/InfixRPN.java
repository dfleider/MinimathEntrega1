package backendPackage;

import java.util.ArrayList;
import java.util.Stack;

public class InfixRPN {

	
    public static String[] infixRPN(String[] pedazos) //Basado en http://www.technical-recipes.com/2011/a-mathematical-expression-parser-in-java-and-cpp/
    {
        ArrayList<String> out = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
            
        for (String pedazo:pedazos)    //foreach sobre pedazos
        {
            if (Identificador.esNumero(pedazo))    // numero
            {
                out.add(pedazo);
            }
            else if(pedazo.equals("("))    //parentesis izquierdo
            {
                stack.push(pedazo);
            }
            else if(pedazo.equals(")"))    //parentesis derecho
            {
                while(!stack.empty() && !stack.peek().equals("("))
                {
                    out.add(stack.pop());
                }
                stack.pop();
            }
            
            else if(Identificador.esOperador(pedazo))// operador
            {
                while (!stack.empty() && Identificador.esOperador(stack.peek()))   
                {                      
                       out.add(stack.pop());     
                }  
                stack.push(pedazo);    // Push al nuevo operador del stack  
            }
        }
        while(!stack.empty())
        {
            out.add(stack.pop());       
        }
        String[] output = new String[out.size()];  
        return out.toArray(output);  
    }
	
}

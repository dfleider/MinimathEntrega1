package backendPackage;

import java.util.ArrayList;
import java.util.Stack;

public class Convertidor {
	public String[] pedazos;
	public String expresion;
	
	Operadores op;
	
	public Convertidor(String input)
	{
		op = new Operadores();
		this.expresion = input;
		
		separador();
		infixRPN();
	}
	
	private void separador()
	{
		expresion = expresion.replace(" ", "");
		ArrayList<String> lista = new ArrayList<String>();
		
		int i = 0;
		
		String aux = "";
		
		while (i < expresion.length())
		{
				if(op.esOperador(Character.toString(expresion.charAt(i)))
						|| Character.toString(expresion.charAt(i)).equals("(")
						|| Character.toString(expresion.charAt(i)).equals( ")"))
				{		
					if (!aux.equals(""))
					{
						lista.add(aux);										//Agregar todo lo que estaba antes del operador o parentesis
						aux = "";											// Reinicializar aux
					}
					
					lista.add(Character.toString(expresion.charAt(i)));	//Agregar operador
				} 
				else // Si es que es un numero
				{
					aux = aux + Character.toString(expresion.charAt(i));
				}
				i++;
		}
		
		if (!aux.equals(""))
		{
			lista.add(aux);
		}
		
		String[] output = new String[lista.size()];
		this.pedazos = lista.toArray(output);
	}
	
	private void infixRPN()
	{
		ArrayList<String> out = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
			
		for (String pedazo:this.pedazos)	//foreach sobre pedazos
		{
			if (op.esNumero(pedazo) || op.esVariable(pedazo))	// numero o variable
			{
				out.add(pedazo);
			}
			else if(pedazo.equals("("))	//parentesis izquierdo
			{
				stack.push(pedazo);
			}
			else if(pedazo.equals(")"))	//parentesis derecho
			{
				while(!stack.empty() && !stack.peek().equals("("))
				{
					out.add(stack.pop());
				}
				stack.pop();
			}
			
			else if(op.esOperador(pedazo))// operador
			{
                while (!stack.empty() && op.esOperador(stack.peek()))   
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
	    this.pedazos = out.toArray(output);  
	}
	

}

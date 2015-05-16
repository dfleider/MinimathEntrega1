package backendPackage;

import java.util.ArrayList;
import java.util.Stack;

public class Evaluador {
	String[] aEvaluar;
	Operadores op;
	public ArrayList<String[]> variables; //variables[0] = nombre, variables[1] = valor
	
	public Evaluador(String[] arregloRPN)
	{
		op = new Operadores();
		variables = new ArrayList<String[]>();
		this.aEvaluar = arregloRPN;
		//variablesANumeros();
	}
	
	public double evaluarRPN() // Basado en http://www.technical-recipes.com/2011/a-mathematical-expression-parser-in-java-and-cpp/
	{
		Stack<String> stack = new Stack<String>();
		
		for (String pedazo : this.aEvaluar)
		{
			if (op.esNumero(pedazo))
			{
				stack.push(pedazo);
			} 
			else if(op.esOperador(pedazo))
			{
				double primero = Double.parseDouble(stack.pop().replace(",", "."));
				double segundo = Double.parseDouble(stack.pop().replace(",", "."));
				
				double resultado = 0;
				
				if(pedazo.equals("+"))
				{resultado = primero + segundo;}
				else if (pedazo.equals("-"))
				{resultado = segundo - primero;}
				else if(pedazo.equals("*"))
				{resultado = primero * segundo;}
				else if(pedazo.equals("/"))
				{resultado = segundo / primero;}
				else if(pedazo.equals("^"))
				{resultado = Math.pow(segundo, primero);}
				
				/*
				switch(pedazo)
				{
					case "+":
						resultado = primero + segundo;
						break;
					case "-":
						resultado = segundo - primero;
						break;
					case "*":
						resultado = primero * segundo;
						break;
					case "/":
						resultado = segundo / primero;
						break;
					case "^":
						resultado = Math.pow(segundo, primero);
						break;
				}
				*/
				
				stack.push(String.valueOf(resultado));
			}
		}
		return Double.parseDouble(stack.pop());
	}
	
	public boolean agregarVariable(String nombre, String valor)
	{
		if (tryParseDouble(valor) == false || tryParseDouble(nombre) == true) 	// verifica primero que valor sea un numero o que nombre sea alfabetico
		{return false;}
		else
		{
			String[] datosVariable = {nombre, valor};
			this.variables.add(datosVariable);
			return true;
		}
	}
	
	public String[] procesarVariable(String variable) 	//por ejemplo, separa 2x en 2 y x
	{
		int i = 0;
		String nombreVariable="";
		String cantidadVariable="";
		
		while(i < variable.length())
		{
			if(tryParseDouble(variable.substring(0, i+1)))
			{i++;}
			else
			{
				if(i != 0)
				{
					cantidadVariable = variable.substring(0, i);
					nombreVariable = variable.substring(i);
					break;
				} 
				else
				{
					cantidadVariable = ""+ 1;
					nombreVariable = variable;
					break;
				}
			}
		}
		
		String[] retorno =  {nombreVariable, cantidadVariable};
		return retorno;
	}
	
	public void variablesANumeros() // puede venir tanto como x como 2x, hay que procesarla
	{
		int k = 0; // Para hacer while
		while(k < this.aEvaluar.length)
		{
			if(op.esVariable(aEvaluar[k]))
			{
				String[] varProcesada = procesarVariable(aEvaluar[k]);
				int i = 0;
				while(i < this.variables.size())
				{
					String[] varLista = this.variables.get(i);
					if(varProcesada[0].equals(varLista[0])) //Si tienen el mismo nombre, son la misma
					{
						
						double resultado = Double.parseDouble(varProcesada[1]) * Double.parseDouble(varLista[1]);	//Cantidad por valor
						aEvaluar[k] = resultado + "";
					}
					i++;
				}
			}
			k++;
		}
		
	}
	
	private boolean tryParseDouble(String numero)
	{
	     try  
	     {  
	         Double.parseDouble(numero);  
	         return true;  
	      } catch(NumberFormatException nfe)  
	      {  
	          return false;  
	      } 
	}
}

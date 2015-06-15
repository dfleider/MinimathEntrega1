package backendPackage;

import java.util.ArrayList;
import java.util.Stack;
<<<<<<< HEAD
=======
import org.apache.commons.math3.analysis.polynomials.*;
>>>>>>> development

public class Evaluador {
	String[] aEvaluar;
	Operadores op;
	public ArrayList<String[]> variables; //variables[0] = nombre, variables[1] = valor
	public ArrayList<String[]> funciones;
<<<<<<< HEAD
=======
	public ArrayList<Polinomio> polinomios;
>>>>>>> development
	
	public Evaluador()
	{
		op = new Operadores();
		variables = new ArrayList<String[]>();
		funciones = new ArrayList<String[]>();
<<<<<<< HEAD
=======
		polinomios = new ArrayList<Polinomio>();
>>>>>>> development
		//this.aEvaluar = arregloRPN;
		//variablesANumeros();
	}
	
	public void entregarRPN(String[] arregloRPN)
	{
		this.aEvaluar = arregloRPN;
	}
	
	public double evaluarRPN() // Basado en http://www.technical-recipes.com/2011/a-mathematical-expression-parser-in-java-and-cpp/
	{
		Stack<String> stack = new Stack<String>();
		
		try{
			
		
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
				
				stack.push(String.valueOf(resultado));
			}
			else if(op.esFuncionEspecial(pedazo))
			{
				double preimagen = Double.parseDouble(stack.pop().replace(",","."));
				
				double resultado = 0;
				if(pedazo.equals("sin"))
				{
					resultado = Math.sin(preimagen);
				}
				else if(pedazo.equals("cos"))
				{
					resultado = Math.cos(preimagen);
				}
				else if(pedazo.equals("tan"))
				{
					resultado = Math.tan(preimagen);
				}
				else if(pedazo.equals("exp"))
				{
					resultado = Math.exp(preimagen);
				}
				
				stack.push(String.valueOf(resultado));
			}
		}
		
		return Double.parseDouble(stack.pop());
		}
		catch(Exception ex){
			stack.clear();
<<<<<<< HEAD
			return 0.00000001; //representa un error de ingreso
=======
			return 0.00000000000239444882931; //representa un error de ingreso
>>>>>>> development
		}
	}
	
	public boolean agregarVariable(String nombre, String valor)
	{
		if (tryParseDouble(valor) == false || tryParseDouble(nombre) == true) 	// verifica primero que valor sea un numero o que nombre sea alfabetico
		{return false;}
		else
		{
			//Si variable esta agregada, actualizar, si no, agregar
			boolean existe = false;
			int i=0;
			String[] datosVariable = {nombre, valor};
			while(i < this.variables.size())
			{
				if(nombre.equals(this.variables.get(i)[0]))
				{
					existe = true;
					break;
				}
				i++;
			}
			if (existe)
			{
				this.variables.set(i, datosVariable);	//reemplaza
			}
			else
			{
				this.variables.add(datosVariable);		//nueva variable
			}
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
	
<<<<<<< HEAD
=======
	public void agregarPolinomio(String nombre, double[] coef)
	{	
		int i=0;
		boolean existe = false;
		while(i < polinomios.size())
		{
			if (nombre.equals(polinomios.get(i).nombre))
			{
				existe = true;
				break;
			}
			i++;
		}
		
		if(!existe)
		{
			Polinomio p = new Polinomio(coef, nombre);
			this.polinomios.add(p);
		} else
		{
			Polinomio p = new Polinomio(coef, nombre);
			this.polinomios.set(i, p);
		}
	}
	
	public String ultimoPolinomio()
	{
		String P = polinomios.get(polinomios.size()-1).imprimir();
		return P;
	}
	
	
	
>>>>>>> development
	public void agregarFuncion(String[] pedazos, String nombreFuncion)
	{
		String[] funcion = new String[pedazos.length + 1];
		funcion[0] = nombreFuncion;
		int i = 1;
		while (i < funcion.length)
		{
			funcion[i] = pedazos[i-1];
			i++;
		}
		
		int k = 0;	//reemplazar funcion si es que ya existe, crear nueva si es que no
		boolean existe = false;
		while(k<this.funciones.size())
		{
			if(nombreFuncion.equals(this.funciones.get(k)[0]))
			{
				existe = true;
				break;
			}
			k++;
		}
		if (existe)
		{
			this.funciones.set(k, funcion);	//reemplaza
		} else
		{
			this.funciones.add(funcion);	//agrega
		}
	}
	String nombreVariable="";	
	public String procesarVariable(String variable, String valor) 	//por ejemplo, separa 2x en 2 y x
	{
		int i = 0;

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
		
		String retorno =  Double.parseDouble(cantidadVariable)*Double.parseDouble(valor) + "";
		return retorno;
	}
	
	public double evaluarFuncion(String nombre, String valorVariable)
	{
		//Revisa que funcion existe
		
		int i = 0;
		boolean existe = false;
		
		while (i < this.funciones.size())
		{
			if(nombre.equals(this.funciones.get(i)[0]))
			{
				existe = true;
				break;
			}
			i++;
		}
		
		//Revisar que valorVariable sea numero o variable. Si es variable, reemplazar
		if(op.esVariable(valorVariable))
		{
			//procesar variable
			String[] var = procesarVariable(valorVariable);
			int b = 0;
			while (b<this.variables.size())
			{
				if (var[0].equals(this.variables.get(b)[0]))
				{
					valorVariable = Double.parseDouble(var[1]) * Double.parseDouble(this.variables.get(b)[1]) + "";
					break;
				}
			}
		}
			
		if(existe)	//Evaluar
		{
			int k = 0;
			
			String[] funcionOriginal = new String[this.funciones.get(i).length];	//Copia en variable auxiliar funcion original
			for(int a = 0; a < funcionOriginal.length; a++)
			{
				funcionOriginal[a] = this.funciones.get(i)[a];
			}
			
			String[] aEvaluarNuevo = new String[this.funciones.get(i).length-1];
			int z = 0;
			while (z < aEvaluarNuevo.length)
			{
				aEvaluarNuevo[z] = this.funciones.get(i)[z+1];
				z++;
			}
			this.aEvaluar = aEvaluarNuevo;	//En aEvaluar esta la funcion sin el nombre, solo la expresion
			variablesANumeros();	//Todas las variables declaradas las convierte a numeros
			
			while(k<this.aEvaluar.length)	// cambio todas las variables de la funcion a numeros
			{
				if(op.esVariable(this.aEvaluar[k]))
				{
					aEvaluar[k] = procesarVariable(aEvaluar[k], valorVariable);
				}
				k++;
			}

			this.funciones.set(i, funcionOriginal);	//Dejo la funcion como antes
			return evaluarRPN();
		}
		else
		{	
			System.out.print("Funcion pedida no existe");
			return 0;
		}
	}
<<<<<<< HEAD
=======
	
	public double evaluarPolinomio(String nombre, double valor)
	{
		double resultado = -0.000000001;
		
		for(Polinomio p: polinomios)
		{
			if (p.nombre.equals(nombre))
			{	
				resultado = p.poli.value(valor);
				break;
			}
		}
		
		return resultado;
	}
	
	public String operarPolinomios(String nombre1, String nombre2, String operador)
	{
		boolean exs1 = false;
		boolean exs2 = false;
		
		int p1=0;
		int p2=0;
		int i = 0;
		
		double[] a = {5,4};
		
		PolynomialFunction p3 = new PolynomialFunction(a);
		
		while(i<polinomios.size())
		{
			if(nombre1.equals(polinomios.get(i).nombre))
			{
				p1 = i;
				exs1 = true;
			}
			if(nombre2.equals(polinomios.get(i).nombre))
			{
				p2 = i;
				exs2 = true;
			}
			i++;
		}
		
		if (exs1 && exs2)
		{
			if (operador.equals("+"))
			{
				p3 = polinomios.get(p1).poli.add(polinomios.get(p2).poli);
			}
			else if (operador.equals("-"))
			{
				p3 = polinomios.get(p1).poli.subtract(polinomios.get(p2).poli);
			}
			else if (operador.equals("*"))
			{
				p3 = polinomios.get(p1).poli.multiply(polinomios.get(p2).poli);
			}
			return p3.toString();
		} else
		{
			return "no existen ambos polinomios pedidos";
		}
	}
>>>>>>> development
}

package backendPackage;

public class Operadores {

	public Operadores()
	{	}
	
	public boolean esNumero(String numero) // De: http://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric
	{												// y: http://stackoverflow.com/questions/21704583/regex-for-documentfilter-to-match-all-decimal-number-but-also-number-with-just-a
<<<<<<< HEAD
	    String pattern= "^[0-9]+[.]?[0-9]{0,}$"; // "^[0-9]*$";
=======
	    String p = numero.substring(0, 1);
	    if (p.equals("-")){
	    	numero=numero.substring(1, numero.length());
	    }
		
		String pattern= "^[0-9]+[.]?[0-9]{0,}$"; // "^[0-9]*$";
>>>>>>> development
        if(numero.matches(pattern)){
            return true;
        }
        return false;  
	}
	
	public boolean esVariable(String numero) // De: http://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric
	{												// y: http://stackoverflow.com/questions/21704583/regex-for-documentfilter-to-match-all-decimal-number-but-also-number-with-just-a
	    String pattern= "^[a-zA-Z0-9]*$";//"^[0-9]+[.]?[0-9]{0,}$"; // "^[0-9]*$";
        if(numero.matches(pattern) && !this.esNumero(numero) && !this.esFuncionEspecial(numero)){
            return true;
        }
        return false;  
	}
	
	public boolean esFuncionEspecial(String numero)
	{
<<<<<<< HEAD
		if (numero.equals("sin") || numero.equals("cos") || numero.equals("tan"))
=======
		if (numero.equals("sin") || numero.equals("cos") || numero.equals("tan") || numero.equals("exp"))
>>>>>>> development
		{return true;}
		else
		{return false;}
	}
	
	public boolean esOperador(String numero)
	{
		if (numero.equals("+") || numero.equals("-") ||
				numero.equals("*") || numero.equals("/")
				|| numero.equals("^"))
		{
			return true;
		} else
		{
			return false;
		}
	}
	
}

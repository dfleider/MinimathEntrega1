package backendPackage;

public class Operadores {

	public Operadores()
	{	}
	
	public boolean esNumero(String numero) // De: http://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric
	{												// y: http://stackoverflow.com/questions/21704583/regex-for-documentfilter-to-match-all-decimal-number-but-also-number-with-just-a
	    String pattern= "^[0-9]+[.]?[0-9]{0,}$"; // "^[0-9]*$";
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
		if (numero.equals("sin") || numero.equals("cos") || numero.equals("tan"))
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

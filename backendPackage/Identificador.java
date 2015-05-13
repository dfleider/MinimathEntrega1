package backendPackage;

public class Identificador {

	
    public static boolean esNumero(String numero) // De: http://stackoverflow.com/questions/11241690/regex-for-checking-if-a-string-is-strictly-alphanumeric
    {                                                // y: http://stackoverflow.com/questions/21704583/regex-for-documentfilter-to-match-all-decimal-number-but-also-number-with-just-a
        String pattern= "^[0-9]+[.]?[0-9]{0,}$"; // "^[0-9]*$";
        if(numero.matches(pattern)){
            return true;
        }
        return false;  
    }
    
    public static boolean esOperador(String numero)

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

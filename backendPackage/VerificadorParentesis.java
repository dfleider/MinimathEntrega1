package backendPackage;

public class VerificadorParentesis {

    public static boolean verificaParentesis(String expresion)
    {
        int i = 0;
        int izq = 0;
        int der = 0;
        
        while (i < expresion.length())
        {
            if (Character.toString(expresion.charAt(i)).equals("("))
            {
                izq++;
            } 
            else if (Character.toString(expresion.charAt(i)).equals(")"))
            {
                der++;
            }
            i++;
        }
        
        if (izq == der)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
	
}

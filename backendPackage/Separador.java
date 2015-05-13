package backendPackage;

import java.util.ArrayList;

public class Separador {

	
    public static String[] separar(String expresion)
    {
        expresion = expresion.replace(" ", "");
        ArrayList<String> lista = new ArrayList<String>();
        
        int i = 0;
        
        String aux = "";
        
        while (i < expresion.length())
        {
                if(Identificador.esOperador(Character.toString(expresion.charAt(i)))
                        || Character.toString(expresion.charAt(i)).equals("(")
                        || Character.toString(expresion.charAt(i)).equals( ")"))
                {        
                    if (!aux.equals(""))
                    {
                        lista.add(aux);                                        //Agregar todo lo que estaba antes del operador o parentesis
                        aux = "";                                            // Reinicializar aux
                    }
                    
                    lista.add(Character.toString(expresion.charAt(i)));    //Agregar operador
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
        return lista.toArray(output);
    }
	
}

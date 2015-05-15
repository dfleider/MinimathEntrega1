package backendPackage;

import java.util.ArrayList;
import java.util.List;

public class Variables {
	
	List<String> listaNombres = new ArrayList<String>();
	List<String> listaValores = new ArrayList<String>();


	public void almacena(String nombreVariable, String valorVariable) {
		
		listaNombres.add(nombreVariable);
		listaValores.add(nombreVariable);
				
		
	}

}

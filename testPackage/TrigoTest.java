package testPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import backendPackage.BackendMain;


public class TrigoTest {
	
	
	@Test
	public void testSingle(){
				BackendMain b = new BackendMain();
				b.main("fun f(x)=x-5");
				String resultado=b.main("eval f(6)");
				assertEquals("1.0",resultado);				
	}
	
	
		
	
}
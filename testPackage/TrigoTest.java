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
	
	@Test
	public void testDouble(){
				BackendMain b = new BackendMain();
				b.main("fun f(x)=x-5");
				b.main("fun g(x)=x+5");
				String resultado=b.main("eval f(6)+g(6)");
				assertEquals("12.0",resultado);				
	}
	
		
	
}
package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backendPackage.BackendMain;

public class TestFunciones {
	
	
	@Test
	public void testSingle(){
				BackendMain b = new BackendMain();
				String resultado=b.main("sin(0)");
				assertEquals("0.0",resultado);				
	}
	
	@Test
	public void testDouble(){
				BackendMain b = new BackendMain();
				String resultado=b.main("cos(0)");
				assertEquals("1.0",resultado);				
	}
	
			
	}
}
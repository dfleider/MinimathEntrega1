package testPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import backendPackage.BackendMain;


public class BasicTest {
	
	
	@Test
	public void testAdd(){
				BackendMain b = new BackendMain();
				String resultado=b.main("10+2");
				assertEquals("12.0",resultado);				
	}
	
	@Test
	public void testSubstract(){
				BackendMain b = new BackendMain();
				String resultado=b.main("2-1");
				assertEquals("1.0",resultado);				
	}
	
	@Test
	public void testMultiply(){
				BackendMain b = new BackendMain();
				String resultado=b.main("3*2");
				assertEquals("6.0",resultado);				
	}
	
	@Test
	public void testDivide(){
				BackendMain b = new BackendMain();
				String resultado=b.main("4/2");
				assertEquals("2.0",resultado);				
	}
	@Test
	public void testPow(){
				BackendMain b = new BackendMain();
				String resultado=b.main("2^3");
				assertEquals("8.0",resultado);				
	}
	@Test
	public void testComplejo(){
				BackendMain b = new BackendMain();
				String resultado=b.main("2+(3^2)-5+(8*2)-(8/2)");
				assertEquals("18.0",resultado);				
	}
}

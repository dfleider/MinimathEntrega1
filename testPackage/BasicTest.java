package testPackage;

import static org.junit.Assert.*;
import org.junit.Test;
import backendPackage.BackendMain;


public class BasicTest {
	
	
	@Test
	public void testAdd(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("10+2");
				String resultado2=b.main("5+(8)+2");
				String resultado3=b.main("(10+2)+7");
				String resultado4=b.main("5+(10+2)+7");
				assertEquals("12.0",resultado);
				assertEquals("15.0",resultado2);		
				assertEquals("19.0",resultado3);	
				assertEquals("24.0",resultado4);
	}
	
	@Test
	public void testSubstract(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("2-1");
				String resultado2=b.main("5-(3)+2");
				String resultado3=b.main("(10-2)-7");
				String resultado4=b.main("15-(10-2)-7");
				assertEquals("1.0",resultado);
				assertEquals("4.0",resultado2);		
				assertEquals("1.0",resultado3);	
				assertEquals("0.0",resultado4);			
	}
	
	@Test
	public void testMultiply(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("2*1");
				String resultado2=b.main("5(3*2)");
				String resultado3=b.main("(10*2)*7");
				String resultado4=b.main("15(10*2)*7");
				assertEquals("2.0",resultado);
				assertEquals("30.0",resultado2);		
				assertEquals("140.0",resultado3);	
				assertEquals("2100.0",resultado4);				
	}
	
	@Test
	public void testDivide(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("4/2");
				String resultado2=b.main("6/(3)/2");
				String resultado3=b.main("(10/2)/5");
				String resultado4=b.main("15/(10/2)/1");
				assertEquals("2.0",resultado);
				assertEquals("1.0",resultado2);		
				assertEquals("1.0",resultado3);	
				assertEquals("3.0",resultado4);					
	}
	@Test
	public void testPow(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("2^2");
				String resultado2=b.main("2^(3)^2");
				String resultado3=b.main("(3^2)^2");
				String resultado4=b.main("2^(1^3)^2");
				assertEquals("4.0",resultado);
				assertEquals("64.0",resultado2);		
				assertEquals("81.0",resultado3);	
				assertEquals("4.0",resultado4);				
	}
	@Test
	public void testComplejo(){
		
				BackendMain b = new BackendMain();
				String resultado=b.main("2+(3^2)-5+(8*2)-(8/2)");
				String resultado2=b.main("2(3^2)-5+(8*2)-(8/2)");
				assertEquals("18.0",resultado);		
				assertEquals("18.0",resultado2);	
	}
}

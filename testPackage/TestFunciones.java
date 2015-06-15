package testPackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import backendPackage.BackendMain;

public class TestFunciones {
	
	
	@Test
	public void testSin(){
				BackendMain b = new BackendMain();
				
				String resultado=b.main("sin(0)");
				assertEquals("0.0",resultado,0.1);
				
				String resultado2=b.main("sin(3.14/6)");
				assertEquals("0.5",resultado2,0.1);
				
				String resultado3=b.main("sin(3.14/4)");
				assertEquals("0.707",resultado3,0.1);
				
				String resultado4=b.main("sin(3.14/3)");
				assertEquals("0.866",resultado4,0.1);
				
				String resultado5=b.main("sin(3.14/2)");
				assertEquals("1.0",resultado5,0.1);
	}
	
	@Test
	public void testCos(){
				BackendMain b = new BackendMain();
				
				String resultado=b.main("cos(0)");
				assertEquals("1.0",resultado,0.1);
				
				String resultado2=b.main("cos(3.14/6)");
				assertEquals("0.866",resultado2,0.1);
				
				String resultado3=b.main("cos(3.14/4)");
				assertEquals("0.707",resultado3,0.1);
				
				String resultado4=b.main("cos(3.14/3)");
				assertEquals("0.5",resultado4,0.1);
				
				String resultado5=b.main("cos(3.14/2)");
				assertEquals("0.0",resultado5,0.1);
	}
	
	@Test
	public void testTg(){
				BackendMain b = new BackendMain();
				
				String resultado=b.main("tan(0)");
				assertEquals("0.0",resultado,0.1);
				
				String resultado2=b.main("tan(3.14/6)");
				assertEquals("0.577",resultado2,0.1);
				
				String resultado3=b.main("tan(3.14/4)");
				assertEquals("1",resultado3,0.1);
				
				String resultado4=b.main("tan(3.14/3)");
				assertEquals("1.73199",resultado4,0.1);
				

	}
	
	@Test
	public void testExp(){
				BackendMain b = new BackendMain();
				
				String resultado=b.main("exp(0)");
				assertEquals("1.0",resultado,0.0);
				
				String resultado2=b.main("exp(1)");
				assertEquals("2.71828182846",resultado2,0.001);
				
				String resultado3=b.main("exp(-3)");
				assertEquals("0.04978706836",resultado3,0.001);
				
				String resultado4=b.main("exp(2.2)");
				assertEquals("9.02501349943",resultado4,0.001);
				

	}
	
	@Test
	public void testPolynomial(){
		
				BackendMain b = new BackendMain();
				
				b.main("fun f(x)=x^2-x-5");
				b.main("fun g(x)=x^3+x^2+x-5");
				
				String resultado=b.main("eval f(6)");
				assertEquals("25.0",resultado);	
				
				String resultado2=b.main("eval g(3)");
				assertEquals("34.0",resultado2);
				
				String resultado3=b.main("eval g(3)+f(3)");
				assertEquals("35.0",resultado2);
				
				String resultado4=b.main("eval g(3)-f(3)");
				assertEquals("33.0",resultado2);
				
				

	
	}
				@Test
				public void testPolinomios(){
			
				BackendMain b = new BackendMain();
			
				b.main("pol ( p1,0,1,1)") ; // p1= x^2 + x
				b.main("pol ( p2,1,2,1)") ; // p1= x^2 + 2x + 1
				String resultado=b.main("peval p1(2)");
				assertEquals("6.0",resultado);
				String resultado2=b.main("pop(p1,p2,+)");
				assertEquals("2x^2+3x+1",resultado2);

	}
	
	
			
	}

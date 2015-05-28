package jUnitTesting;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Before;

public class TestSuiteOnlineShop extends TestCase{

	@Before
	public void setUp() throws Exception {
	}
	
	public static TestSuite suite(){
		
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(TestClient.class);
		suite.addTestSuite(TestCosCumparaturi.class);
		suite.addTestSuite(TestPromotie.class);
		
		return suite;
		
	}

}

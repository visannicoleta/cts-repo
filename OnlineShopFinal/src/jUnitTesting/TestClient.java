package jUnitTesting;

import junit.framework.TestCase;

import org.junit.Before;
import DesignPatterns.ProdusBuilder;

import clase.Client;
import clase.CosCumparaturi;
import clase.PlataCash;
import clase.Produs;
import exceptii.CosGolException;

public class TestClient extends TestCase {
	
	Client client;

	@Before
	public void setUp() throws Exception {
		CosCumparaturi cos = new CosCumparaturi();
		
		Produs prod = new ProdusBuilder()
		.setDenumire("Ciocolata Milka")
		.setPret(3.59)
		.setCantitate(20)
		.build();

		Produs prod2 = new ProdusBuilder()
		.setDenumire("Cereale Nesquik")
		.setPret(5.00)
		.setCantitate(5)
		.build();
		
		cos.adaugaProdus(prod);
		cos.adaugaProdus(prod2);
		cos.calculeazaValoareCos();
		
		client = new Client("Gigel", cos, new PlataCash());
		
	}
	
	//testare platesteComanda() cu valori normale
	public void testValoriNormalePlatesteComanda() throws CosGolException{
		double expected = 96.8;
		client.cos.calculeazaValoareCos();
		assertEquals("Test calculeazaValoareCos cu valori normale ", expected, client.cos.getValoareCos(), 0.0);
		
	}
	
	//testare platesteComanda() cu valori aberate (cos gol)
	public void testValoriAberantePlatesteComanda(){
		CosCumparaturi cos2 = new CosCumparaturi();
		Client client2 = new Client("Ana",cos2,new PlataCash());
		try{
			client2.cos.calculeazaValoareCos();
			assertFalse("Metoda nu arunca exceptie in cazul unui cos de cumparaturi gol", true);
		}catch(CosGolException ex){
			assertTrue(true);
		}
	}
	
	public void tearDown(){
//		System.out.println("tearDown function");
	}
}

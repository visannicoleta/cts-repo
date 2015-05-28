package jUnitTesting;

import junit.framework.TestCase;

import org.junit.Before;

import DesignPatterns.MementoCosCumparaturi;
import DesignPatterns.ProdusBuilder;

import clase.CosCumparaturi;
import clase.Produs;
import exceptii.CosGolException;

public class TestCosCumparaturi extends TestCase{
	
	CosCumparaturi cos;

	@Before
	public void setUp() throws Exception {
		
		cos = new CosCumparaturi();
		
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
	}

	//testare functie calculeazaValoareCos cu valori normale (cos cu produse)
	public void testValoriNormaleCalculeazaValoareCos() throws CosGolException{
		double expected = 96.8;
		cos.calculeazaValoareCos();
		assertEquals("Test calculeazaValoareCos cu valori normale ", expected, cos.getValoareCos());
		
	}
	
	//testare functie calculeazaValoareCos cu valori aberante (cos gol, fara produse)
	public void testValoriAberanteCalculeazaValoareCos(){
		
		CosCumparaturi cos2 = new CosCumparaturi();
		try{
			cos2.calculeazaValoareCos();
			assertFalse("Metoda nu arunca exceptie in cazul unui cos de cumparaturi gol", true);
		}catch(CosGolException ex){
			assertTrue(true);
		}
	}
	
	//testare functie trimiteComanda
	public void testCosGolTrimiteComanda(){
		CosCumparaturi cos2 = new CosCumparaturi();
		try{
			cos2.trimiteComanda();
			assertFalse("Metoda nu arunca exceptie in cazul unui cos de cumparaturi gol", true);
		}catch(CosGolException ex){
			assertTrue(true);
		}
	}
	
	//testare functie creareMemento
	public void testCosGolCreareMemento(){
		CosCumparaturi cos2 = new CosCumparaturi();
		try{
			MementoCosCumparaturi memento = cos2.creareMemento();
			cos2.setareMemento(memento);
			assertFalse("Metoda nu arunca exceptie in cazul unui cos de cumparaturi gol", true);
		}catch(CosGolException ex){
			assertTrue(true);
		}
	}
	
	public void tearDown(){
//		System.out.println("tearDown function");
	}

}

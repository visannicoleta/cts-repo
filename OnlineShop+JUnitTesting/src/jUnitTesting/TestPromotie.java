package jUnitTesting;

import junit.framework.TestCase;

import org.junit.Before;

import DesignPatterns.ProdusBuilder;

import clase.CosCumparaturi;
import clase.Produs;
import clase.Promotie;
import exceptii.CosGolException;
import exceptii.ProcentNegativException;
import exceptii.ProcentNullException;
import exceptii.ProcentPeste100Exception;
import exceptii.PromotieException;
import exceptii.VoucherValoareNegativaException;
import exceptii.VoucherValoareNulaException;
import exceptii.VoucherValoarePesteLimitaException;

public class TestPromotie extends TestCase{
	Promotie promo;
	CosCumparaturi cos;
	CosCumparaturi cosGol;

	@Before
	public void setUp() throws Exception {
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
		
		cos = new CosCumparaturi();
		cos.adaugaProdus(prod);
		cos.adaugaProdus(prod2);
		cos.calculeazaValoareCos();
		promo = new Promotie(10);
		
		cosGol = new CosCumparaturi();
	}

	//testare metoda aplicareDiscount
	//test cu valori normale (cos cu produse)
	public void testValoriNormaleAplicareDiscount() throws PromotieException{
		double expected = 87.12;
		promo.aplicareDiscount(cos);
		assertEquals("Test aplicareDiscount cu valori normale",expected, cos.getValoareCos(), 0.0);
	}
	
	//test cu valori aberante (cos gol)
	public void testCosCumparaturiGol() throws CosGolException{
		try{
			promo.aplicareDiscount(cosGol);
			assertFalse("Metoda nu arunca exceptie in cazul unui cos fara produse",true);
		}catch(PromotieException ex){
			assertTrue(true);
		}
	}

	//testare constructor pentru clasa Promotie
	//test procent negativ
	public void testProcentDiscountNegativ() throws PromotieException{
		try{
			Promotie promo2 = new Promotie(-10);
			promo2.aplicareDiscount(cos);
			assertFalse("Metoda nu arunca exceptie in cazul unui procent negativ de discount", true);
		}catch(ProcentNegativException ex){
			assertTrue(true);
		}
	}
	
	//test procent = 0
	public void testProcentNull() throws PromotieException{
		try{
			Promotie promo2 = new Promotie(0);
			promo2.aplicareDiscount(cos);
			assertFalse("Metoda nu arunca exceptie in cazul unui procent egal cu 0 de discount", true);
		}catch(ProcentNullException ex){
			assertTrue(true);
		}
	}
	
	//test procent > 100
	public void testProcentPeste100() throws PromotieException {
		try{
			Promotie promo2 = new Promotie(101);
			promo2.aplicareDiscount(cos);
			assertFalse("Metoda nu arunca exceptie in cazul unui procent mai mare decat 100%", true);
		}catch(ProcentPeste100Exception ex){
			assertTrue(true);
		}
	}
	
	//test procent limita = 100
	public void testProcentLimita() throws PromotieException{
		double expected = 0;
		Promotie promo2 = new Promotie(100);
		promo2.aplicareDiscount(cos);
		assertEquals("Test aplicareDiscount cu valori limita ",expected,cos.getValoareCos());
	}
	
	//testare metoda scadereVoucher
	//testare cu valori normale
	public void testValoriNormaleScadereVoucher() throws PromotieException{
		double expected = 86.8;
		promo.scadereVoucher(cos, 10);
		assertEquals("Test scadereVoucher cu valori normale ", expected, cos.getValoareCos());
	}
	
	//testare valoare voucher negativa
	public void testValoriNegativeScadereVoucher() throws PromotieException{
		try{
			promo.scadereVoucher(cos, -10);
			assertFalse("Metoda nu arunca exceptie in cazul unui voucher cu valoare negativa", true);
		}catch(VoucherValoareNegativaException ex){
			assertTrue(true);
		}
	}
	
	//testare valoare voucher = 0
	public void testValoareNulaScadereVoucher() throws PromotieException{
		try{
			promo.scadereVoucher(cos, 0);
			assertFalse("Metoda nu arunca exceptie in cazul unui voucher cu valoare egala cu 0", true);
		}catch(VoucherValoareNulaException ex){
			assertTrue(true);
		}
	}
	
	//testare valoare voucher > valoare cos cumparaturi
	public void testValoareVoucherPesteLimita() throws PromotieException{
		try{
			promo.scadereVoucher(cos, 5000);
			assertFalse("Metoda nu arunca exceptie in cazul unui voucher cu valoare mai mare decat valoarea cosului de cumparaturi", true);
		}catch(VoucherValoarePesteLimitaException ex){
			assertTrue(true);
		}
	}
	
	//testare scadereVoucher cand cos cumparaturi este gol
	public void testCosGolScadereVoucher() throws PromotieException{
		try{
			promo.scadereVoucher(cosGol, 10);
			assertFalse("Metoda scadereVoucher nu arunca exceptie in cazul unui cos fara produse",true);
		}catch(PromotieException ex){
			assertTrue(true);
		}
		
	}
	
}

package main;

import DesignPatterns.ProdusBuilder;
import clase.CareTakerCos;
import clase.Client;
import clase.CosCumparaturi;
import clase.PlataCash;
import clase.PlataCuCardul;
import clase.Produs;

public class TestareDesignPatterns {

	public static void main (String [] args){
		
		//testare Builder
		Produs prod = new ProdusBuilder()
							.setDenumire("Ciocolata Milka")
							.setPret(3.59)
							.setCantitate(20)
							.build();
		System.out.println(prod.toString());
		
		Produs prod2 = new ProdusBuilder()
							.setDenumire("Cereale Nesquik")
							.setPret(5.99)
							.setCantitate(5)
							.build();
		System.out.println(prod2.toString());
		
		Produs prod3 = new ProdusBuilder()
							.setDenumire("Portocale")
							.setPret(6.50)
							.setCantitate(3)
							.build();
		System.out.println(prod3.toString());
		
		Produs prod4 = new ProdusBuilder()
							.setDenumire("Coca Cola")
							.setPret(4.8)
							.setCantitate(5)
							.build();
		System.out.println(prod4.toString());
		
		CosCumparaturi cos1 = new CosCumparaturi();
		cos1.adaugaProdus(prod);
		cos1.adaugaProdus(prod2);
		
		CosCumparaturi cos2 = new CosCumparaturi();
		cos2.adaugaProdus(prod3);
		cos2.adaugaProdus(prod4);
		
		//testare Strategy
		Client gigel = new Client("Gigel", cos1, new PlataCash());
		gigel.platesteComanda();
		Client ana = new Client("Ana", cos2, new PlataCuCardul());
		ana.platesteComanda();
		
		//testare Memento
		CareTakerCos careTaker = new CareTakerCos();
		careTaker.adaugaSalvare(cos1.creareMemento());
		
		Produs p = new ProdusBuilder()
						.setDenumire("Iaurt")
						.setPret(1.25)
						.setCantitate(4)
						.build();
		cos1.adaugaProdus(p);
		cos1.afisareCos();
		
		cos1.setareMemento(careTaker.restaurareUltimaSalvare());
		cos1.afisareCos();
		
	}
}

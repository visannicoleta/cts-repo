package clase;

import exceptii.CosGolException;
import exceptii.PromotieException;
import DesignPatterns.ModPlataStrategy;


public class Client {
	String nume;
	public CosCumparaturi cos;
	ModPlataStrategy modPlata;
	
	public Client(String nume,CosCumparaturi cos, ModPlataStrategy mod){
		this.nume = nume;
		this.cos = cos;
		this.modPlata = mod;
	}
	
	public void platesteComanda() throws PromotieException{
		if(cos.produse.size() == 0) throw new CosGolException();
		System.out.println("Clientul "+ nume + ":");
		cos.afisareCos();
		System.out.println("Valoare comanda: ");
		cos.calculeazaValoareCos();
		cos.getValoareCos();
		this.modPlata.plateste();
	}
}

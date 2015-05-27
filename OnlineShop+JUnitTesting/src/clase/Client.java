package clase;

import DesignPatterns.ModPlataStrategy;


public class Client {
	String nume;
	CosCumparaturi cos;
	ModPlataStrategy modPlata;
	
	public Client(String nume,CosCumparaturi cos, ModPlataStrategy mod){
		this.nume = nume;
		this.cos = cos;
		this.modPlata = mod;
	}
	
	public void platesteComanda(){
		System.out.println("Clientul "+ nume + ":");
		cos.afisareCos();
		System.out.println("Valoare comanda: ");
		cos.getValoareCos();
		this.modPlata.plateste();
	}
}

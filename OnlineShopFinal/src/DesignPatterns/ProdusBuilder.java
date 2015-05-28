package DesignPatterns;

import clase.Produs;

public class ProdusBuilder {
	
	private Produs produs = null;
	
	public ProdusBuilder(){
		produs = new Produs();
	}
	
	public ProdusBuilder setDenumire(String denumire){
		produs.denumire = denumire;
		return this;
	}
	
	public ProdusBuilder setPret(double pret){
		produs.pret = pret;
		return this;
	}
	
	public ProdusBuilder setCantitate(float cantitate){
		produs.cantitate = cantitate;
		return this;
	}
	
	public Produs build(){
		return produs;
	}
}

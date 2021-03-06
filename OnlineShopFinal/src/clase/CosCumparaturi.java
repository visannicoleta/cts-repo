package clase;


import java.util.ArrayList;

import exceptii.CosGolException;

import DesignPatterns.MementoCosCumparaturi;

public class CosCumparaturi {
	double valoare = 0;
	ArrayList<Produs> produse;
	
	public CosCumparaturi(){
		produse = new ArrayList<>();
	}
	
	public void adaugaProdus(Produs produs){
		produse.add(produs);
	}
	
	public void stergeProdus(Produs produs){
		for(int i=0;i<produse.size();i++)
		{
			if((produse.get(i).denumire).equals(produs.denumire)){
				produse.remove(i);
			}
				
		}
	}
	
	public void afisareCos(){
		System.out.println("Cosul de cumparaturi cuprinde: ");
		for(int i=0;i<produse.size();i++){
			System.out.println(produse.get(i).toString());
		}
	}
	
	public void calculeazaValoareCos() throws CosGolException{
		valoare = 0;
		
		if(this.produse.size() == 0) throw new CosGolException();
		for(int i=0;i<produse.size();i++){
			valoare += produse.get(i).pret * produse.get(i).cantitate;
		}
	}
	public double getValoareCos(){	
		return valoare;
	}
	
	public void trimiteComanda() throws CosGolException{
		if(this.produse.size()==0) throw new CosGolException();
		System.out.println("Cosul a fost trimis cu succes !");
	}
	
	@SuppressWarnings("unchecked")
	public void setareMemento(MementoCosCumparaturi memento){
		produse = (ArrayList<Produs>) memento.cosCumparaturi.clone();
	}
	
	@SuppressWarnings("unchecked")
	public MementoCosCumparaturi creareMemento() throws CosGolException{
		if(this.produse.size() == 0) throw new CosGolException();
		MementoCosCumparaturi memento = new MementoCosCumparaturi();
		memento.cosCumparaturi = (ArrayList<Produs>) produse.clone();
		return memento;
	}
}

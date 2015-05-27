package clase;


import java.util.ArrayList;

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
	
	public void getValoareCos(){	
		for(int i=0;i<produse.size();i++){
			valoare += produse.get(i).pret * produse.get(i).cantitate;
		}
		System.out.println(valoare);
	}
	
	public void setareMemento(MementoCosCumparaturi memento){
		produse = (ArrayList<Produs>) memento.cosCumparaturi.clone();
	}
	
	public MementoCosCumparaturi creareMemento(){
		MementoCosCumparaturi memento = new MementoCosCumparaturi();
		memento.cosCumparaturi = (ArrayList<Produs>) produse.clone();
		return memento;
	}
}

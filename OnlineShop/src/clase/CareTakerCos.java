package clase;

import java.util.ArrayList;

import DesignPatterns.MementoCosCumparaturi;

public class CareTakerCos {
	
	ArrayList<MementoCosCumparaturi> salvari = new ArrayList<>();
	
	public void adaugaSalvare(MementoCosCumparaturi salvare){
		salvari.add(salvare);
	}
	
	public MementoCosCumparaturi restaurareUltimaSalvare(){
		if(salvari.size() > 0){
			MementoCosCumparaturi salvare = salvari.get(salvari.size()-1);
			salvari.remove(salvare);
			return salvare;
		}
		else return null;
	}
}

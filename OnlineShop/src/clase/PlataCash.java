package clase;

import DesignPatterns.ModPlataStrategy;

public class PlataCash implements ModPlataStrategy{

	@Override
	public void plateste() {
		System.out.println("Plata efectuata cash.");
	}

}
